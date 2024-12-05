package problems

/**
 * Problem: Check If N and Its Double Exist
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/
 *
 * Given an array arr of integers, check if there exist two indices i and j such that:
 * - i != j
 * - 0 <= i, j < arr.length
 * - arr[i] == 2 * arr[j]
 *
 * Example:
 * Input: arr = [10,2,5,3]
 * Output: true
 * Explanation: For i = 0 and j = 2, arr[i] = 10 == 2 * 5 = 2 * arr[j]
 *
 * Time Complexity: O(n) where n is the length of the array
 * Space Complexity: O(n) for the HashSet
 *
 * @param arr Array of integers to check
 * @return Boolean indicating if such pair exists
 */
class DoubleExists {
    /*fun checkIfExist(arr: IntArray): Boolean {
        for (i in arr.indices) {
            if (arr[i] % 2 == 0) {
                for (j in arr.indices) {
                    val temp = 2 * arr[j]
                    if (i != j && temp == arr[i]) return true
                }
            }
        }
        return false
    }*/

    fun checkIfExist(arr: IntArray): Boolean {
        val seen = HashSet<Int>()

        for (i in arr) {
            if (seen.contains(i * 2) || (i % 2 == 0 && seen.contains(i / 2))) return true
            seen.add(i)
        }
        return false
    }
}