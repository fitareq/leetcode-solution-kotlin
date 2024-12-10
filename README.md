# LeetCode Solutions in Kotlin 🎯

This repository contains my solutions to various LeetCode problems, primarily implemented in Kotlin. Each solution includes detailed explanations, multiple approaches, and comprehensive test cases.

## Project Structure 📁

```
leetcode/
├── src/
│   ├── main/kotlin/problems/
│   │   ├── AddingSpacesToAString.kt
│   │   ├── BinaryTreeInorderTraversal.kt
│   │   ├── DoubleExists.kt
│   │   ├── FindCenterOfStarGraph.kt
│   │   ├── FindTownJudge.kt
│   │   ├── FindLongestSpecialSubstringThatOccursThriceI.kt
│   │   ├── MakeStringSubsequenceUsingCyclicIncrements.kt
│   │   ├── MaximumIntegersToChoose.kt
│   │   ├── MinimumLimitOfBalls.kt
│   │   ├── MinimumObstacleRemoval.kt
│   │   ├── MinimumOperationsToMakeEqual.kt
│   │   ├── MovePiecesToObtainAString.kt
│   │   ├── PrefixOfAnyWord.kt
│   │   ├── SameTree.kt
│   │   ├── SpecialArrayII.kt
│   │   ├── TwoBestNonOverlappingEvents.kt
│   │   └── TwoSum.kt
│   └── test/kotlin/problems/
│       └── [Corresponding test files]
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## Problems Solved 📚

### Array Problems
1. [Two Sum](https://leetcode.com/problems/two-sum/)
   - HashMap approach
   - Time: O(n), Space: O(n)

2. [Check If N and Its Double Exist](https://leetcode.com/problems/check-if-n-and-its-double-exist/)
   - HashSet approach
   - Time: O(n), Space: O(n)

3. [Maximum Number of Integers to Choose From a Range I](https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/)
   - Multiple approaches implemented:
     * Linear scan with HashSet - Time: O(n), Space: O(b)
     * Early termination - Time: O(min(n, maxSum)), Space: O(b)
     * Binary search - Time: O(log(n) * n), Space: O(b)
   - Where b is the length of banned array

4. [Minimum Limit of Balls in a Bag](https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/)
   - Binary search approach
   - Time: O(n * log(M)), Space: O(1)
   - Where M is the maximum value in nums

5. [Two Best Non-Overlapping Events](https://leetcode.com/problems/two-best-non-overlapping-events/)
   - Line sweep algorithm with event tracking
   - Time: O(n * log(n)), Space: O(n)
   - Track maximum value seen for ended events

6. [Special Array II](https://leetcode.com/problems/special-array-ii/)
   - Efficient parity check using bitwise operations
   - Time: O(n + q), Space: O(n)
   - Prefix sum approach for range queries

### String Problems
1. [Adding Spaces to a String](https://leetcode.com/problems/adding-spaces-to-a-string/)
   - Two-pointer approach
   - Time: O(n), Space: O(1)
   - Handle spaces efficiently

2. [Find Longest Special Substring That Occurs Thrice I](https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/)
   - Efficient top-3 frequency array approach
   - Time: O(n), Space: O(1)
   - Single pass with constant space
   - Track only top 3 lengths per character

3. [Make String a Subsequence Using Cyclic Increments](https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/)
   - Two-pointer technique
   - Time: O(n), Space: O(1)

4. [Moving Pieces to Obtain a String](https://leetcode.com/problems/move-pieces-to-obtain-a-string/)
   - Two-pointer approach
   - Time: O(n), Space: O(1)

5. [Prefix of Word in Sentence](https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/)
   - String splitting and comparison
   - Time: O(n), Space: O(n)

### Tree Problems
1. [Same Tree](https://leetcode.com/problems/same-tree/)
   - Recursive DFS approach
   - Time: O(n), Space: O(h)
   - Where h is the height of the tree

2. [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)
   - Iterative stack approach
   - Time: O(n), Space: O(h)
   - Where h is the height of the tree

### Graph Problems
1. [Find the Town Judge](https://leetcode.com/problems/find-the-town-judge/)
   - In-degree/Out-degree approach
   - Time: O(E + N), Space: O(N)

2. [Minimum Obstacle Removal](https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/)
   - Dijkstra's algorithm implementation
   - Time: O((m*n) * log(m*n)), Space: O(m*n)

3. [Find Center of Star Graph](https://leetcode.com/problems/find-center-of-star-graph/)
   - Optimal solution using first two edges comparison
   - Time: O(1), Space: O(1)

## Setup and Running 🚀

### Prerequisites
- JDK 11 or higher
- Kotlin 1.9.0 or higher
- Gradle build tool

### Building the Project
```bash
# Clone the repository
git clone [your-repo-url]
cd leetcode

# Build the project
./gradlew build

# Run tests
./gradlew test
```

## Code Style 🎨

This project follows Kotlin coding conventions and includes:

- Clear and concise variable names
- Comprehensive documentation for each solution
- Unit tests for various test cases
- Complexity comments format:
  ```kotlin
  // Time: O(X), Space: O(Y) where...
  fun solution() {
      // Implementation
  }
  ```

## Contributing 🤝

Feel free to contribute by:
1. Forking the repository
2. Creating a feature branch
3. Committing your changes
4. Opening a pull request

## License 📄

This project is licensed under the MIT License - see the LICENSE file for details.
