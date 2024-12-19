package problems

import kotlin.math.max

/**
 * Max Chunks To Make Sorted
 * https://leetcode.com/problems/max-chunks-to-make-sorted/description
 *
 *
 * Problem Description:
 *
 * You are given an integer array `arr` of length `n` that represents a permutation of the integers in the range `[0, n - 1]`.
 *
 * We split `arr` into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them, the result
 * should equal the sorted array.
 *
 * Return the maximum number of chunks we can make to sort the array.
 *
 * Example 1:
 *
 * Input: arr = [4,3,2,1,0]
 * Output: 1
 * Explanation:
 * Splitting into two or more chunks will not return the required result.
 * For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
 *
 * Example 2:
 *
 * Input: arr = [1,0,2,3,4]
 * Output: 4
 * Explanation:
 * We can split into two chunks, such as [1, 0], [2, 3, 4].
 * However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
 *
 * Constraints:
 *
 * n == arr.length
 * 1 <= n <= 10
 * 0 <= arr[i] < n
 * All the elements of arr are unique.
 */
class MaxChunksToMakeSorted {
    /**
     * Time Complexity: O(n) - The array is traversed once, where `n` is the size of the array.
     * Space Complexity: O(1) - Only two variables (`count` and `maxSeen`) are used for computation.
     */
    fun maxChunksToSorted(arr: IntArray): Int {
        var count = 0
        var maxSeen = 0
        for (i in arr.indices) {
            // Update the maximum value encountered so far
            maxSeen = max(maxSeen, arr[i])
            // If the maximum value equals the current index, it forms a valid chunk
            if (maxSeen == i) {
                ++count
            }
        }
        return count
    }

    fun maxChunksToSortedAlternative(arr: IntArray): Int {
        return arr.foldIndexed(0 to 0) { i, (count, maxSeen), v -> if (max(maxSeen, v) == i) count + 1 to max(maxSeen, v) else count to max(maxSeen, v) }.first
    }
}