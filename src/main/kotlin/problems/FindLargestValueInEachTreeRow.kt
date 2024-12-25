package problems

import java.util.LinkedList
import java.util.Queue

class FindLargestValueInEachTreeRow {
    fun largestValues(root: TreeNode?): List<Int> {
        val q: Queue<TreeNode> = LinkedList()
        q.offer(root)
        val result = mutableListOf<Int>()
        while (q.isNotEmpty()) {
            val n = q.size
            var levelMax = Int.MIN_VALUE
            for (i in 0..<n) {
                val curr = q.poll()
                if (curr.`val` > levelMax) levelMax = curr.`val`
                if (curr.left != null) q.offer(curr.left)
                if (curr.right != null) q.offer(curr.right)
            }

            result.add(levelMax)
        }

        return result
    }
}