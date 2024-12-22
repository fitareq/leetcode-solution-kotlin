package problems

import kotlin.math.max
import kotlin.math.min

/**
 * **2940.Find Building Where Alice and Bob Can Meet**
 * https://leetcode.com/problems/find-building-where-alice-and-bob-can-meet/description
 *
 * You are given a 0-indexed array heights of positive integers, where heights[i] represents the height of the ith building.
 *
 * If a person is in building i, they can move to any other building j if and only if i < j and heights[i] < heights[j].
 *
 * You are also given another array queries where queries[i] = [ai, bi]. On the ith query, Alice is in building ai while Bob is in building bi.
 *
 * Return an array ans where ans[i] is the index of the leftmost building where Alice and Bob can meet on the ith query. If Alice and Bob cannot move to a common building on query i, set ans[i] to -1.
 *
 *
 *
 * Example 1:
 *
 * Input: heights = [6,4,8,5,2,7], queries = [[0,1],[0,3],[2,4],[3,4],[2,2]]
 * Output: [2,5,-1,5,2]
 * Explanation: In the first query, Alice and Bob can move to building 2 since heights[0] < heights[2] and heights[1] < heights[2].
 * In the second query, Alice and Bob can move to building 5 since heights[0] < heights[5] and heights[3] < heights[5].
 * In the third query, Alice cannot meet Bob since Alice cannot move to any other building.
 * In the fourth query, Alice and Bob can move to building 5 since heights[3] < heights[5] and heights[4] < heights[5].
 * In the fifth query, Alice and Bob are already in the same building.
 * For ans[i] != -1, It can be shown that ans[i] is the leftmost building where Alice and Bob can meet.
 * For ans[i] == -1, It can be shown that there is no building where Alice and Bob can meet.
 * Example 2:
 *
 * Input: heights = [5,3,8,2,6,1,4,6], queries = [[0,7],[3,5],[5,2],[3,0],[1,6]]
 * Output: [7,6,-1,4,6]
 * Explanation: In the first query, Alice can directly move to Bob's building since heights[0] < heights[7].
 * In the second query, Alice and Bob can move to building 6 since heights[3] < heights[6] and heights[5] < heights[6].
 * In the third query, Alice cannot meet Bob since Bob cannot move to any other building.
 * In the fourth query, Alice and Bob can move to building 4 since heights[3] < heights[4] and heights[0] < heights[4].
 * In the fifth query, Alice can directly move to Bob's building since heights[1] < heights[6].
 * For ans[i] != -1, It can be shown that ans[i] is the leftmost building where Alice and Bob can meet.
 * For ans[i] == -1, It can be shown that there is no building where Alice and Bob can meet.
 *
 *
 *
 * Constraints:
 *
 * - 1 <= heights.length <= 5 * 104
 * - 1 <= heights[i] <= 109
 * - 1 <= queries.length <= 5 * 104
 * - queries[i] = [ai, bi]
 * - 0 <= ai, bi <= heights.length - 1
 */

class FindBuildingWhereAliceAndBobCanMeet {
    /** **Time Complexity**:
     * - Segment Tree Construction: O(n), where `n` is the number of buildings.
     * - Query Processing:
     *   - Each query involves a binary search over the range [b, n-1], which takes O(log n) iterations.
     *   - Each binary search iteration performs a range maximum query, taking O(log n) time.
     *   - Total for one query: O(log^2 n).
     * - Total for all queries: O(m * log^2 n), where `m` is the number of queries.
     * - Overall: O(n + m * log^2 n).
     *
     * **Space Complexity**:
     * - Segment Tree Storage: O(n).
     * - Result Array Storage: O(m).
     * - Total: O(n + m).
     */

    private lateinit var segTree: IntArray

    /**
     * Builds the segment tree for storing the indices of the maximum heights in a given range.
     */
    private fun buildSegmentTree(heights: IntArray, start: Int, end: Int, treeIndex: Int): Int {
        if (start == end) {
            // Leaf node: Store the index of the current element.
            segTree[treeIndex] = start
            return segTree[treeIndex]
        }

        val mid = start + (end - start) / 2
        val leftIndex = buildSegmentTree(heights, start, mid, 2 * treeIndex + 1)
        val rightIndex = buildSegmentTree(heights, mid + 1, end, 2 * treeIndex + 2)

        // Store the index of the maximum height in the current range.
        segTree[treeIndex] = if (heights[leftIndex] >= heights[rightIndex]) leftIndex else rightIndex

        return segTree[treeIndex]
    }

    /**
     * Queries the segment tree for the index of the maximum height in a specified range.
     */
    private fun rangeMaxQuery(
        heights: IntArray,
        queryStart: Int,
        queryEnd: Int,
        start: Int,
        end: Int,
        treeIndex: Int
    ): Int {
        // Total overlap
        if (start >= queryStart && end <= queryEnd) {
            return segTree[treeIndex]
        }
        // No overlap
        if (start > queryEnd || end < queryStart) {
            return Int.MIN_VALUE
        }

        // Partial overlap
        val mid = start + (end - start) / 2
        val leftMax = rangeMaxQuery(heights, queryStart, queryEnd, start, mid, 2 * treeIndex + 1)
        val rightMax = rangeMaxQuery(heights, queryStart, queryEnd, mid + 1, end, 2 * treeIndex + 2)

        if (leftMax == Int.MIN_VALUE) return rightMax
        if (rightMax == Int.MIN_VALUE) return leftMax

        // Return the index of the maximum height
        return if (heights[leftMax] >= heights[rightMax]) leftMax else rightMax
    }

    /**
     * Processes a list of queries to determine the leftmost building index where Alice and Bob can meet.
     */
    fun leftmostBuildingQueries(heights: IntArray, queries: Array<IntArray>): IntArray {
        val n = heights.size
        segTree = IntArray(4 * n)
        val treeIndex = 0

        // Build the segment tree
        buildSegmentTree(heights, 0, n - 1, treeIndex)

        val res = arrayListOf<Int>()

        for ((a, b) in queries) {
            val alice = min(a, b)
            val bob = max(a, b)

            // Case 1: Alice and Bob are at the same position or Bob's building is taller than Alice's
            if (alice == bob || heights[bob] > heights[alice]) {
                res.add(bob)
                continue
            }

            // Binary search for the leftmost building taller than Alice's building
            var low = bob
            var high = n - 1
            var ans = Int.MAX_VALUE

            while (low <= high) {
                val mid = low + (high - low) / 2
                val rmq = rangeMaxQuery(heights, low, mid, 0, n - 1, treeIndex)

                if (heights[rmq] > heights[alice]) {
                    high = mid - 1
                    ans = min(ans, rmq) // Update answer with the leftmost index
                } else {
                    low = mid + 1
                }
            }

            // Add result or -1 if no valid building is found
            res.add(if (ans == Int.MAX_VALUE) -1 else ans)
        }
        return res.toIntArray()
    }
}
