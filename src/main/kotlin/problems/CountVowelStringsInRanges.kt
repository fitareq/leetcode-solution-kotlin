package problems

/**
 * 2559. Count Vowel Strings in Ranges
 * https://leetcode.com/problems/count-vowel-strings-in-ranges/description
 */
class CountVowelStringsInRanges {
    /*private fun isVowel(c: Char): Boolean {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
    }

    fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
        val n = words.size
        val preCom = IntArray(n) { 0 }
        for ((i, word) in words.withIndex()) {
            val m = word.length
            if (isVowel(word[0]) && isVowel(word[m - 1])) preCom[i] = 1
        }
        val result = IntArray(queries.size)
        for ((index, query) in queries.withIndex()) {
            val (start, end) = query
            var count = 0
            for (i in start..end) if (preCom[i] == 1) ++count

            result[index] = count
        }

        return result
    }*/

    fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
        val vowels = hashSetOf('a', 'e', 'i', 'o', 'u')
        var sum = 0

        val preSum = words.map { word ->
            val m = word.length
            if (vowels.contains(word[0]) && vowels.contains(word[m - 1])) ++sum
            sum
        }.toIntArray()
        return queries.map { (start, end) ->
            preSum[end] - if (start == 0) 0 else preSum[start - 1]
        }.toIntArray()

    }
}