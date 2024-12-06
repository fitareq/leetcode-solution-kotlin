# LeetCode Solutions in Kotlin 🎯

This repository contains my solutions to various LeetCode problems, primarily implemented in Kotlin. Each solution includes detailed explanations, multiple approaches, and comprehensive test cases.

## Project Structure 📁

```
leetcode/
├── src/
│   ├── main/kotlin/problems/
│   │   ├── TreeNode.kt
│   │   ├── BinaryTreeInorderTraversal.kt
│   │   ├── CheckIfDoubleExists.kt
│   │   ├── SameTree.kt
│   │   ├── AddSpacesToString.kt
│   │   ├── CheckWordPrefix.kt
│   │   ├── MovePiecesToString.kt
│   │   ├── FindTownJudge.kt
│   │   └── MaximumNumberofIntegersToChoose.kt
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

### String Problems
1. [Adding Spaces to a String](https://leetcode.com/problems/adding-spaces-to-a-string/)
   - StringBuilder approach
   - Time: O(n), Space: O(n)

2. [String With Cyclic Increments](https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/)
   - Two-pointer technique
   - Time: O(n), Space: O(1)

3. [Moving Pieces to Obtain a String](https://leetcode.com/problems/move-pieces-to-obtain-a-string/)
   - Two-pointer approach
   - Time: O(n), Space: O(1)

4. [Prefix of Word in Sentence](https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/)
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

# Navigate to project directory
cd leetcode

# Build the project
./gradlew build
```

### Running Tests
```bash
# Run all tests
./gradlew test

# Run specific test class
./gradlew test --tests "problems.FindTownJudgeTest"
```

## Testing Strategy 🧪

Each solution includes comprehensive test cases covering:
- Basic examples from LeetCode
- Edge cases
- Corner cases
- Performance tests for larger inputs

Example test structure:
```kotlin
@Test
fun `test basic example`() {
    val solution = SolutionClass()
    assertEquals(expected, solution.method(input))
}
```

## Contributing 🤝

Feel free to contribute by:
1. Adding new solutions
2. Improving existing solutions
3. Adding more test cases
4. Improving documentation

Please ensure:
- Code follows Kotlin coding conventions
- All tests pass
- Documentation is clear and complete
- Each solution includes time/space complexity analysis

## Dependencies 📦

```kotlin
dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
}
```

## Code Style 🎨

- All solutions include:
  * Problem description and link
  * Example with explanation
  * Time and space complexity analysis
  * Comprehensive test cases
  * Alternative solutions when applicable
  * Detailed comments explaining the approach

- Complexity comments format:
  ```kotlin
  // Time: O(X), Space: O(Y) where...
  fun solution() {
      // Implementation
  }
  ```

## License 📄

This project is licensed under the MIT License - see the LICENSE file for details.

## Contact 📧

Feel free to reach out if you have any questions or suggestions!

## Acknowledgments 🙏

- LeetCode for providing the problems
- Kotlin team for the amazing language
- JUnit team for the testing framework

---
Happy Coding! 😊
