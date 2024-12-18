package problems
/**
 * 1475. Final Prices With a Special Discount in a Shop
 * https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop
 *
 * You are given an integer array `prices` where `prices[i]` is the price of the `i`th item in a shop.
 *
 * There is a special discount for items purchased. You are given the condition: if you buy the `i`th item, you will receive a discount
 * equivalent to the price of the first subsequent item that is less than or equal to the price of the `i`th item. If no such item exists,
 * you will not receive any discount at all.
 *
 * Return an array where the `i`th element is the final price you will pay for the `i`th item after the discount.
 *
 * ### Example:
 * #### Example 1:
 * Input: `prices = [8, 4, 6, 2, 3]`
 * Output: `[4, 2, 4, 2, 3]`
 * Explanation:
 * - For item 0, the price is `8`, and the next smaller or equal price is `4` (at index 1), so the final price is `8 - 4 = 4`.
 * - For item 1, the price is `4`, and the next smaller or equal price is `2` (at index 3), so the final price is `4 - 2 = 2`.
 * - For item 2, the price is `6`, and the next smaller or equal price is `2` (at index 3), so the final price is `6 - 2 = 4`.
 * - For item 3, the price is `2`, and there is no smaller or equal price in the rest of the array, so the final price is `2`.
 * - For item 4, the price is `3`, and there is no smaller or equal price in the rest of the array, so the final price is `3`.
 *
 * #### Example 2:
 * Input: `prices = [1, 2, 3, 4, 5]`
 * Output: `[1, 2, 3, 4, 5]`
 * Explanation: In this case, no item has a smaller or equal price in the rest of the array.
 *
 * #### Example 3:
 * Input: `prices = [10, 1, 1, 6]`
 * Output: `[9, 0, 1, 6]`
 *
 * ### Constraints:
 * - `1 <= prices.length <= 500`
 * - `1 <= prices[i] <= 1000`
 */
class FinalPricesWithSpecialDiscountInAShop {
    /**
     * Time Complexity: O(n^2), where `n` is the size of the `prices` array.
     * - For each element in `prices`, the inner loop runs in the worst case for all remaining elements.
     * - In total, the number of iterations is approximately (n-1) + (n-2) + ... + 1 = O(n^2).
     *
     * Space Complexity: O(1).
     * - The function modifies the input array `prices` in place and does not use any additional data structures.
     */
    fun finalPrices(prices: IntArray): IntArray {
        // Iterate through each item's price in the array
        for (i in prices.indices) {
            // Check all subsequent items for a valid discount
            for (j in i + 1 until prices.size) {
                // If a discount is found (a price less than or equal to the current price)
                if (prices[j] <= prices[i]) {
                    // Apply the discount by subtracting the subsequent price from the current price
                    prices[i] = prices[i] - prices[j]
                    // Stop searching for further discounts for the current item
                    break
                }
            }
        }
        // Return the updated prices array with the discounts applied
        return prices
    }

}