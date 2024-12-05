package problems

/**
 * Problem: Check If a Word Occurs As a Prefix of Any Word in a Sentence
 * https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
 *
 * Given a sentence that consists of some words separated by a single space, and a searchWord,
 * check if searchWord is a prefix of any word in sentence.
 * Return the index of the word in the sentence (1-indexed) where searchWord is a prefix of this word.
 * If searchWord is a prefix of more than one word, return the index of the first word (minimum index).
 * If there is no such word return -1.
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