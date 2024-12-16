package problems

/**
 * 2825. Make String a Subsequence Using Cyclic Increments
 * https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/
 *
 * You are given two 0-indexed strings str1 and str2.
 *
 * In an operation, you select a character in str1 and increment it by 1, with 'z' incrementing to 'a'.
 * For example, 'a' becomes 'b', 'b' becomes 'c', and 'z' becomes 'a'.
 *
 * You can perform this operation on any character in str1 any number of times.
 *
 * Return true if it is possible to make str2 a subsequence of str1 by performing the operation on str1
 * any number of times, and false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting some
 * (possibly none) of the characters without disturbing the relative positions of the remaining characters.
 *
 * Example 1:
 * Input: str1 = "abc", str2 = "ad"
 * Output: true
 * Explanation:
 * - Select index 2 in str1: "abc" -> "abd"
 * - Now, str2 = "ad" is a subsequence of str1 = "abd"
 *
 * Example 2:
 * Input: str1 = "zc", str2 = "ad"
 * Output: true
 * Explanation:
 * - Select index 0 in str1: "zc" -> "ac"
 * - Select index 0 in str1: "ac" -> "bc"
 * - Select index 0 in str1: "bc" -> "cc"
 * - Select index 0 in str1: "cc" -> "dc"
 * - Now, str2 = "ad" is a subsequence of str1 = "dc"
 *
 * Example 3:
 * Input: str1 = "ab", str2 = "d"
 * Output: false
 * Explanation: It is impossible to make str2 a subsequence of str1 through any number of operations.
 *
 * Constraints:
 * - 1 <= str1.length <= 10^5
 * - 1 <= str2.length <= 10^5
 * - str1 and str2 consist of only lowercase English letters.
 */
class MakeStringSubsequenceUsingCyclicIncrements {
    /**
     * Time Complexity: O(n)
     * - Single pass through both strings
     * - Where n is the length of str1
     *
     * Space Complexity: O(1)
     * - Only uses a few variables regardless of input size
     */
    fun canMakeSubsequence(str1: String, str2: String): Boolean {
        var j = 0  // pointer for str2
        
        // For each character in str1
        for (i in str1.indices) {
            // If we've matched all characters in str2, return true
            if (j == str2.length) return true
            
            // Get next cyclic character for current char in str1
            val nextChar = if (str1[i] == 'z') 'a' else (str1[i] + 1).toChar()
            
            // If next cyclic character matches current char in str2,
            // move pointer in str2
            if (nextChar == str2[j]) {
                j++
            }
        }
        
        // Return true if we matched all characters in str2
        return j == str2.length
    }
}