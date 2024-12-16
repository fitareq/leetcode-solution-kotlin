package problems

/**
 * 2337. Move Pieces to Obtain a String
 * https://leetcode.com/problems/move-pieces-to-obtain-a-string/
 *
 * You are given two strings start and target, both of length n. Each string consists only of the
 * characters 'L', 'R', and '_' where:
 * - The characters 'L' and 'R' represent pieces, where a piece 'L' can move to the left only if there
 *   is a blank space '_' to its left, and a piece 'R' can move to the right only if there is a blank
 *   space '_' to its right.
 * - The character '_' represents a blank space that can be occupied by any of the 'L' or 'R' pieces.
 *
 * Return true if it is possible to obtain the string target by moving the pieces of the string start
 * any number of times. Otherwise, return false.
 *
 * Example 1:
 * Input: start = "_L__R__R_", target = "L______RR"
 * Output: true
 * Explanation:
 * We can obtain the string target from start by doing the following moves:
 * - Move the first 'L' piece one step to the left, start becomes "L___R__R_"
 * - Move the second 'R' piece three steps to the right, start becomes "L______RR"
 * Since we can obtain the string target, we return true.
 *
 * Example 2:
 * Input: start = "R_L_", target = "__LR"
 * Output: false
 * Explanation:
 * The 'R' piece in the string start can move one step to the right to obtain "_RL_".
 * After that, no pieces can move anymore, so it is impossible to obtain the string target.
 *
 * Example 3:
 * Input: start = "_R", target = "R_"
 * Output: false
 * Explanation:
 * The piece in the string start can move only to the right, so it is impossible to obtain the string
 * target, which has the piece to the left of a blank space.
 *
 * Constraints:
 * - n == start.length == target.length
 * - 1 <= n <= 10^5
 * - start and target consist of the characters 'L', 'R', and '_'
 */
class MovePiecesToObtainAString {
    /**
     * Time Complexity: O(n)
     * - Single pass through both strings
     * - Where n is the length of the strings
     *
     * Space Complexity: O(1)
     * - Only uses a few variables regardless of input size
     */
    fun canChange(start: String, target: String): Boolean {
        // If strings differ in non-blank characters, return false
        if (start.replace("_", "") != target.replace("_", "")) {
            return false
        }
        
        var i = 0  // pointer for start string
        var j = 0  // pointer for target string
        val n = start.length
        
        // Compare positions of L and R pieces
        while (i < n && j < n) {
            // Skip blank spaces
            while (i < n && start[i] == '_') i++
            while (j < n && target[j] == '_') j++
            
            // If both pointers are out of bounds, strings match
            if (i == n && j == n) return true
            
            // If only one pointer is out of bounds, strings don't match
            if (i == n || j == n) return false
            
            // Check if current pieces match and are in valid positions
            if (start[i] != target[j]) return false
            
            if (start[i] == 'L' && i < j) return false  // L can't move right
            if (start[i] == 'R' && i > j) return false  // R can't move left
            
            i++
            j++
        }
        
        // Skip remaining blank spaces
        while (i < n && start[i] == '_') i++
        while (j < n && target[j] == '_') j++
        
        // Return true if both strings are fully processed
        return i == n && j == n
    }
}