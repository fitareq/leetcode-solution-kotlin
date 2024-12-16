package problems

import java.util.*
import kotlin.math.sqrt

/**
 * 2558. Take Gifts From the Richest Pile
 * https://leetcode.com/problems/take-gifts-from-the-richest-pile/
 *
 * You are given an integer array gifts denoting the number of gifts in various piles. Every second,
 * you do the following:
 * - Choose the pile with the maximum number of gifts.
 * - If there is more than one pile with the maximum number, choose any.
 * - Leave behind the floor of the square root of the number of gifts in the pile.
 * - Take the rest of the gifts.
 *
 * Return the number of gifts remaining after k seconds.
 *
 * Example 1:
 * Input: gifts = [25,64,9,4,100], k = 4
 * Output: 29
 * Explanation:
 * The gifts are taken in the following way:
 * - In the first second, the last pile is chosen and sqrt(100) = 10 gifts are left behind.
 * - Then the second pile is chosen and sqrt(64) = 8 gifts are left behind.
 * - Then the first pile is chosen and sqrt(25) = 5 gifts are left behind.
 * - Finally the last pile is chosen again and sqrt(10) = 3 gifts are left behind.
 * The final remaining gifts are [5,8,9,4,3], so the total number of gifts remaining is 29.
 *
 * Example 2:
 * Input: gifts = [1,1,1,1], k = 4
 * Output: 4
 * Explanation:
 * In this case, regardless of which pile you choose, you have to leave behind 1 gift in each pile.
 * That is, you can't take any gifts from any pile.
 * So, the total gifts remaining are 4.
 *
 * Constraints:
 * - 1 <= gifts.length <= 10^3
 * - 1 <= gifts[i] <= 10^9
 * - 1 <= k <= 10^3
 */
class TakeGiftsFromRichestPile {
    /**
     * Time Complexity: O(k * log n)
     * - Initial heap creation: O(n)
     * - k operations, each taking O(log n) for heap operations
     * - Where n is the length of gifts array
     *
     * Space Complexity: O(n)
     * - Priority queue stores n elements
     * - Where n is the length of gifts array
     */
    fun pickGifts(gifts: IntArray, k: Int): Long {
        // Create max heap to efficiently get maximum gift pile
        val maxHeap = PriorityQueue<Int>(compareByDescending { it })
        gifts.forEach { maxHeap.offer(it) }
        
        // Process k seconds
        repeat(k) {
            // Take sqrt of max pile and put back in heap
            val maxGifts = maxHeap.poll()
            val remaining = sqrt(maxGifts.toDouble()).toInt()
            maxHeap.offer(remaining)
        }
        
        // Sum remaining gifts
        return maxHeap.sumOf { it.toLong() }
    }
}
