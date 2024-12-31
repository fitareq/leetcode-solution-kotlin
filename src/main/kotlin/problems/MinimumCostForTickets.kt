package problems

/**
 * 983.Minimum Cost For Tickets
 * https://leetcode.com/problems/minimum-cost-for-tickets/description/
 */
class MinimumCostForTickets {

    /**
     * Time Complexity: O(n)
     *
     * Space Complexity: O(n)
     */
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        val n = days.size // Store the number of days in the input array.
        val dp = IntArray(n + 1) { -1 } // Initialize a memoization array with size n+1 and fill it with -1.

        // Recursive function to calculate the minimum cost starting from the given index.
        fun solve(index: Int): Int {
            if (index >= n) // Base case: If the index exceeds the array, return 0 as no more tickets are needed.
                return 0
            if (dp[index] != -1) // If the result for the current index is already computed, return it.
                return dp[index]

            // Calculate the cost if buying a 1-day ticket.
            val option1 = costs[0] + solve(index + 1)

            // Calculate the cost if buying a 7-day ticket.
            var i = index // Initialize a pointer starting at the current index.
            while (i < n && days[i] < days[index] + 7) i++ // Move the pointer to the first day outside the 7-day range.
            val option2 = costs[1] + solve(i)

            // Calculate the cost if buying a 30-day ticket.
            i = index // Reset the pointer to the current index.
            while (i < n && days[i] < days[index] + 30) i++ // Move the pointer to the first day outside the 30-day range.
            val option3 = costs[2] + solve(i)

            // Store the minimum cost for the current index in the memoization array.
            dp[index] = minOf(option1, option2, option3)
            return dp[index] // Return the computed result.
        }

        return solve(0) // Start solving from the first day.
    }

}