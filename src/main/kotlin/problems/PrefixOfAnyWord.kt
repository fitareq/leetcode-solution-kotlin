package problems

/**
 * Problem: Check If a Word Occurs As a Prefix of Any Word in a Sentence
 * https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
 *
 * Given a sentence that consists of some words separated by a single space, and a searchWord,
 * check if searchWord is a prefix of any word in sentence.
 *
 * Example:
 * Input: sentence = "i love eating burger", searchWord = "burg"
 * Output: 4
 * Explanation: "burg" is prefix of "burger" which is the 4th word in the sentence.
 *
 * Time Complexity: O(n*m) where n is the number of words and m is the length of searchWord
 * Space Complexity: O(n) for splitting the sentence into words
 *
 * @param sentence The input sentence
 * @param searchWord The word to search as prefix
 * @return The 1-based index of the word where searchWord is a prefix, or -1 if not found
 */
class PrefixOfAnyWord {
    fun isPrefixOfWord(sentence: String, searchWord: String): Int {
        val words = sentence.split(" ")
        words.forEachIndexed { index, word ->
            if (word.startsWith(searchWord)) return index + 1
        }


        return -1
    }
}