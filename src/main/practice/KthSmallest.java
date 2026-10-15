package practice;

import tree.Node;

/** Solution to the problem of finding the k-th smallest value in a binary search tree. */
public final class KthSmallest {

  private KthSmallest() {
    // This class should not be instantiated!
  }

  // What the traversal has counted so far, and the answer once it is found.
  private static class State<T> {
    int seen;
    T value;
    boolean found;
  }

  // Returns the k-th smallest value in the binary search tree rooted at root,
  // counting k from 1. Throws IllegalArgumentException if k is less than 1 or
  // larger than the number of values in the tree.
  public static <T> T kthSmallest(Node<T> root, int k) {
    if (k <= 0) {
      throw new IllegalArgumentException("k must be positive");
    }

    State<T> state = new State<>();
    kthSmallest(root, k, state);

    if (!state.found) {
      throw new IllegalArgumentException("k is larger than the tree");
    }
    return state.value;
  }

  // Visits the subtree rooted at node in-order and stops at the k-th visit.
  private static <T> void kthSmallest(Node<T> node, int k, State<T> state) {
    if (node == null || state.found) {
      return;
    }

    kthSmallest(node.left, k, state);
    if (state.found) {
      return;
    }

    state.seen++;
    if (state.seen == k) {
      state.value = node.value;
      state.found = true;
      return;
    }

    kthSmallest(node.right, k, state);
  }
}
