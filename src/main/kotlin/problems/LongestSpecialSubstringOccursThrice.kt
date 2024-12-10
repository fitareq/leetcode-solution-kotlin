package problems

import kotlin.math.max
import kotlin.math.min

/**
 * Problem: Find Longest Special Substring That Occurs Thrice I
 * https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/
 *
 * You are given a string s that consists of lowercase English letters.
 * A substring of s is called special if it contains only the same character.
 * Return the length of the longest special substring of s that occurs at least thrice,
 * or -1 if no special substring occurs at least thrice.
 *
 * A substring is a contiguous non-empty sequence of characters within a string.
 *
 * Example 1:
 * Input: s = "aaaa"
 * Output: 2
 * Explanation: The longest special substring that occurs thrice is "aa": substrings "aa", "aa", and "aa".
 * It can be shown that the maximum length achievable is 2.
 *
 * Example 2:
 * Input: s = "abcdef"
 * Output: -1
 * Explanation: There exists no special substring that occurs thrice.
 *
 * Example 3:
 * Input: s = "abcaba"
 * Output: 1
 * Explanation: The longest special substring that occurs thrice is "a": substrings "a", "a", and "a".
 * It can be shown that the maximum length achievable is 1.
 *
 * Constraints:
 * - 3 <= s.length <= 50
 * - s consists of only lowercase English letters.
 *
 * @param s Input string
 * @return Length of longest special substring occurring thrice, or -1 if none exists
 */
class LongestSpecialSubstringOccursThrice {
    /**
     * Efficient solution using top-3 frequency array approach
     * Time: O(n) - single pass through string
     * Space: O(1) - fixed size array (26 chars × 3 lengths)
     */
    fun maximumLength(s: String): Int {
        // For each character (a-z), store top 3 lengths of consecutive occurrences
        val topFreq = MutableList(26) { IntArray(3) { -1 } }
        var prev = '*'  // Previous character, initialized with non-letter
        var subLength = 0  // Current length of consecutive same characters

        // Single pass through string
        for (i in s) {
            // If same as previous character, increase length
            if (i == prev) {
                ++subLength
            } else {
                // Different character, reset length to 1
                subLength = 1
            }

            val idx = i - 'a'  // Convert character to 0-25 index

            // Find position of smallest length in top-3 array
            val minValueIndex = topFreq[idx].indexOf(topFreq[idx].min())
            // If current length is larger than smallest stored length, replace it
            if (topFreq[idx][minValueIndex] < subLength) 
                topFreq[idx][minValueIndex] = subLength
            prev = i  // Update previous character
        }

        // Find maximum length that appears at least thrice
        var maxLen = -1
        for ((a, b, c) in topFreq) {
            // For each character, take minimum of its top 3 lengths
            // This ensures we have at least 3 occurrences of this length
            maxLen = max(maxLen, minOf(a, b, c))
        }
        return maxLen
    }

    /**
     * Alternative solution using frequency map approach
     */
    fun maximumLengthAlternative(s: String): Int {
        // Map to store frequency of each length for each character
        val freqMap = mutableMapOf<Char, MutableMap<Int, Int>>()
        
        // For each position, count all possible lengths of special substrings
        for (i in s.indices) {
            var len = 0
            var j = i
            while (j < s.length && s[j] == s[i]) {
                len++
                freqMap.getOrPut(s[i]) { mutableMapOf() }
                    .merge(len, 1, Int::plus)
                j++
            }
        }
        
        var maxLen = -1
        // For each character
        for ((_, lengths) in freqMap) {
            // For each length of that character
            for ((len, freq) in lengths) {
                // If this length appears at least thrice
                if (freq >= 3) {
                    maxLen = maxOf(maxLen, len)
                }
            }
        }
        return maxLen
    }
}
