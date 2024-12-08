package problems

/**
 * Problem: Two Best Non-Overlapping Events
 *
 * You are given a 0-indexed 2D integer array events where events[i] = [startTimei, endTimei, valuei].
 * The ith event starts at startTimei and ends at endTimei, and if you attend this event, you will receive a value of valuei.
 * You can attend at most two non-overlapping events, but only one at a time.
 *
 * Two events are non-overlapping if the start time of one event is strictly greater than the end time of another event.
 * Return the maximum sum of values that you can receive by attending at most two events.
 *
 * Solution approaches:
 * 1. Line Sweep:
 *    - Create points for start and end of each event
 *    - Sort points by time
 *    - Track maximum value seen so far
 *    - Time: O(n * log(n)), Space: O(n)
 *
 * 2. Binary Search:
 *    - Sort events by start time
 *    - For each event as first event:
 *      * Binary search for next possible event
 *      * Track maximum value after current end time
 *    - Time: O(n * log(n)), Space: O(n)
 *
 * @param events Array of events where each event is [startTime, endTime, value]
 * @return Maximum sum of values from two non-overlapping events
 */
class TwoBestNonOverlappingEvents {
    // Solution 1: Line Sweep
    fun maxTwoEvents(events: Array<IntArray>): Int {
        val lineSweep = arrayListOf<IntArray>()
        events.sortWith(compareBy{it[0]})
        for ((start, end, value) in events) {
            lineSweep.add(intArrayOf(start, 1, value))
            lineSweep.add(intArrayOf(end + 1, -1, value))
        }

        lineSweep.sortWith(compareBy { it[0] })

        var maxValue = 0
        var maxSeen = 0

        for ((_, type, value) in lineSweep) {
            if (type == 1) {
                maxValue = maxOf(maxValue, value + maxSeen)
            }else{
                maxSeen = maxOf(maxSeen, value)
            }
        }
        return maxValue
    }

    // Solution 2: Binary Search
    fun maxTwoEventsBinarySearch(events: Array<IntArray>): Int {
        events.sortWith(compareBy { it[0] })
        val n = events.size
        
        val maxEndingAt = IntArray(n)
        maxEndingAt[n - 1] = events[n - 1][2]
        
        for (i in n - 2 downTo 0) {
            maxEndingAt[i] = maxOf(maxEndingAt[i + 1], events[i][2])
        }
        
        var maxSum = maxEndingAt[0]
        
        for (i in 0 until n - 1) {
            val currentValue = events[i][2]
            
            val nextIndex = binarySearch(events, i + 1, events[i][1])
            if (nextIndex < n) {
                maxSum = maxOf(maxSum, currentValue + maxEndingAt[nextIndex])
            }
            maxSum = maxOf(maxSum, currentValue)
        }
        
        return maxSum
    }
    
    private fun binarySearch(events: Array<IntArray>, start: Int, targetEnd: Int): Int {
        var left = start
        var right = events.size
        
        while (left < right) {
            val mid = left + (right - left) / 2
            if (events[mid][0] > targetEnd) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        
        return left
    }
}
