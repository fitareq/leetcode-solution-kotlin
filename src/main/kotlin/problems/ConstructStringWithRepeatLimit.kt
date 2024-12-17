package problems

import java.util.PriorityQueue
import kotlin.math.min

/**
 * 2182. Construct String with Repeat Limit
 * https://leetcode.com/problems/construct-string-with-repeat-limit/
 *
 * You are given a string s and an integer repeatLimit. Construct a new string repeatLimitedString
 * using the characters of s such that no letter appears more than repeatLimit times in a row.
 * You do not have to use all characters from s.
 *
 * Return the lexicographically largest repeatLimitedString possible.
 *
 * A string a is lexicographically larger than a string b if in the first position where a and b
 * differ, string a has a letter that appears later in the alphabet than the corresponding letter
 * in b. If the first min(a.length, b.length) characters do not differ, then the longer string is
 * the lexicographically larger one.
 *
 * Example 1:
 * Input: s = "cczazcc", repeatLimit = 3
 * Output: "zzcccac"
 * Explanation: We use all of the characters from s to construct the repeatLimitedString "zzcccac".
 * The letter 'a' appears at most 1 time in a row.
 * The letter 'c' appears at most 3 times in a row.
 * The letter 'z' appears at most 2 times in a row.
 * Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
 * The string is the lexicographically largest repeatLimitedString possible so we return "zzcccac".
 *
 * Example 2:
 * Input: s = "aababab", repeatLimit = 2
 * Output: "bbabaa"
 * Explanation: We use only some of the characters from s to construct the repeatLimitedString "bbabaa".
 * The letter 'a' appears at most 2 times in a row.
 * The letter 'b' appears at most 2 times in a row.
 * Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
 * The string is the lexicographically largest repeatLimitedString possible so we return "bbabaa".
 *
 * Constraints:
 * - 1 <= repeatLimit <= 100
 * - 1 <= s.length <= 100000
 * - s consists of lowercase English letters.
 */
class ConstructStringWithRepeatLimit {
    /**
     * Time Complexity: O(n) where n is the length of input string
     * - Initial frequency counting: O(n)
     * - Priority Queue operations with fixed size (26): O(log 26) = O(1)
     * - Each character processed once: O(n)
     *
     * Space Complexity: O(1)
     * - Fixed size array for frequency count (26)
     * - Priority Queue with max size 26
     * - StringBuilder for result (not counted as extra space)
     */
    fun repeatLimitedString(s: String, repeatLimit: Int): String {
        // Create array to count frequency of each character (a-z)
        val freq = IntArray(26)
        for (c in s) {
            ++freq[c - 'a']  // Increment count for current character
        }

        // Create max heap prioritized by character value (lexicographically largest first)
        val pq = PriorityQueue<Pair<Char, Int>>(compareByDescending { it.first })
        
        // Add all characters with non-zero frequency to priority queue
        for (i in freq.indices) {
            if (freq[i] > 0) pq.offer(Pair(('a' + i), freq[i]))  // (character, frequency)
        }

        // StringBuilder to construct result string
        val result = StringBuilder()

        // Process characters until priority queue is empty
        while (pq.isNotEmpty()) {
            // Get character with highest lexicographical value
            val (char, f) = pq.poll()
            
            // Calculate how many occurrences we can add (min of remaining freq and repeatLimit)
            val minFreq = min(repeatLimit, f)
            
            // Add these occurrences to result
            repeat(minFreq) {
                result.append(char)
            }

            // If we still have more occurrences of current character
            if (f > repeatLimit && pq.isNotEmpty()) {
                // Get next highest character to break the sequence
                val (char2, f2) = pq.poll()
                result.append(char2)  // Add one occurrence of second character

                // Put remaining occurrences of first character back in queue
                pq.offer(Pair(char, f - repeatLimit))
                
                // If second character has remaining occurrences, put back in queue
                if (f2 - 1 > 0)
                    pq.offer(Pair(char2, f2 - 1))
            }
        }

        return result.toString()
    }
}
