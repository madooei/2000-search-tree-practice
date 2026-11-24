package demo;

import practice.ValidateBst;
import tree.Node;

/** A demo of ValidateBst on a valid search tree and on the invalid tree from the notes. */
public final class ValidateBstDemo {

  private ValidateBstDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    // The seven-node search tree: 50 at the root, 30 and 70 below it, then 20, 40, 60, 80.
    Node<Integer> valid = new Node<>(50);
    valid.left = new Node<>(30);
    valid.right = new Node<>(70);
    valid.left.left = new Node<>(20);
    valid.left.right = new Node<>(40);
    valid.right.left = new Node<>(60);
    valid.right.right = new Node<>(80);

    // Every value is in the right place. Expect true.
    System.out.println("seven-node tree is a BST: " + ValidateBst.isValidBst(valid));

    // The tree from the notes: 50 at the root, 30 and 70 below it, and 60 as the right child of 30.
    Node<Integer> invalid = new Node<>(50);
    invalid.left = new Node<>(30);
    invalid.right = new Node<>(70);
    invalid.left.right = new Node<>(60);

    // 60 is in 50's left subtree but is larger than 50. Expect false.
    System.out.println("tree from the notes is a BST: " + ValidateBst.isValidBst(invalid));
  }
}
