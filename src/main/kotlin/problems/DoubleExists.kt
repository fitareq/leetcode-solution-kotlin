package problems

/**
 * 1346. Check If N and Its Double Exist
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/description/?envType=daily-question&envId=2024-12-01
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