package problems
/**
 * Problem: Make String a Subsequence Using Cyclic Increments
 * https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/
 */
class MakeStringSubsequenceUsingCyclicIncrements {
    fun canMakeSubsequence(str1: String, str2: String): Boolean {
        var i = 0
        var j = 0
        while (i < str1.length && j < str2.length) {
            if (str1[i] == str2[j] || 'a' + (str1[i] - 'a' + 1) % 26 == str2[j]) {
                ++i
                ++j
            } else {
                ++i
            }
        }

        return j == str2.length
    }
}