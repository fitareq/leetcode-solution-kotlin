package problems

import java.util.PriorityQueue

/**
 * 1792. Maximum Average Pass Ratio
 * https://leetcode.com/problems/maximum-average-pass-ratio/
 *
 * Time Complexity Analysis:
 * - Building initial heap: O(N * log N) where N is number of classes
 * - Processing extra students: O(E * log N) where E is number of extra students
 *   - For each student: O(log N) for heap operations (poll and offer)
 * - Final calculation: O(N) for summing up all ratios
 * Overall: O(N * log N + E * log N) = O((N + E) * log N)
 *
 * Space Complexity Analysis:
 * - Priority Queue: O(N) to store all classes
 * - Input array reference: O(N) for the classes array
 * - Other variables: O(1)
 * Overall: O(N)
 *
 * There is a school that has classes of students and each class will be having a final exam.
 * You are given a 2D integer array classes, where classes[i] = [passi, totali]. You know beforehand
 * that in the ith class, there are totali total students, but only passi number of students will pass the exam.
 *
 * You are also given an integer extraStudents. There are another extraStudents brilliant students that
 * are guaranteed to pass the exam of any class they are assigned to. You want to assign each of the
 * extraStudents students to a class in a way that maximizes the average pass ratio across all the classes.
 *
 * The pass ratio of a class is equal to the number of students of the class that will pass the exam
 * divided by the total number of students of the class. The average pass ratio is the sum of pass ratios
 * of all the classes divided by the number of classes.
 *
 * Return the maximum possible average pass ratio after assigning the extraStudents students.
 * Answers within 10^-5 of the actual answer will be accepted.
 *
 * Example 1:
 * Input: classes = [[1,2],[3,5],[2,2]], extraStudents = 2
 * Output: 0.78333
 * Explanation: You can assign the two extra students to the first class. The average pass ratio will be
 * (3/4 + 3/5 + 2/2) / 3 = 0.78333.
 *
 * Example 2:
 * Input: classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
 * Output: 0.53485
 *
 * Constraints:
 * - 1 <= classes.length <= 10^5
 * - classes[i].length == 2
 * - 1 <= passi <= totali <= 10^5
 * - 1 <= extraStudents <= 10^5
 */
class MaximumAveragePassRatio {
    /**
     * Calculates the improvement in pass ratio when adding one student to a class.
     * 
     * @param pass Current number of passing students
     * @param total Current total number of students
     * @return The difference between new ratio and current ratio
     * Example: If a class has 1 passing out of 2 students (0.5),
     * adding 1 student makes it 2 out of 3 (0.667), so improvement is 0.167
     */
    private fun incrementRatio(pass: Int, total: Int): Double {
        val curAvg = pass.toDouble() / total
        val newAvg = (pass + 1).toDouble() / (total + 1)
        return newAvg - curAvg
    }

    /**
     * Calculates the maximum possible average pass ratio after assigning extra students.
     * 
     * Algorithm:
     * 1. Create a max heap (PriorityQueue) to store classes sorted by potential improvement
     *    in pass ratio when adding one student
     * 2. For each extra student:
     *    - Remove the class with highest potential improvement
     *    - Add one student to that class (both pass and total)
     *    - Recalculate its new potential improvement and add back to heap
     * 3. Finally calculate the average pass ratio across all classes
     * 
     * Time Complexity: O(E * log N) where E is extraStudents and N is number of classes
     * Space Complexity: O(N) for storing the priority queue
     * 
     * @param classes Array of [pass, total] arrays representing each class
     * @param extraStudents Number of extra students to assign
     * @return Maximum possible average pass ratio
     */
    fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
        // MaxHeap storing pairs of (improvement in ratio, class index)
        val maxHeap = PriorityQueue<Pair<Double, Int>>(compareByDescending { it.first })
        
        // Calculate initial improvements for all classes
        classes.forEachIndexed { index, (pass, total) ->
            maxHeap.offer(Pair(incrementRatio(pass, total), index))
        }
        
        // Assign each extra student to the class that benefits most
        repeat(extraStudents) {
            val (_, index) = maxHeap.poll()
            classes[index][0]++ // Increment passing students
            classes[index][1]++ // Increment total students
            val (pass, total) = classes[index]
            maxHeap.offer(Pair(incrementRatio(pass, total), index))
        }
        
        // Calculate final average pass ratio
        val maxAvg = classes.sumOf { it[0].toDouble() / it[1] } / classes.size
        return String.format("%.5f", maxAvg).toDouble()
    }
}
