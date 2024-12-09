package problems

/**
 * Problem: Special Array II
 *
 * An array is considered special if every pair of its adjacent elements contains two numbers with different parity.
 * Given an array nums and queries where queries[i] = [fromi, toi], check if the subarray nums[fromi toi] is special.
 *
 * Solution approach:
 * 1. Initialize paritySum array with 1s (potential valid pairs)
 * 2. For each adjacent pair:
 *    - Use bitwise AND (&1) to check parity efficiently
 *    - If different parity, accumulate count in paritySum
 * 3. For each query [from,to]:
 *    - Subarray is special if valid pairs count >= subarray length
 *
 * Example 1:
 * Input: nums = [3,4,1,2,6], queries = [[0,4]]
 * Output: [false]
 * Explanation: The subarray is [3,4,1,2,6]. 2 and 6 are both even.
 *
 * Example 2:
 * Input: nums = [4,3,1,6], queries = [[0,2],[2,3]]
 * Output: [false,true]
 * Explanation:
 * - Query 1: [4,3,1] has 3,1 both odd. Not special.
 * - Query 2: [1,6] has different parity. Special.
 *
 * Time Complexity: O(n + q) where n is array length and q is number of queries
 * - O(n) to build paritySum array
 * - O(1) per query
 *
 * Space Complexity: O(n) for paritySum array
 *
 * @param nums Array of integers
 * @param queries Array of query ranges [from, to]
 * @return Array of booleans where answer[i] is true if nums[from to] is special
 */
class SpecialArrayII {
    fun isArraySpecial(nums: IntArray, queries: Array<IntArray>): BooleanArray {
        // Initialize array with 1s - assuming each position could be part of a valid pair
        val paritySum = IntArray(nums.size) { 1 }

        // Check each adjacent pair
        for (i in 1 until nums.size) {
            // Using bitwise AND for efficient parity check
            // nums[i] and 1 != nums[i-1] and 1 means different parity
            if (nums[i] and 1 != nums[i - 1] and 1)
            // If different parity, accumulate the count
                paritySum[i] = paritySum[i - 1] + paritySum[i]
        }

        // Process queries using Kotlin's map function
        return queries.map { (from, to) ->
            // A subarray is special if number of valid pairs >= length of subarray
            paritySum[to] >= to - from + 1
        }.toBooleanArray()
    }
}
