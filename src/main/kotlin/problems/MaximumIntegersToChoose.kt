package problems

/**
 * Problem: Maximum Number of Integers to Choose From a Range I
 * https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/
 *
 * You are given an integer array banned and two integers n and maxSum. You are choosing some number of
 * integers following these rules:
 * - The chosen integers have to be in the range [1, n].
 * - Each integer can be chosen at most once.
 * - The chosen integers should not be in the array banned.
 * - The sum of the chosen integers should not exceed maxSum.
 * Return the maximum number of integers you can choose following these rules.
 *
 * Example:
 * Input: banned = [1,6,5], n = 5, maxSum = 6
 * Output: 2
 * Explanation: You can choose the integers 2 and 4.
 * 2 and 4 are from the range [1, 5], both are not in banned, and their sum is 6,
 * which does not exceed maxSum.
 *
 * Constraints:
 * - 1 <= banned.length <= 10^4
 * - 1 <= banned[i], n <= 10^4
 * - 1 <= maxSum <= 10^9
 *
 * @param banned Array of banned integers
 * @param n Upper limit of range [1,n]
 * @param maxSum Maximum allowed sum of chosen integers
 * @return Maximum number of integers that can be chosen
 */
class MaximumIntegersToChoose {
    /**
     * Solution 1: Linear Scan with HashSet
     * Time Complexity: O(n)
     * Space Complexity: O(b) where b is the length of banned array
     */
    // Time: O(n), Space: O(b) where b is the length of banned array
    fun maxCount(banned: IntArray, n: Int, maxSum: Int): Int {
        val bannedSet = banned.filterTo(HashSet()) { it <= n }
        var sum = 0
        var numberCount = 0
        for (i in 1..n) {
            if (!bannedSet.contains(i)) {
                sum += i
                if (sum > maxSum) break
                ++numberCount
            }
        }
        return numberCount
    }

    /**
     * Alternative Solution 1: Optimized Early Termination
     * Time Complexity: O(min(n, maxSum))
     * Space Complexity: O(b) where b is the length of banned array
     */
    // Time: O(min(n, maxSum)), Space: O(b) where b is the length of banned array
    fun maxCountAlternative1(banned: IntArray, n: Int, maxSum: Int): Int {
        val bannedSet = banned.toSet()
        var sum = 0
        var count = 0
        var i = 1
        
        while (i <= n && sum + i <= maxSum) {
            if (!bannedSet.contains(i)) {
                sum += i
                count++
            }
            i++
        }
        
        return count
    }

    /**
     * Alternative Solution 2: Binary Search Approach
     * Time Complexity: O(log(n) * n)
     * Space Complexity: O(b) where b is the length of banned array
     */
    // Time: O(log(n) * n), Space: O(b) where b is the length of banned array
    fun maxCountAlternative2(banned: IntArray, n: Int, maxSum: Int): Int {
        val bannedSet = banned.toSet()
        var left = 0
        var right = n
        
        while (left < right) {
            val mid = (left + right + 1) / 2
            var sum = 0
            var count = 0
            
            for (i in 1..n) {
                if (count >= mid) break
                if (!bannedSet.contains(i)) {
                    sum += i
                    count++
                }
            }
            
            if (count == mid && sum <= maxSum) {
                left = mid
            } else {
                right = mid - 1
            }
        }
        
        return left
    }
}
