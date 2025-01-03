package problems

class NumberOfWaysToSplitArray {
    /*fun waysToSplitArray(nums: IntArray): Int {
        val n = nums.size
        var sum = 0L
        val prefixSum = nums.map { num ->
            sum += num
            sum
        }.toLongArray()

        var count = 0
        for (i in 0..<n - 1) {
            if (prefixSum[i] >= (prefixSum[n - 1] - prefixSum[i])) ++count
        }

        return count
    }*/

    fun waysToSplitArray(nums: IntArray): Int {
        val n = nums.size
        var left = 0L
        var right: Long = nums.sumOf { it.toLong() }

        var count = 0
        for (i in 0..<n - 1) {
            left += nums[i]
            right -= nums[i]
            if (left >= right) ++count
        }

        return count
    }
}