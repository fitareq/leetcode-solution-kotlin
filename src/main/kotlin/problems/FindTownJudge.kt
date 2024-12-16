package problems

/**
 * 997. Find the Town Judge
 * https://leetcode.com/problems/find-the-town-judge/
 *
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly
 * the town judge.
 *
 * If the town judge exists, then:
 * 1. The town judge trusts nobody.
 * 2. Everybody (except for the town judge) trusts the town judge.
 * 3. There is exactly one person that satisfies properties 1 and 2.
 *
 * You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts
 * the person labeled bi. If a trust relationship does not exist in trust array, then such a trust
 * relationship does not exist.
 *
 * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 *
 * Example 1:
 * Input: n = 2, trust = [[1,2]]
 * Output: 2
 * Explanation:
 * - Person 1 trusts Person 2
 * - Person 2 trusts no one
 * Therefore, Person 2 is the town judge.
 *
 * Example 2:
 * Input: n = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 * Explanation:
 * - Person 1 trusts Person 3
 * - Person 2 trusts Person 3
 * - Person 3 trusts Person 1
 * No one satisfies both conditions, so there is no town judge.
 *
 * Example 3:
 * Input: n = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * Explanation:
 * - Person 1 trusts Person 3
 * - Person 2 trusts Person 3
 * - Person 3 trusts no one
 * Therefore, Person 3 is the town judge.
 *
 * Constraints:
 * - 1 <= n <= 1000
 * - 0 <= trust.length <= 10^4
 * - trust[i].length == 2
 * - All the pairs of trust are unique
 * - ai != bi
 * - 1 <= ai, bi <= n
 */
class FindTownJudge {
    /**
     * Time Complexity: O(E)
     * - Single pass through trust array
     * - Array operations are O(1)
     * - Where E is the number of trust relationships
     *
     * Space Complexity: O(N)
     * - Two arrays of size N+1 for tracking trust counts
     * - Where N is the number of people
     */
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        // Arrays to track incoming and outgoing trust relationships
        // trustsOthers[i] = number of people that person i trusts
        // trustedBy[i] = number of people that trust person i
        val trustsOthers = IntArray(n + 1)
        val trustedBy = IntArray(n + 1)
        
        // Count trust relationships
        for ((a, b) in trust) {
            trustsOthers[a]++  // a trusts someone
            trustedBy[b]++     // b is trusted by someone
        }
        
        // Find person who:
        // 1. Trusts nobody (trustsOthers[i] == 0)
        // 2. Is trusted by everyone else (trustedBy[i] == n-1)
        for (i in 1..n) {
            if (trustsOthers[i] == 0 && trustedBy[i] == n - 1) {
                return i
            }
        }
        
        return -1
    }
}