package problems
/**
 * Problem: Move Pieces to Obtain a String
 * https://leetcode.com/problems/move-pieces-to-obtain-a-string/
 *
 * You are given two strings start and target, both of length n. Each string consists only of the characters 'L', 'R', and '_'.
 * A move consists of choosing any character '_' and moving it to any position.
 * Return true if it's possible to convert start to target after some moves, otherwise return false.
 */
class MovePiecesToObtainAString {
    fun canChange(start: String, target: String): Boolean {
        var startIndex = 0
        var targetIndex = 0
        var lastIndex = -1
        val n = start.length
        while (startIndex < n) {
            startIndex = skipSpaces(start, startIndex)
            targetIndex = skipSpaces(target, targetIndex)

            if (startIndex == n && targetIndex == n) return true
            if (startIndex == n || targetIndex == n) return false
            if (start[startIndex] != target[targetIndex]) return false

            if (start[startIndex] == 'L' && (targetIndex > startIndex || targetIndex <= lastIndex)) return false
            if (start[startIndex] == 'R' && startIndex > targetIndex) return false

            lastIndex = targetIndex
            ++startIndex
            ++targetIndex

        }

        startIndex = skipSpaces(start, startIndex)
        targetIndex = skipSpaces(target, targetIndex)

        return startIndex == n && targetIndex == n

    }

    private fun skipSpaces(str: String, pos: Int): Int {
        var result = pos
        while (result < str.length && str[result] == '_') {
            result++
        }

        return result
    }
}