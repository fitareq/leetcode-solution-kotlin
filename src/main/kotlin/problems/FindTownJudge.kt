package problems

/**
 * Problem: Find the Town Judge
 * https://leetcode.com/problems/find-the-town-judge/
 *
 * In a town of n people, a town judge:
 * 1. Trusts nobody
 * 2. Everybody (except the judge) trusts the judge
 * 3. There is exactly one person that satisfies properties 1 and 2
 */
class FindTownJudge {
    /*data class MutablePair(var first: Int, var second: Int)

    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val result = MutableList(n + 1) { MutablePair(0, 0) }

        for (i in trust) {
            ++result[i[0]].first
            ++result[i[1]].second
        }

        for (i in 1 until n + 1) {
            if (result[i].first == 0 && result[i].second == n - 1) return i
        }
        return -1
    }*/

    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        if (n == 1 && trust.isEmpty()) return 1
        val trustCount = IntArray(n + 1) { 0 }
        for ((a, b) in trust) {
            trustCount[a]--
            trustCount[b]++
        }
        for (i in 1..n) {
            if (trustCount[i] == n - 1) return i
        }
        return -1
    }
}