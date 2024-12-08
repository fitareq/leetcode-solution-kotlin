package problems

/**
 * Problem: Minimum Limit of Balls in a Bag
 * https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/
 *
 * You are given an integer array nums where the ith bag contains nums[i] balls. You are also given an
 * integer maxOperations.
 *
 * You can perform the following operation at most maxOperations times:
 * - Take any bag of balls and divide it into two new bags with a positive number of balls.
 * - For example, a bag of 5 balls can become two new bags of 1 and 4 balls, or two new bags of 2 and 3 balls.
 *
 * Your penalty is the maximum number of balls in a bag. You want to minimize your penalty after performing
 * the operations.
 *
 * Return the minimum possible penalty after performing the operations.
 *
 * Example:
 * Input: nums = [9], maxOperations = 2
 * Output: 3
 * Explanation:
 * - Divide the bag with 9 balls into two bags of sizes 6 and 3. [9] -> [6,3]
 * - Divide the bag with 6 balls into two bags of sizes 3 and 3. [6,3] -> [3,3,3]
 * The bag with the most number of balls has 3 balls, so your penalty is 3 and you cannot achieve a lower penalty.
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - 1 <= maxOperations <= 10^9
 * - 1 <= nums[i] <= 10^9
 *
 * @param nums Array of integers representing number of balls in each bag
 * @param maxOperations Maximum number of operations allowed
 * @return Minimum possible maximum number of balls in a bag after operations
 */
class MinimumLimitOfBalls {
    // Time: O(n * log(M)) where n is length of nums and M is max value in nums
    // Space: O(1)
    fun minimumSize(nums: IntArray, maxOperations: Int): Int {
        var left = 1
        var right = nums.maxOrNull() ?: 1
        
        while (left < right) {
            val mid = left + (right - left) / 2
            var operations = 0
            
            // Count operations needed for current penalty
            for (num in nums) {
                operations += (num - 1) / mid
            }
            
            // If operations needed exceed maxOperations, increase penalty
            if (operations > maxOperations) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        
        return left
    }

    /*
    // Time: O(n * log(M)) where n is length of nums and M is max value in nums
    // Space: O(1)
    fun minimumSize(nums: IntArray, maxOperations: Int): Int {
        // Helper function to check if we can achieve target penalty with given operations
        fun canAchievePenalty(penalty: Int): Boolean {
            var operations = 0
            for (num in nums) {
                operations += (num - 1) / penalty
                if (operations > maxOperations) return false
            }
            return true
        }
        
        var left = 1
        var right = nums.maxOrNull() ?: 1
        
        while (left < right) {
            val mid = left + (right - left) / 2
            if (canAchievePenalty(mid)) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        
        return left
    }
    */
}
