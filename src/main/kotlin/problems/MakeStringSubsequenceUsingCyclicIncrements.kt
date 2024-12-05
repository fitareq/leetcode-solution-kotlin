package problems

/**
 * Problem: Make String a Subsequence Using Cyclic Increments
 * https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/
 *
 * You are given two 0-indexed strings str1 and str2. In an operation, you select a character in str1
 * and increment it by one. Characters are represented as ASCII values, so 'a' becomes 'b', 'b' becomes 'c',
 * and 'z' becomes 'a'. A string s is a subsequence of a string t if s can be derived from t by deleting
 * some (possibly zero) characters.
 *
 * Example:
 * Input: str1 = "abc", str2 = "ad"
 * Output: true
 * Explanation: Select index 1 and increment it. "abc" becomes "abd".
 * Now, "ad" is a subsequence of "abd".
 *
 * Time Complexity: O(n) where n is the length of str1
 * Space Complexity: O(1)
 *
 * @param str1 The first string that can be modified
 * @param str2 The target subsequence string
 * @return Boolean indicating if str2 can become a subsequence of str1
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