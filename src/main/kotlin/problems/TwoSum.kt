package problems

/**
 * Problem 1: Two Sum
 * https://leetcode.com/problems/two-sum/
 * 
 * Given an array of integers nums and an integer target, return indices of the two numbers 
 * such that they add up to target. You may assume that each input would have exactly one solution, 
 * and you may not use the same element twice.
 */
class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numMap = mutableMapOf<Int, Int>()
        
        nums.forEachIndexed { index, num ->
            val complement = target - num
            if (numMap.containsKey(complement)) {
                return intArrayOf(numMap[complement]!!, index)
            }
            numMap[num] = index
        }
        
        throw IllegalArgumentException("No solution found")
    }
}
