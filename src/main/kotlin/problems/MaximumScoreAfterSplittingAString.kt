package problems

import kotlin.math.max

/**
 * Maximum Score After Splitting a String
 * https://leetcode.com/problems/maximum-score-after-splitting-a-string/description/
 */
class MaximumScoreAfterSplittingAString {
    fun maxScore(s: String): Int {
        val n = s.length
        val prefixSum = IntArray(n) { 0 }
        var sum = 0
        for (i in n - 1 downTo 0) {
            if (s[i] == '1') {
                sum++
            }
            prefixSum[i] = sum
        }
        var maxScore = Int.MIN_VALUE
        sum = 0
        for (i in 0..<n-1) {
            if (s[i] == '0') {
                sum++
            }

            maxScore = max(maxScore, sum + prefixSum[i+1])
        }

        return maxScore
    }
}