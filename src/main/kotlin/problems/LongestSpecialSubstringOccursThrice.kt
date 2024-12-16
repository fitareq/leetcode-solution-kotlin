package problems

import kotlin.math.max
import kotlin.math.min

/**
 * 2981. Find Longest Special Substring That Occurs Thrice I
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
 * Explanation: There exists no special substring that occurs at least thrice.
 *
 * Example 3:
 * Input: s = "abcaba"
 * Output: 1
 * Explanation: The longest special substring that occurs thrice is "a": substrings "a", "a", and "a".
 *
 * Constraints:
 * - 3 <= s.length <= 50
 * - s consists of only lowercase English letters.
 */
class LongestSpecialSubstringOccursThrice {
    /**
     * Time Complexity: O(n)
     * - Single pass through the string to count frequencies
     * - Array operations are O(1) as we have fixed size (26 chars × 3 lengths)
     * - Where n is the length of the input string
     *
     * Space Complexity: O(1)
     * - Using fixed size arrays (26 × 3) regardless of input size
     * - Only constant extra space needed for variables
     */
    fun maximumLength(s: String): Int {
        // Create array to store top 3 lengths for each character (a-z)
        // For each char, we only need to track 3 longest sequences as we need at least 3 occurrences
        val topThree = Array(26) { IntArray(3) }
        
        // Variables to track current sequence
        var currentChar = s[0]
        var currentLength = 1
        
        // Process each character in string
        for (i in 1..s.length) {
            // If we're at the end or found different character
            if (i == s.length || s[i] != currentChar) {
                // Update top 3 lengths for current character
                val index = currentChar - 'a'
                updateTopThree(topThree[index], currentLength)
                
                // Reset sequence if not at end
                if (i < s.length) {
                    currentChar = s[i]
                    currentLength = 1
                }
            } else {
                // Extend current sequence
                currentLength++
            }
        }
        
        // Find maximum length that occurs at least thrice
        var maxLength = -1
        for (lengths in topThree) {
            if (lengths[2] > 0) { // If we have at least 3 occurrences
                maxLength = max(maxLength, lengths[2])
            }
        }
        
        return maxLength
    }
    
    // Helper function to update top 3 lengths
    private fun updateTopThree(lengths: IntArray, newLength: Int) {
        // If new length is not longer than smallest tracked length, ignore it
        if (newLength <= lengths[2]) return
        
        // Shift existing lengths down if necessary
        if (newLength > lengths[0]) {
            lengths[2] = lengths[1]
            lengths[1] = lengths[0]
            lengths[0] = newLength
        } else if (newLength > lengths[1]) {
            lengths[2] = lengths[1]
            lengths[1] = newLength
        } else {
            lengths[2] = newLength
        }
    }
}
