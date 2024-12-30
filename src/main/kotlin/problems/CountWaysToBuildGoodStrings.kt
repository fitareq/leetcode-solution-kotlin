package problems

/**
 * 2466.Count Ways To Build Good Strings
 * https://leetcode.com/problems/count-ways-to-build-good-strings/description/
 *
 * Given the integers zero, one, low, and high, we can construct a string by starting with an empty string, and then at each step perform either of the following:
 *
 * Append the character '0' zero times.
 * Append the character '1' one times.
 * This can be performed any number of times.
 *
 * A good string is a string constructed by the above process having a length between low and high (inclusive).
 *
 * Return the number of different good strings that can be constructed satisfying these properties. Since the answer can be large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: low = 3, high = 3, zero = 1, one = 1
 * Output: 8
 * Explanation:
 * One possible valid good string is "011".
 * It can be constructed as follows: "" -> "0" -> "01" -> "011".
 * All binary strings from "000" to "111" are good strings in this example.
 *
 *
 * Example 2:
 *
 * Input: low = 2, high = 3, zero = 1, one = 2
 * Output: 5
 * Explanation: The good strings are "00", "11", "000", "110", and "011".
 *
 *
 * Constraints:
 *
 * - 1 <= low <= high <= 105
 * - 1 <= zero, one <= low
 */
class CountWaysToBuildGoodStrings {
    /* fun countGoodStrings(low: Int, high: Int, zero: Int, one: Int): Int {
         val mod = 1_000_000_007
         val result = HashMap<Int, Int>()
         fun helper(length: Int): Int {
             if (length > high) return 0

             if (result.containsKey(length)) return result[length]!!
             result[length] = if (length >= low) 1 else 0

             result[length] = (result[length]!! + (helper(length + zero) + helper(length + one))) % mod

             return (result[length]!! % mod)

         }

         return helper(0)
     }*/

    /**
     * Time Complexity: O(n)
     * - The `for` loop iterates from 1 to `n`, where `n` is the maximum length (`high`). This takes O(n).
     * - The range sum `(m..n).sumOf` iterates over the range from `m` (minimum length `low`) to `n`, which is bounded by O(n).
     *
     * Space Complexity: O(n)
     * - The `result` map stores up to `n` entries, where `n` is the maximum length (`high`), requiring O(n) space.
     */
    fun countGoodStrings(low: Int, high: Int, zero: Int, one: Int): Int {
        val mod = 1_000_000_007 // Define the modulus to keep the result within bounds of a large prime number.
        val result = mutableMapOf(0 to 1)
        // Initialize a map to store the number of ways to form strings of specific lengths.
        // The key is the length, and the value is the count of ways to form that length.
        // Start with length 0 having 1 way (an empty string).

        for (i in 1..high) {
            // Loop through all lengths from 1 to the maximum length (`high`).
            result[i] = ((result.getOrDefault(i - one, 0)) + (result.getOrDefault(i - zero, 0))) % mod
            // Calculate the number of ways to form a string of length `i`:
            // - If `i - one` exists, we can add `one` characters to that length.
            // - If `i - zero` exists, we can add `zero` characters to that length.
            // - Add these values (defaulting to 0 if not found) and take modulo `mod`.
        }

        return ((low..high).sumOf { result[it]!!.toLong() } % mod).toInt()
        // Sum up the counts for all lengths from `low` to `high`.
        // Convert to `Long` during the summation to handle large values.
        // Take modulo `mod` of the final result to ensure it stays within bounds, and return it as an `Int`.
    }


}