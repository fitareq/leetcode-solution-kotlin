package problems

/**
 * 689.Maximum Sum of 3 Non-Overlapping Subarrays
 * https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/description
 * Given an integer array nums and an integer k, find three non-overlapping subarrays of length k with maximum sum and return them.
 *
 * Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,1,2,6,7,5,1], k = 2
 * Output: [0,3,5]
 * Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
 * We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
 * Example 2:
 *
 * Input: nums = [1,2,1,2,1,2,1,2,1], k = 2
 * Output: [0,2,4]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] < 216
 * 1 <= k <= floor(nums.length / 3)
 */
class MaximumSumOf3NonOverlappingSubarrays {
    private lateinit var prefixSum: IntArray
    private lateinit var mem: Array<IntArray>

    fun findMaxSum(nums: IntArray, pos: Int, count: Int, k: Int): Int {
        if (count == 3) return 0
        if (pos > nums.size - k) return 0
        if (mem[pos][count] != -1) return mem[pos][count]

        val dontStart = findMaxSum(nums, pos + 1, count, k)
        val startHere = findMaxSum(nums, pos + k, count + 1, k) + prefixSum[pos + k] - prefixSum[pos]
        mem[pos][count] = maxOf(dontStart, startHere)
        return mem[pos][count]
    }

    fun findMaxSumPath(nums: IntArray, pos: Int, count: Int, k: Int, path: MutableList<Int>) {
        if (count == 3) return
        if (pos > nums.size - k) return

        val dontStart = findMaxSum(nums, pos + 1, count, k)
        val startHere = findMaxSum(nums, pos + k, count + 1, k) + prefixSum[pos + k] - prefixSum[pos]
        if (startHere >= dontStart) {
            path.add(pos)
            findMaxSumPath(nums, pos + k, count + 1, k, path)
        } else {
            findMaxSumPath(nums, pos + 1, count, k, path)
        }
    }

    fun maxSumOfThreeSubarrays(nums: IntArray, k: Int): IntArray {
        val n = nums.size
        mem = Array(n) { IntArray(3) { -1 } }
        prefixSum = IntArray(n + 1)
        for (i in 0..<n) prefixSum[i + 1] = prefixSum[i] + nums[i]

        findMaxSum(nums, 0, 0, k)
        val path = mutableListOf<Int>()
        findMaxSumPath(nums, 0, 0, k, path)
        return path.toIntArray()
    }
}