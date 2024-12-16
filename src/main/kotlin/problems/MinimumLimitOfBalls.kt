package problems

/**
 * 1760. Minimum Limit of Balls in a Bag
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
 * Example 1:
 * Input: nums = [9], maxOperations = 2
 * Output: 3
 * Explanation:
 * - Divide the bag with 9 balls into two bags of sizes 6 and 3. [9] -> [6,3]
 * - Divide the bag with 6 balls into two bags of sizes 3 and 3. [6,3] -> [3,3,3]
 * The bag with the most number of balls has 3 balls, so your penalty is 3 and you cannot achieve a lower penalty.
 *
 * Example 2:
 * Input: nums = [2,4,8,2], maxOperations = 4
 * Output: 2
 * Explanation:
 * - Divide the bag with 8 balls into two bags of sizes 4 and 4. [2,4,8,2] -> [2,4,4,4,2]
 * - Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,4,4,4,2] -> [2,2,2,4,4,2]
 * - Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,4,4,2] -> [2,2,2,2,2,4,2]
 * - Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,2,2,4,2] -> [2,2,2,2,2,2,2,2]
 * The bag with the most number of balls has 2 balls, so your penalty is 2.
 *
 * Example 3:
 * Input: nums = [7,17], maxOperations = 2
 * Output: 7
 * Explanation:
 * - Divide the bag with 17 balls into two bags of sizes 7 and 10. [7,17] -> [7,7,10]
 * - Divide the bag with 10 balls into two bags of sizes 7 and 3. [7,7,10] -> [7,7,7,3]
 * The bag with the most number of balls has 7 balls, so your penalty is 7.
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - 1 <= maxOperations <= 10^9
 * - 1 <= nums[i] <= 10^9
 */
class MinimumLimitOfBalls {
    /**
     * Time Complexity: O(n * log(M))
     * - Binary search over possible penalties takes O(log M) iterations, where M is max value in nums
     * - For each iteration, we check all n elements to count required operations
     * - Total: O(n * log(M))
     *
     * Space Complexity: O(1)
     * - Only constant extra space needed for variables
     * - No additional data structures used
     */
    fun minimumSize(nums: IntArray, maxOperations: Int): Int {
        // Initialize binary search range
        // left: minimum possible penalty (1)
        // right: maximum value in nums (current max penalty)
        var left = 1
        var right = nums.maxOrNull() ?: 1
        
        // Binary search for minimum penalty
        while (left < right) {
            // Calculate middle point as potential penalty
            val mid = left + (right - left) / 2
            
            // Count operations needed for this penalty
            var operations = 0L
            for (num in nums) {
                // For each bag, calculate splits needed
                // (num - 1) / mid gives number of additional bags needed
                operations += (num - 1) / mid
            }
            
            // If operations needed exceeds limit, penalty is too low
            if (operations > maxOperations) {
                left = mid + 1
            } else {
                // Operations within limit, try lower penalty
                right = mid
            }
        }
        
        return left
    }
}
