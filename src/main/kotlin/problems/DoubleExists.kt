package problems

/**
 * 1346. Check If N and Its Double Exist
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/
 *
 * Given an array arr of integers, check if there exist two indices i and j such that:
 * - i != j
 * - 0 <= i, j < arr.length
 * - arr[i] == 2 * arr[j]
 *
 * Example 1:
 * Input: arr = [10,2,5,3]
 * Output: true
 * Explanation: For i = 0 and j = 2, arr[i] = 10 == 2 * 5 = 2 * arr[j]
 *
 * Example 2:
 * Input: arr = [3,1,7,11]
 * Output: false
 * Explanation: There is no i and j that satisfy the conditions.
 *
 * Example 3:
 * Input: arr = [7,1,14,11]
 * Output: true
 * Explanation: For i = 2 and j = 1, arr[i] = 14 == 2 * 1 = 2 * arr[j]
 *
 * Constraints:
 * - 2 <= arr.length <= 500
 * - -10^3 <= arr[i] <= 10^3
 */
class DoubleExists {
    /**
     * Time Complexity: O(n)
     * - Single pass through the array
     * - HashSet operations (add/contains) are O(1)
     * - Where n is the length of the input array
     *
     * Space Complexity: O(n)
     * - HashSet can store at most n elements
     * - Where n is the length of the input array
     */
    fun checkIfExist(arr: IntArray): Boolean {
        // Use HashSet to store seen numbers
        val seen = HashSet<Int>()
        
        // Check each number in array
        for (num in arr) {
            // Check if double or half exists
            // Note: For even numbers, check half value
            if (seen.contains(num * 2) || (num % 2 == 0 && seen.contains(num / 2))) {
                return true
            }
            // Add current number to seen set
            seen.add(num)
        }
        
        return false
    }
}