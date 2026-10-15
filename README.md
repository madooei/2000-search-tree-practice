# Search Tree — Practice

Two practice problems on binary search trees: check whether a binary tree is a valid binary search tree, and find the k-th smallest value in a binary search tree. Each problem has a JUnit suite.

## Prerequisites

- JDK 17+ (JUnit 6 requires it).
- The JUnit jar is already vendored in `lib/`; there is nothing to download.

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  lib/
    junit-platform-console-standalone-6.1.0.jar
  src/
    main/
      practice/
        ValidateBst.java                # is a binary tree a valid BST?
        KthSmallest.java                # k-th smallest value in a BST
      tree/
        Node.java                       # the binary-tree node from the tree chapter
    test/
      practice/
        ValidateBstTest.java
        KthSmallestTest.java
  scripts/
    test.sh                             # compile and run the JUnit tests
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh practice.ValidateBstTest` — compiles everything and runs only that test class. Use this while you are working on one problem and the other is still empty.

There is no demo program for these problems; the tests are how you check your work.

## What's here

- `practice.ValidateBst` — `isValidBst`, which returns whether a binary tree satisfies the binary search tree ordering property. The empty tree is valid, and a tree with a duplicate value is not.
- `practice.KthSmallest` — `kthSmallest`, which returns the k-th smallest value in a binary search tree, counting from 1. It throws `IllegalArgumentException` if k is less than 1 or larger than the number of values.
- `tree.Node<T>` — the binary-tree node from the tree chapter, with a value and a left and a right child. It is a copy, included so this code compiles and runs on its own. The search tree chapter's node is private to `BinarySearchTree`, so the problems use this one.
- `practice.ValidateBstTest` and `practice.KthSmallestTest` — tests for the two problems.
