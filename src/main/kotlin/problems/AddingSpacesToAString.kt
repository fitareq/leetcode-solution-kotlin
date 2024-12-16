package problems

/**
 * 2109. Adding Spaces to a String
 * https://leetcode.com/problems/adding-spaces-to-a-string/
 *
 * You are given a 0-indexed string s and a 0-indexed integer array spaces that describes the indices in
 * the original string where spaces will be added. Each space should be inserted before the character at
 * the given index.
 *
 * For example, given s = "EnjoyYourCoffee" and spaces = [5, 9], we should:
 * - Add a space before s[5], making it "Enjoy YourCoffee"
 * - Add a space before s[9], making it "Enjoy Your Coffee"
 *
 * Return the modified string after the spaces have been added.
 *
 * Example 1:
 * Input: s = "LeetcodeHelpsMeLearn", spaces = [8,13,15]
 * Output: "Leetcode Helps Me Learn"
 * Explanation:
 * - Add a space before s[8] = "H", making it "Leetcode HelpsMeLearn"
 * - Add a space before s[13] = "M", making it "Leetcode Helps MeLearn"
 * - Add a space before s[15] = "L", making it "Leetcode Helps Me Learn"
 *
 * Example 2:
 * Input: s = "icodeinpython", spaces = [1,5,7,9]
 * Output: "i code in py thon"
 * Explanation:
 * - Add a space before s[1] = "c", making it "i codeinpython"
 * - Add a space before s[5] = "i", making it "i code inpython"
 * - Add a space before s[7] = "p", making it "i code in python"
 * - Add a space before s[9] = "t", making it "i code in py thon"
 *
 * Example 3:
 * Input: s = "spacing", spaces = [0,1,2,3,4,5,6]
 * Output: " s p a c i n g"
 * Explanation: Add a space before every existing character.
 *
 * Constraints:
 * - 1 <= s.length <= 3 * 10^5
 * - s consists of only lowercase and uppercase English letters
 * - 1 <= spaces.length <= 3 * 10^5
 * - 0 <= spaces[i] <= s.length - 1
 * - All the values of spaces are strictly increasing
 */
class AddingSpacesToAString {
    /**
     * Time Complexity: O(n)
     * - Single pass through the string
     * - StringBuilder operations are O(1) amortized
     * - Where n is the length of the input string
     *
     * Space Complexity: O(n)
     * - StringBuilder to store result string
     * - Additional O(1) for index variables
     * - Where n is the length of the input string plus spaces
     */
    fun addSpaces(s: String, spaces: IntArray): String {
        // Initialize StringBuilder with capacity for string + spaces
        val result = StringBuilder(s.length + spaces.size)
        var spaceIndex = 0
        
        // Process each character in the string
        for (i in s.indices) {
            // If current position needs a space, add it
            if (spaceIndex < spaces.size && i == spaces[spaceIndex]) {
                result.append(' ')
                spaceIndex++
            }
            // Add current character
            result.append(s[i])
        }
        
        return result.toString()
    }
}