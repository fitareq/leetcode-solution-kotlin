package problems

/**
 * 2557. Maximum Number of Integers to Choose From a Range II
 * https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-ii/
 *
 * You are given an integer array banned, two integers n and maxSum.
 *
 * You are choosing some number of integers following these rules:
 * - The chosen integers have to be in the range [1, n].
 * - Each integer can be chosen at most once.
 * - The chosen integers should not be in the array banned.
 * - The sum of the chosen integers should not exceed maxSum.
 *
 * Return the maximum number of integers you can choose following these rules.
 *
 * Example 1:
 * Input: banned = [1,4,6], n = 6, maxSum = 10
 * Output: 2
 * Explanation: We can choose the integers 2 and 3.
 * - 2 and 3 are in the range [1, 6].
 * - 2 and 3 are not in banned.
 * - Their sum is 5, which does not exceed maxSum = 10.
 * It can be proven that we cannot choose more than 2 integers.
 *
 * Example 2:
 * Input: banned = [4,3,5,6], n = 7, maxSum = 18
 * Output: 3
 * Explanation: We can choose the integers 1, 2, and 7.
 * - 1, 2, and 7 are in the range [1, 7].
 * - 1, 2, and 7 are not in banned.
 * - Their sum is 10, which does not exceed maxSum = 18.
 * It can be proven that we cannot choose more than 3 integers.
 *
 * Constraints:
 * - 1 <= banned.length <= 10^4
 * - 1 <= banned[i], n <= 10^9
 * - 1 <= maxSum <= 10^15
 */
class MaximumIntegersToChoose {
    /**
     * Time Complexity: O(n log n)
     * - Sorting banned array takes O(n log n)
     * - Binary search operations take O(log n)
     * - Where n is the length of banned array
     *
     * Space Complexity: O(1)
     * - Only uses a few variables regardless of input size
     */
    fun maxCount(banned: IntArray, n: Long, maxSum: Long): Int {
        // Sort banned array for binary search
        banned.sort()
        
        var count = 0L    // Count of chosen numbers
        var sum = 0L      // Sum of chosen numbers
        var current = 1L  // Current number being considered
        
        // Try to choose each number from 1 to n
        while (current <= n && sum + current <= maxSum) {
            // Skip if current number is banned
            if (banned.binarySearch(current.toInt()) >= 0) {
                current++
                continue
            }
            
            // Add current number to our selection
            sum += current
            count++
            current++
        }
        
        return count.toInt()
    }
}
