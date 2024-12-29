package problems

/**
 * 1639.Number of Ways to Form a Target String Given a Dictionary
 * https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/description/
 *
 * You are given a list of strings of the same length words and a string target.
 *
 * Your task is to form target using the given words under the following rules:
 *
 * target should be formed from left to right.
 * To form the ith character (0-indexed) of target, you can choose the kth character of the jth string in words if target[i] = words[j][k].
 * Once you use the kth character of the jth string of words, you can no longer use the xth character of any string in words where x <= k. In other words, all characters to the left of or at index k become unusuable for every string.
 * Repeat the process until you form the string target.
 * Notice that you can use multiple characters from the same string in words provided the conditions above are met.
 *
 * Return the number of ways to form target from words. Since the answer may be too large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["acca","bbbb","caca"], target = "aba"
 * Output: 6
 * Explanation: There are 6 ways to form target.
 * "aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("caca")
 * "aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("caca")
 * "aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("acca")
 * "aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("acca")
 * "aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("acca")
 * "aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("caca")
 *
 *
 * Example 2:
 *
 * Input: words = ["abba","baab"], target = "bab"
 * Output: 4
 * Explanation: There are 4 ways to form target.
 * "bab" -> index 0 ("baab"), index 1 ("baab"), index 2 ("abba")
 * "bab" -> index 0 ("baab"), index 1 ("baab"), index 3 ("baab")
 * "bab" -> index 0 ("baab"), index 2 ("baab"), index 3 ("baab")
 * "bab" -> index 1 ("abba"), index 2 ("baab"), index 3 ("baab")
 *
 *
 * Constraints:
 *
 * - 1 <= words.length <= 1000
 * - 1 <= words[i].length <= 1000
 * - All strings in words have the same length.
 * - 1 <= target.length <= 1000
 * - words[i] and target contain only lowercase English letters.
 */
class NumberOfWaysToFormATargetStringGivenADictionary {

    /**
     * Time: O((n+m) * k)
     * Space: O(m*k)
     */
    // Declare two variables `m` and `k` to represent the length of the target string and the length of each word, respectively.
    private var m: Int = 0
    private var k: Int = 0

    // Define a constant for the modulo value to prevent overflow during calculations.
    private val mod = 1_000_000_007

    // Initialize a memoization table `mem` of size 1001 x 1001 with all elements set to -1.
// This is used to store intermediate results of subproblems to avoid recomputation.
    private val mem = Array(1001) { IntArray(1001) { -1 } }

    // Recursive function to solve the problem using dynamic programming.
    private fun solve(i: Int, j: Int, freq: Array<IntArray>, target: String): Int {
        // Base case: If we've matched all characters of the target string, return 1 (one valid way found).
        if (i == m) return 1

        // Base case: If we've exhausted all columns in the words, return 0 (no valid way possible).
        if (j == k) return 0

        // If the result for this state has already been computed, return the memoized value.
        if (mem[i][j] != -1) return mem[i][j]

        // Calculate the number of ways by skipping the current column.
        val notTaken = solve(i, j + 1, freq, target)

        // Calculate the number of ways by taking the current column if the character matches.
        // Use `toLong()` to handle potential overflow, and take modulo to ensure values remain within bounds.
        val taken = (freq[target[i] - 'a'][j].toLong() * solve(i + 1, j + 1, freq, target) % mod).toInt()

        // Store the result of the current state in the memoization table.
        // The result is the sum of `notTaken` and `taken`, modulo `mod` to avoid overflow.
        mem[i][j] = (notTaken + taken) % mod

        // Return the memoized result.
        return mem[i][j]
    }

    // Function to calculate the number of ways to form the target string using the given words.
    fun numWays(words: Array<String>, target: String): Int {
        // Set `m` to the length of the target string.
        m = target.length

        // Set `k` to the length of a word (assuming all words have the same length).
        k = words[0].length

        // Create a frequency array `freq` to count the occurrences of each character at each column.
        // `freq` is a 2D array of size 26 x k (26 for each letter of the alphabet, k for each column).
        val freq = Array(26) { IntArray(k) { 0 } }

        // Fill the frequency array.
        for (i in 0..<k) { // Loop over each column in the words.
            for (word in words) { // Loop over each word.
                val ch = word[i] // Get the character at the current column.
                freq[ch - 'a'][i]++ // Increment the frequency of this character at this column.
            }
        }

        // Start the recursive function from the first character of the target and the first column of the words.
        return solve(0, 0, freq, target)
    }

}