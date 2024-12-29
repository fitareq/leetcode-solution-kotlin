package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NumberOfWaysToFormATargetStringGivenADictionaryTest {
    val solution = NumberOfWaysToFormATargetStringGivenADictionary()

    @Test
    fun `case 1`() {
        val words = arrayOf("acca", "bbbb", "caca")
        val target = "aba"
        val expected = 6
        val result = solution.numWays(words, target)

        assertEquals(expected, result)
    }

    @Test
    fun `case 2`() {
        val words = arrayOf("abba", "baab")
        val target = "bab"
        val expected = 4
        val result = solution.numWays(words, target)

        assertEquals(expected, result)
    }

    @Test
    fun `case 3`() {
        val words = arrayOf("kidbjae", "bfchgfb", "gaaehef", "agjakgg", "abkkdjc", "bahgbig", "fedidah")
        val target = "fd"
        val expected = 8
        val result = solution.numWays(words, target)

        assertEquals(expected, result)
    }

    @Test
    fun `case 4`() {
        val words = arrayOf(
            "cbabddddbc",
            "addbaacbbd",
            "cccbacdccd",
            "cdcaccacac",
            "dddbacabbd",
            "bdbdadbccb",
            "ddadbacddd",
            "bbccdddadd",
            "dcabaccbbd",
            "ddddcddadc",
            "bdcaaaabdd",
            "adacdcdcdd",
            "cbaaadbdbb",
            "bccbabcbab",
            "accbdccadd",
            "dcccaaddbc",
            "cccccacabd",
            "acacdbcbbc",
            "dbbdbaccca",
            "bdbddbddda",
            "daabadbacb",
            "baccdbaada",
            "ccbabaabcb",
            "dcaabccbbb",
            "bcadddaacc",
            "acddbbdccb",
            "adbddbadab",
            "dbbcdcbcdd",
            "ddbabbadbb",
            "bccbcbbbab",
            "dabbbdbbcb",
            "dacdabadbb",
            "addcbbabab",
            "bcbbccadda",
            "abbcacadac",
            "ccdadcaada",
            "bcacdbccdb"
        )
        val target = "bcbbcccc"
        val expected = 677452090
        val result = solution.numWays(words, target)

        assertEquals(expected, result)
    }
}