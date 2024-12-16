package problems

/**
 * 2054. Two Best Non-Overlapping Events
 * https://leetcode.com/problems/two-best-non-overlapping-events/
 *
 * You are given a 0-indexed 2D integer array of events where events[i] = [startTimei, endTimei, valuei].
 * The ith event starts at startTimei and ends at endTimei, and if you attend this event, you can
 * receive a value of valuei.
 *
 * You can attend at most two events, and the events you choose to attend must not overlap.
 *
 * Return the maximum sum of values that you can receive by attending at most two events.
 *
 * Note that the start time and end time is inclusive: that is, you cannot attend two events where one
 * of them starts and the other ends at the same time. More specifically, if you attend an event with
 * end time t, the next event must start at a time strictly greater than t.
 *
 * Example 1:
 * Input: events = [[1,3,2],[4,5,2],[2,4,3]]
 * Output: 4
 * Explanation:
 * Choose the green events, [1,3,2] and [4,5,2].
 * The sum of the values is 2 + 2 = 4.
 * Notice that the events [2,4,3] and [4,5,2] overlap, so you cannot attend both.
 *
 * Example 2:
 * Input: events = [[1,3,2],[4,5,2],[1,5,5]]
 * Output: 5
 * Explanation:
 * Choose event [1,5,5], and you will receive a value of 5.
 * You cannot choose any other events, as they would overlap with the one you chose.
 *
 * Example 3:
 * Input: events = [[1,2,4],[3,4,3],[2,3,1]]
 * Output: 7
 * Explanation:
 * Choose the events [1,2,4] and [3,4,3].
 * The sum of the values is 4 + 3 = 7.
 *
 * Constraints:
 * - 2 <= events.length <= 10^5
 * - events[i].length == 3
 * - 1 <= startTimei <= endTimei <= 10^9
 * - 1 <= valuei <= 10^6
 */
class TwoBestNonOverlappingEvents {
    /**
     * Time Complexity: O(n log n)
     * - Sorting events takes O(n log n)
     * - Processing each event takes O(log n) for binary search
     * - Where n is the number of events
     *
     * Space Complexity: O(n)
     * - Sorted events array takes O(n) space
     * - Where n is the number of events
     */
    fun maxTwoEvents(events: Array<IntArray>): Int {
        // Sort events by start time
        events.sortBy { it[0] }
        
        var maxValue = 0  // Maximum value from a single event
        var result = 0    // Maximum value from two non-overlapping events
        
        // Process each event
        for (i in events.indices) {
            val (start, end, value) = events[i]
            
            // Try to find a non-overlapping event before current event
            val prevMaxValue = findMaxValueBefore(events, 0, i - 1, start)
            
            // Update result with maximum of:
            // 1. Current maximum (result)
            // 2. Current event value (value)
            // 3. Current event + best non-overlapping previous event (value + prevMaxValue)
            result = maxOf(result, value, value + prevMaxValue)
            
            // Update maximum value seen so far
            maxValue = maxOf(maxValue, value)
        }
        
        return result
    }
    
    /**
     * Binary search to find maximum value from events that end before given start time
     */
    private fun findMaxValueBefore(
        events: Array<IntArray>,
        left: Int,
        right: Int,
        targetStart: Int
    ): Int {
        var maxValue = 0
        var low = left
        var high = right
        
        while (low <= high) {
            val mid = (low + high) / 2
            
            if (events[mid][1] < targetStart) {
                // Current event ends before target start,
                // update maxValue and look for better in right half
                maxValue = maxOf(maxValue, events[mid][2])
                low = mid + 1
            } else {
                // Current event overlaps with target,
                // look in left half
                high = mid - 1
            }
        }
        
        return maxValue
    }
}
