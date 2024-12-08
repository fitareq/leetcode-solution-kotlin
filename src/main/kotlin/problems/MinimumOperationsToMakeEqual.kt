package problems

/**
 * Problem: Minimum Operations to Make Array Values Equal
 *
 * You are given an integer array nums and an integer k. An integer h is called valid if all values
 * in the array that are strictly greater than h are identical.
 *
 * You can perform the following operation:
 * - Select a valid integer h
 * - For each index i where nums[i] > h, set nums[i] to h
 *
 * Return the minimum number of operations to make all elements equal to k.
 * Return -1 if it's impossible.
 *
 * Example:
 * Input: nums = [5,2,5,4,5], k = 2
 * Output: 2
 * Explanation: Operations can be performed using valid integers 4 and then 2.
 *
 * Constraints:
 * - 1 <= nums.length <= 100
 * - 1 <= nums[i] <= 100
 * - 1 <= k <= 100
 *
 * @param nums Array of integers
 * @param k Target value for all elements
 * @return Minimum operations needed or -1 if impossible
 */
class MinimumOperationsToMakeEqual {
    // Time: O(n), Space: O(1) where n is the length of nums
    fun minOperations(nums: IntArray, k: Int): Int {
        // Check if any number is less than k (impossible case)
        if (nums.any { it < k }) return -1

        // If all numbers are already k, no operations needed
        if (nums.all { it == k }) return 0

        var operations = 0
        val current = nums.clone()

        while (!current.all { it == k }) {
            // Find next valid h (largest number that's not k)
            val maxNum = current.max()
            if (maxNum == k) break

            // Find the second largest distinct number
            val secondMax = current.filter { it != maxNum }.maxOrNull() ?: k

            // h should be max(secondMax, k)
            val h = maxOf(secondMax, k)

            // Apply operation
            for (i in current.indices) {
                if (current[i] > h) {
                    current[i] = h
                }
            }

            operations++
        }

        return operations
    }

    /*
    // Time: O(n * m), Space: O(1) where n is length of nums and m is max value in nums
    fun minOperations(nums: IntArray, k: Int): Int {
        // Check if any number is less than k (impossible case)
        if (nums.any { it < k }) return -1
        
        // If all numbers are already k, no operations needed
        if (nums.all { it == k }) return 0
        
        var operations = 0
        var current = nums.clone()
        
        while (!current.all { it == k }) {
            val maxNum = current.max()
            if (maxNum == k) break
            
            // Find all unique values in descending order
            val uniqueValues = current.toSet().sortedDescending()
            
            // Find next valid h
            var h = k
            for (i in 1 until uniqueValues.size) {
                if (uniqueValues[i] < uniqueValues[0]) {
                    h = maxOf(uniqueValues[i], k)
                    break
                }
            }
            
            // Apply operation
            for (i in current.indices) {
                if (current[i] > h) {
                    current[i] = h
                }
            }
            
            operations++
        }
        
        return operations
    }
    */
}
