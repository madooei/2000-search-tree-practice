package practice;

import tree.Node;

/** Solution to the problem of validating a binary search tree. */
public final class ValidateBst {

  private ValidateBst() {
    // This class should not be instantiated!
  }

  // Returns true if the tree rooted at root satisfies the binary search tree
  // ordering property. The empty tree is valid. A duplicate value is not.
  public static <T extends Comparable<T>> boolean isValidBst(Node<T> root) {
    return isValidBst(root, null, null);
  }

  // Returns true if every value in the subtree rooted at node is strictly
  // between min and max. A null bound means there is no bound on that side.
  private static <T extends Comparable<T>> boolean isValidBst(
      Node<T> node, T min, T max) {
    if (node == null) {
      return true;
    }

    if (min != null && node.value.compareTo(min) <= 0) {
      return false;
    }
    if (max != null && node.value.compareTo(max) >= 0) {
      return false;
    }

    return isValidBst(node.left, min, node.value)
        && isValidBst(node.right, node.value, max);
  }
}
