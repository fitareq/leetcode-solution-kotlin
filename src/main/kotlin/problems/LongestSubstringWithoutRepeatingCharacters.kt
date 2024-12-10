package problems

import kotlin.math.max

/**
 * Problem: Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Constraints:
 * - 0 <= s.length <= 5 * 10^4
 * - s consists of English letters, digits, symbols and spaces.
 *
 * @param s Input string
 * @return Length of the longest substring without repeating characters
 */
class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Solution using LinkedHashSet for ordered unique characters
     * 
     * Approach:
     * - Use LinkedHashSet to maintain order of characters and O(1) lookups
     * - Slide window by adding new characters
     * - When duplicate found, remove from start until window is valid again
     * 
     * Time Complexity: O(n) where n is string length
     * - Each character is added and removed at most once
     * 
     * Space Complexity: O(min(m,n)) where:
     * - m is size of character set (e.g., 26 for lowercase letters)
     * - n is string length
     */
    fun lengthOfLongestSubstring(s: String): Int {
        val n = s.length
        // Handle edge cases
        if (n == 0) return 0
        if (n == 1) return 1

        // LinkedHashSet provides:
        // 1. O(1) lookup with 'in' operator
        // 2. O(1) removal of first element
        // 3. Maintains insertion order
        val seen = linkedSetOf<Char>()
        seen.add(s[0])
        var maxLen = 1

        // Iterate through string starting from second character
        for (i in 1 until n) {
            if (s[i] !in seen) {
                // New character - expand window
                seen.add(s[i])
                maxLen = max(maxLen, seen.size)
            } else {
                // Duplicate found - shrink window from start
                // Remove characters until duplicate is gone
                while (s[i] in seen) {
                    seen.remove(seen.first())
                }
                // Add current character to make window valid
                seen.add(s[i])
            }
        }
        return maxLen
    }
}
