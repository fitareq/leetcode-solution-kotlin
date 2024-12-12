import java.util.*
import kotlin.math.sqrt

/**
 * Problem: Take Gifts From the Richest Pile
 * https://leetcode.com/problems/take-gifts-from-the-richest-pile/description/
 *
 * You are given an array of integers `gifts` where each integer represents the number of gifts in a pile.
 * In one operation, you can pick the richest pile (pile with the maximum gifts),
 * take its square root (rounded down to the nearest integer), and return the remaining gifts back to the pile.
 * You can perform this operation at most `k` times.
 * The goal is to return the total number of gifts remaining after at most `k` operations.
 *
 * Example 1:
 * Input: gifts = [25,64,9,4,100], k = 4
 * Output: 29
 * Explanation: The operations are as follows:
 * - Take the square root of 100, result is 10. Remaining gifts: [25,64,9,4,10]
 * - Take the square root of 64, result is 8. Remaining gifts: [25,8,9,4,10]
 * - Take the square root of 25, result is 5. Remaining gifts: [5,8,9,4,10]
 * - Take the square root of 10, result is 3. Remaining gifts: [5,8,9,4,3]
 * Sum of gifts: 5 + 8 + 9 + 4 + 3 = 29
 *
 * Example 2:
 * Input: gifts = [1,1,1,1], k = 4
 * Output: 4
 * Explanation: No operation is needed as all piles have 1 gift.
 * Sum of gifts: 1 + 1 + 1 + 1 = 4
 *
 * Constraints:
 * - 1 <= gifts.length <= 10^3
 * - 1 <= gifts[i] <= 10^9
 * - 1 <= k <= 10^3
 *
 */

class TakeGiftsFromRichestPile {
    /**
     * Picks gifts from the richest pile and returns the total number of gifts remaining after k operations.
     *
     * Time Complexity: O(k log n), where n is the size of the heap (number of piles).
     * Space Complexity: O(n), for storing the heap.
     *
     * @param gifts An array of integers representing the number of gifts in each pile.
     * @param k The maximum number of operations allowed.
     * @return The total number of gifts remaining after at most k operations.
     */
    fun pickGifts(gifts: IntArray, k: Int): Long {
        // Initialize a max-heap to efficiently retrieve the richest pile.
        val res = PriorityQueue<Int>(compareByDescending { it })
        res.addAll(gifts.asList())

        // Perform up to k operations or stop early if the richest pile has only 1 gift.
        for (i in 1..k) {
            // Stop if the richest pile has only 1 gift, as no further reduction is possible.
            if (res.peek() == 1) break

            // Remove the richest pile (poll retrieves and removes the maximum element).
            val sr: Int = sqrt(res.poll().toDouble()).toInt()

            // Add the square root of the richest pile back into the heap.
            res.add(sr)
        }

        // Calculate the sum of all remaining gifts in the heap.
        return res.sumOf { it.toLong() }
    }
}
