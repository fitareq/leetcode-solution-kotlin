package problems

/**
 * Problem: Adding Spaces to a String
 * https://leetcode.com/problems/adding-spaces-to-a-string/
 *
 * You are given a string s and an array of integers spaces that describes the indices in the original
 * string where spaces will be added. Each space should be inserted before the character at the given index.
 *
 * Example:
 * Input: s = "LeetcodeHelpsMeLearn", spaces = [8,13,15]
 * Output: "Leetcode Helps Me Learn"
 *
 * Time Complexity: O(n) where n is the length of the input string
 * Space Complexity: O(n) for the resulting string
 *
 * @param s The input string
 * @param spaces Array of indices where spaces should be added
 * @return The string with spaces added at the specified positions
 */
class AddingSpacesToAString {

    /*fun addSpaces(s: String, spaces: IntArray): String {
        val result = StringBuilder()
        var start = 0
        for (i in spaces) {
            result.append(s.substring(start, i)).append(" ")
            start = i
        }
        result.append(s.substring(start))
        return result.toString()
    }*/

    fun addSpaces(s: String, spaces: IntArray): String {
        val spaceSet = spaces.toSet()

        return buildString {
            s.forEachIndexed { index, c ->
                if (spaceSet.contains(index)) {
                    append(" ")
                }

                append(c)
            }
        }
    }
}