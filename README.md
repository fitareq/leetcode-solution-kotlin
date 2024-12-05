# LeetCode Solutions in Kotlin 🎯

This repository contains my solutions to various LeetCode problems, primarily implemented in Kotlin with some C++ solutions. Each solution includes detailed explanations, multiple approaches, and comprehensive test cases.

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
│   │   └── FindTownJudge.kt
│   └── test/kotlin/problems/
│       └── [Corresponding test files]
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## Problems Solved 📚

### Tree Problems
1. [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)
   - Implemented both recursive and iterative solutions
   - Time: O(n), Space: O(h)

2. [Same Tree](https://leetcode.com/problems/same-tree/)
   - Solutions using DFS and BFS approaches
   - Time: O(n), Space: O(h)

### String Manipulation
1. [Adding Spaces to a String](https://leetcode.com/problems/adding-spaces-to-a-string/)
   - StringBuilder and String manipulation approaches
   - Time: O(n), Space: O(n)

2. [Check Word Prefix](https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/)
   - Multiple solutions with different space-time tradeoffs
   - Time: O(n), Space: O(1)

### Array Problems
1. [Check If N and Its Double Exist](https://leetcode.com/problems/check-if-n-and-its-double-exist/)
   - HashSet based solution
   - Time: O(n), Space: O(n)

### Graph Problems
1. [Find the Town Judge](https://leetcode.com/problems/find-the-town-judge/)
   - In-degree/Out-degree approach
   - Time: O(E + N), Space: O(N)

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

## Code Style 💅

This project follows Kotlin official coding conventions:
- Use camelCase for functions and variables
- Use PascalCase for classes
- Include documentation for public functions
- Add complexity analysis for each solution

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
