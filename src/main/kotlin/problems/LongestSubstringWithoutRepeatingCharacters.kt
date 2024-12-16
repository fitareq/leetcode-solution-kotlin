package problems

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * - "abc" has no repeating characters
 * - "bca" is another possible substring
 * - Any substring longer than 3 would have repeating characters
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * - Any substring longer than 1 would have repeating characters
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * - "wke" is a substring without repeating characters
 * - Note that "pwke" is not a substring as it contains repeating characters
 *
 * Constraints:
 * - 0 <= s.length <= 5 * 10^4
 * - s consists of English letters, digits, symbols and spaces
 */
class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Time Complexity: O(n)
     * - Single pass through the string using sliding window
     * - HashMap operations (put/get) are O(1)
     * - Where n is the length of the input string
     *
     * Space Complexity: O(min(m, n))
     * - HashMap stores at most min(m, n) characters
     * - Where m is the size of character set (e.g., 128 for ASCII)
     * - And n is the length of the input string
     */
    fun lengthOfLongestSubstring(s: String): Int {
        // Map to store last seen position of each character
        val lastSeen = mutableMapOf<Char, Int>()
        var maxLength = 0
        var windowStart = 0
        
        // Slide window through string
        for (windowEnd in s.indices) {
            val currentChar = s[windowEnd]
            
            // If character was seen before and is in current window,
            // move window start to position after last occurrence
            if (lastSeen.containsKey(currentChar)) {
                windowStart = maxOf(windowStart, lastSeen[currentChar]!! + 1)
            }
            
            // Update last seen position of current character
            lastSeen[currentChar] = windowEnd
            
            // Update max length if current window is longer
            maxLength = maxOf(maxLength, windowEnd - windowStart + 1)
        }
        
        return maxLength
    }
}
