package problems

/**
 * 1014. Best Sightseeing Pair
 * https://leetcode.com/problems/best-sightseeing-pair/description
 *
 * You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing spots i and j have a distance j - i between them.
 *
 * The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.
 *
 * Return the maximum score of a pair of sightseeing spots.
 *
 *
 *
 * Example 1:
 *
 * Input: values = [8,1,5,2,6]
 * Output: 11
 * Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
 * Example 2:
 *
 * Input: values = [1,2]
 * Output: 2
 *
 *
 *
 * Constraints:
 *
 * 2 <= values.length <= 5 * 104
 * 1 <= values[i] <= 1000
 */
class BestSightseeingPair {
    /**
     * Time Complexity:O(n)
     * The loop iterates through the array once, making the algorithm linear in time.
     *
     * Space Complexity:O(1)
     * Only a constant amount of extra space is used.
     */
    fun maxScoreSightseeingPair(values: IntArray): Int {
        val n = values.size
        var first = values[0] // Initialize `first` to represent the max value of `values[i] + i` seen so far.
        var maxScore = 0 // Variable to track the maximum sightseeing score.

        for (i in 1 until n) { // Iterate from the second element to the end of the array.
            val second = values[i] - i // Calculate `values[j] - j` for the current index `i`.

            // Update the maximum score by considering the current pair `(i, j)`
            // where `first` is the best `values[i] + i` seen so far.
            maxScore = maxOf(maxScore, first + second)

            // Update `first` to the maximum `values[i] + i` for future iterations.
            first = maxOf(first, values[i] + i)
        }

        return maxScore // Return the maximum score found.
    }

}