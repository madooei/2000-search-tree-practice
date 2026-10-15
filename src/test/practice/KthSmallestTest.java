package practice;

import org.junit.jupiter.api.Test;
import tree.Node;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/** Tests for finding the k-th smallest value in a binary search tree. */
public class KthSmallestTest {

  @Test
  public void emptyTreeThrows() {
    try {
      KthSmallest.kthSmallest(null, 1);
      fail("expected IllegalArgumentException on an empty tree");
    } catch (IllegalArgumentException e) {
      return;
    }
  }

  @Test
  public void singleNodeIsFirstSmallest() {
    assertEquals(42, KthSmallest.kthSmallest(new Node<>(42), 1));
  }

  @Test
  public void firstSmallestIsTheMinimum() {
    assertEquals(20, KthSmallest.kthSmallest(buildExample(), 1));
  }

  @Test
  public void fourthSmallestIsTheRoot() {
    assertEquals(50, KthSmallest.kthSmallest(buildExample(), 4));
  }

  @Test
  public void seventhSmallestIsTheMaximum() {
    assertEquals(80, KthSmallest.kthSmallest(buildExample(), 7));
  }

  @Test
  public void kthSmallestInRightChain() {
    Node<Integer> root = new Node<>(10);
    root.right = new Node<>(20);
    root.right.right = new Node<>(30);
    assertEquals(20, KthSmallest.kthSmallest(root, 2));
  }

  @Test
  public void zeroKThrows() {
    Node<Integer> root = buildExample();
    try {
      KthSmallest.kthSmallest(root, 0);
      fail("expected IllegalArgumentException for k = 0");
    } catch (IllegalArgumentException e) {
      return;
    }
  }

  @Test
  public void negativeKThrows() {
    Node<Integer> root = buildExample();
    try {
      KthSmallest.kthSmallest(root, -3);
      fail("expected IllegalArgumentException for a negative k");
    } catch (IllegalArgumentException e) {
      return;
    }
  }

  @Test
  public void kLargerThanTreeThrows() {
    Node<Integer> root = buildExample();
    try {
      KthSmallest.kthSmallest(root, 8);
      fail("expected IllegalArgumentException for k larger than the tree");
    } catch (IllegalArgumentException e) {
      return;
    }
  }

  // Builds the chapter's example tree: 50 with children 30 and 70; 30 with
  // children 20 and 40; 70 with children 60 and 80.
  private static Node<Integer> buildExample() {
    Node<Integer> root = new Node<>(50);
    root.left = new Node<>(30);
    root.right = new Node<>(70);
    root.left.left = new Node<>(20);
    root.left.right = new Node<>(40);
    root.right.left = new Node<>(60);
    root.right.right = new Node<>(80);
    return root;
  }
}
