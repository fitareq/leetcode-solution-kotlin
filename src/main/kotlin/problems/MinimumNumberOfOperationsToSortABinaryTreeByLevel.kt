package problems

import java.util.*

/**
 * 2471.Minimum Number of Operations to Sort a Binary Tree by Level
 * https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/description/
 *
 * You are given the root of a binary tree with unique values.
 *
 * In one operation, you can choose any two nodes at the same level and swap their values.
 *
 * Return the minimum number of operations needed to make the values at each level sorted in a strictly increasing order.
 *
 * The level of a node is the number of edges along the path between it and the root node.
 *
 * Example 1:
 *
 *
 * Input: root = [1,4,3,7,6,8,5,null,null,null,null,9,null,10]
 * Output: 3
 * Explanation:
 * - Swap 4 and 3. The 2nd level becomes [3,4].
 * - Swap 7 and 5. The 3rd level becomes [5,6,8,7].
 * - Swap 8 and 7. The 3rd level becomes [5,6,7,8].
 * We used 3 operations so return 3.
 * It can be proven that 3 is the minimum number of operations needed.
 * Example 2:
 *
 *
 * Input: root = [1,3,2,7,6,5,4]
 * Output: 3
 * Explanation:
 * - Swap 3 and 2. The 2nd level becomes [2,3].
 * - Swap 7 and 4. The 3rd level becomes [4,6,5,7].
 * - Swap 6 and 5. The 3rd level becomes [4,5,6,7].
 * We used 3 operations so return 3.
 * It can be proven that 3 is the minimum number of operations needed.
 * Example 3:
 *
 *
 * Input: root = [1,2,3,4,5,6]
 * Output: 0
 * Explanation: Each level is already sorted in increasing order so return 0.
 *
 *
 * Constraints:
 *
 * - The number of nodes in the tree is in the range [1, 105].
 * - 1 <= Node.val <= 105
 * - All the values of the tree are unique.
 */
class MinimumNumberOfOperationsToSortABinaryTreeByLevel {

    /**
     * Approach:
     * 1. Use a queue to perform a level-order traversal of the tree.
     * 2. For each level, collect the node values into an array.
     * 3. Use the `countSwapsToSort` function to calculate the number of swaps needed to sort the array.
     * 4. Add the number of swaps to the total swap count.
     * 5. Return the total swap count after traversing all levels.
     *
     * Time Complexity:
     * - **Level Traversal**: O(n), where n is the total number of nodes in the tree.
     * - **Counting Swaps**: Sorting at each level takes O(k log k), where k is the number of nodes at the level.
     *   Summed over all levels, this becomes O(n log m), where m is the maximum number of nodes in any level.
     * - Overall Complexity: O(n log m).
     *
     * Space Complexity:
     * - The queue for level-order traversal requires O(w), where w is the maximum width of the tree.
     * - Sorting requires O(k) space for each level.
     * - Overall Space Complexity: O(w + k).
     */
    fun minimumOperations(root: TreeNode?): Int {
        var totalSwap = 0
        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)

        // Level-order traversal
        while (queue.isNotEmpty()) {
            val n = queue.size
            val childs = arrayListOf<Int>()

            // Collect all node values at the current level
            for (i in 0 until n) {
                val curr = queue.poll()
                childs.add(curr.`val`)

                // Add child nodes to the queue for the next level
                if (curr.left != null) queue.offer(curr.left)
                if (curr.right != null) queue.offer(curr.right)
            }

            // Calculate the swaps required to sort the current level
            totalSwap += countSwapsToSort(childs)
        }

        return totalSwap
    }

    private fun countSwapsToSort(arr: ArrayList<Int>): Int {
        // Create indexed pairs of (value, original index)
        val indexedArr = arr.mapIndexed { index, value -> value to index }.toTypedArray()
        indexedArr.sortBy { it.first } // Sort based on values

        val visited = BooleanArray(arr.size) { false }
        var swapCount = 0

        // Traverse cycles in the array
        for (i in arr.indices) {
            // Skip already visited or correctly positioned elements
            if (visited[i] || indexedArr[i].second == i) continue

            var cycleSize = 0
            var j = i

            // Count the size of the cycle
            while (!visited[j]) {
                visited[j] = true
                j = indexedArr[j].second // Move to the next index in the cycle
                cycleSize++
            }

            // Add (cycleSize - 1) swaps for this cycle
            if (cycleSize > 1) {
                swapCount += cycleSize - 1
            }
        }

        return swapCount
    }

}