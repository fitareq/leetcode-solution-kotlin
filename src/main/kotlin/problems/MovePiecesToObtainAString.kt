package problems

/**
 * Problem: Move Pieces to Obtain a String
 * https://leetcode.com/problems/move-pieces-to-obtain-a-string/
 *
 * You are given two strings start and target, both of length n. Each string consists only of the
 * characters 'L', 'R', and '_'. A move consists of choosing any character '_' and moving it to any position.
 *
 * Example:
 * Input: start = "_L__R__R_", target = "L______RR"
 * Output: true
 * Explanation: We can obtain the string target from start by moving the '_' to get "L___R__R_",
 * then "_L__RR___", and finally "L______RR"
 *
 * Time Complexity: O(n) where n is the length of the strings
 * Space Complexity: O(1)
 *
 * @param start The starting string
 * @param target The target string
 * @return Boolean indicating if it's possible to convert start to target
 */
class MovePiecesToObtainAString {
    /**
     * Checks if it's possible to convert the start string to the target string by moving the '_' characters.
     *
     * @param start The starting string
     * @param target The target string
     * @return Boolean indicating if it's possible to convert start to target
     */
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

    /**
     * Skips the '_' characters in the string starting from the given position.
     *
     * @param str The input string
     * @param pos The starting position
     * @return The position after skipping the '_' characters
     */
    private fun skipSpaces(str: String, pos: Int): Int {
        var result = pos
        while (result < str.length && str[result] == '_') {
            result++
        }

        return result
    }
}