package problems

/**
 * 2951. Find the Peaks
 * https://leetcode.com/problems/find-the-peaks/
 *
 * You are given a 0-indexed array mountain. Your task is to find all the peaks in the mountain array.
 *
 * Return an array that consists of indices of peaks in the given array in any order.
 *
 * Notes:
 * - A peak is defined as an element that is strictly greater than its neighboring elements.
 * - The first and last elements of the array are not peaks.
 *
 * Example 1:
 * Input: mountain = [2,4,4]
 * Output: []
 * Explanation:
 * mountain[0] = 2 is not a peak since it is the first element.
 * mountain[1] = 4 is not a peak since it is equal to its right neighbor.
 * mountain[2] = 4 is not a peak since it is the last element.
 * There are no peaks in this array, so we return an empty array.
 *
 * Example 2:
 * Input: mountain = [1,4,3,8,5]
 * Output: [1,3]
 * Explanation:
 * mountain[0] = 1 is not a peak since it is the first element.
 * mountain[1] = 4 is a peak since it is greater than its neighbors 1 and 3.
 * mountain[2] = 3 is not a peak since it is not greater than its neighbors.
 * mountain[3] = 8 is a peak since it is greater than its neighbors 3 and 5.
 * mountain[4] = 5 is not a peak since it is the last element.
 * So we return [1,3].
 *
 * Constraints:
 * - 3 <= mountain.length <= 100
 * - 1 <= mountain[i] <= 100
 */
class SpecialArrayII {
    /**
     * Time Complexity: O(n)
     * - Single pass through the array
     * - Where n is the length of mountain array
     *
     * Space Complexity: O(k)
     * - Result list stores k peaks
     * - Where k is the number of peaks found
     */
    fun findPeaks(mountain: IntArray): List<Int> {
        val peaks = mutableListOf<Int>()
        
        // Check each element (except first and last) for peak condition
        for (i in 1 until mountain.size - 1) {
            // Element is a peak if strictly greater than both neighbors
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                peaks.add(i)
            }
        }
        
        return peaks
    }
}
