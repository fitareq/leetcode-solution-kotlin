package problems

/**
 * 494.Target Sum
 * https://leetcode.com/problems/target-sum/description/
 *
 *
 * You are given an integer array nums and an integer target.
 *
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 *
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
 * - -1 + 1 + 1 + 1 + 1 = 3
 * - +1 - 1 + 1 + 1 + 1 = 3
 * - +1 + 1 - 1 + 1 + 1 = 3
 * - +1 + 1 + 1 - 1 + 1 = 3
 * - +1 + 1 + 1 + 1 - 1 = 3
 *
 *
 * Example 2:
 *
 * Input: nums = [1], target = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * - 1 <= nums.length <= 20
 * - 0 <= nums[i] <= 1000
 * - 0 <= sum(nums[i]) <= 1000
 * - -1000 <= target <= 1000
 */

class TargetSum {
    /**
     * Complexity Analysis:
     * - Time Complexity: O(2^N), where N is the size of the nums array.
     *   Each element has two choices: add or subtract, resulting in 2^N possible combinations.
     * - Space Complexity: O(N), due to the recursive call stack. The maximum depth of the recursion is N.
     */
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        // Helper function to perform the backtracking recursion.
        fun backTrack(i: Int, currSum: Int): Int {
            // Base case: if we have processed all elements in the array.
            if (i == nums.size)
            // Check if the current sum equals the target.
                return if (currSum == target) 1 else 0

            // Recursive case:
            // 1. Include the current number with a '+' sign.
            // 2. Include the current number with a '-' sign.
            return backTrack(i + 1, nums[i] + currSum) + backTrack(i + 1, currSum - nums[i])
        }

        // Start backtracking from the 0th index and an initial sum of 0.
        return backTrack(0, 0)
    }

}