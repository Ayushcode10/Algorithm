# 🧠 Algorithm Notes & Solved Problems

This repository is a structured collection of **in-depth algorithm notes and Java implementations**, curated for interview prep, DSA mastery, and concept revision. Each folder contains problems related to that algorithm or topic.

---

## 📌 Table of Contents

- [Greedy Algorithms](#greedy-algorithms)
- [Dynamic Programming (DP)](#dynamic-programming-dp)
- [Sorting Algorithms](#sorting-algorithms)
- [Searching Algorithms](#searching-algorithms)
- [Graph Algorithms](#graph-algorithms)
- [Backtracking](#backtracking)

---

## ⚡ Greedy Algorithms

### 🔍 Concept:

Greedy algorithms work by making the **locally optimal choice at each step** in the hope that this will lead to a globally optimal solution. It does **not reconsider** choices once made.

### ✅ When to use:
- Problem has **greedy choice property** (a global optimum can be reached by choosing local optimums).
- Problem exhibits **optimal substructure** (optimal solution can be constructed from optimal solutions of subproblems).

### 📘 Real-life Examples:
- Coin Change (Greedy version)
- Activity Selection
- Huffman Encoding
- Interval Scheduling

### ⚠️ Warning:
Greedy doesn’t work for all problems. Always validate whether greedy will yield the optimal result.

### 📂 Problems:
- [Activity Selection](./src/greedy/ActivitySelection.java)
- [Fractional Knapsack](./src/greedy/FractionalKnapsack.java)
- [Job Sequencing](./src/greedy/JobSequencing.java)

---

## 🧠 Dynamic Programming (DP)

### 🔍 Concept:

Dynamic Programming solves problems by **breaking them down into overlapping subproblems**, solving each only once, and storing their results (memoization).

There are two approaches:
- **Top-Down (Memoization):** Recursive + cache
- **Bottom-Up (Tabulation):** Iterative + table

### ✅ When to use:
- Problem has **overlapping subproblems**
- Problem has **optimal substructure**

### ⚙️ Common DP Problems:
- Fibonacci Series
- 0/1 Knapsack
- Longest Common Subsequence (LCS)
- Matrix Chain Multiplication
- Coin Change

### 📂 Problems:
- [Fibonacci Memoized](./src/dynamicprogramming/FibonacciMemo.java)
- [0/1 Knapsack](./src/dynamicprogramming/Knapsack.java)
- [LCS](./src/dynamicprogramming/LCS.java)

---

## 🔄 Sorting Algorithms

### 🔍 Concept:

Sorting algorithms arrange data in **ascending or descending order**. Sorting is often a prerequisite for other algorithms (e.g., greedy, binary search).

### ⚙️ Types:
- **Comparison-based:** Bubble, Selection, Insertion, Merge, Quick
- **Non-comparison-based:** Counting, Radix, Bucket

### 🧠 Tips:
- Use Merge Sort when stability is needed
- Use Quick Sort for average-case fast performance
- Use Counting/Radix when working with small integer ranges

### 📂 Problems:
- [Merge Sort](./src/sorting/MergeSort.java)
- [Quick Sort](./src/sorting/QuickSort.java)
- [Interval Sort](./src/sorting/IntervalSort.java)

---

## 🔍 Searching Algorithms

### 🔍 Concept:

Used to **locate elements** in arrays or data structures.

### ⚙️ Types:
- **Linear Search** – O(n)
- **Binary Search** – O(log n) on sorted arrays
- **Binary Search Variants** – Lower Bound, Upper Bound, etc.

### 🧠 Binary Search Pattern:
Use this pattern when:
- Array is sorted
- You can frame your problem as a "yes/no" decision
- Need to minimize/maximize something

### 📂 Problems:
- [Binary Search](./src/searching/BinarySearch.java)
- [Search in Rotated Sorted Array](./src/searching/SearchRotated.java)

---

## 🌐 Graph Algorithms

### 🔍 Concept:

Graphs are data structures made of nodes (vertices) and edges. They represent networks like roads, social media, or dependencies.

### 🧠 Representations:
- Adjacency Matrix
- Adjacency List

### ⚙️ Key Algorithms:
- DFS (Depth-First Search)
- BFS (Breadth-First Search)
- Dijkstra’s Algorithm (Shortest Path)
- Prim’s & Kruskal’s (Minimum Spanning Tree)
- Topological Sort
- Union-Find / Disjoint Set

### 📂 Problems:
- [DFS](./src/graph/DFS.java)
- [BFS](./src/graph/BFS.java)
- [Dijkstra's Algorithm](./src/graph/Dijkstra.java)

---

## 🧩 Backtracking

### 🔍 Concept:

Backtracking is a technique to solve problems incrementally by building candidates and abandoning a path (backtrack) when it fails to satisfy the constraints.

### ✅ Use it when:
- You need to explore all solutions
- The problem involves permutations, combinations, or decision trees

### ⚠️ It’s a brute-force approach but can be made efficient using **pruning**.

### 📘 Real Examples:
- N-Queens
- Sudoku
- Subset Sum
- Word Search

### 📂 Problems:
- [N-Queens](./src/backtracking/NQueens.java)
- [Subset Sum](./src/backtracking/SubsetSum.java)

---

## 🚀 How to Use This Repo

```bash
git clone https://github.com/Ayushcode10/Algorithm
cd Algorithm
# Open with IntelliJ or VS Code
