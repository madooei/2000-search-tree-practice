package practice;

import org.junit.jupiter.api.Test;
import tree.Node;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Tests for validating a binary search tree. */
public class ValidateBstTest {

  @Test
  public void emptyTreeIsValid() {
    assertTrue(ValidateBst.isValidBst(null));
  }

  @Test
  public void singleNodeIsValid() {
    assertTrue(ValidateBst.isValidBst(new Node<>(42)));
  }

  @Test
  public void leftChildLargerThanParentIsInvalid() {
    Node<Integer> root = new Node<>(50);
    root.left = new Node<>(60);
    assertFalse(ValidateBst.isValidBst(root));
  }

  @Test
  public void rightChildSmallerThanParentIsInvalid() {
    Node<Integer> root = new Node<>(50);
    root.right = new Node<>(40);
    assertFalse(ValidateBst.isValidBst(root));
  }

  @Test
  public void duplicateValueIsInvalid() {
    Node<Integer> root = new Node<>(50);
    root.left = new Node<>(50);
    assertFalse(ValidateBst.isValidBst(root));
  }

  @Test
  public void leftChainIsValid() {
    Node<Integer> root = new Node<>(30);
    root.left = new Node<>(20);
    root.left.left = new Node<>(10);
    assertTrue(ValidateBst.isValidBst(root));
  }

  @Test
  public void rightChainIsValid() {
    Node<Integer> root = new Node<>(10);
    root.right = new Node<>(20);
    root.right.right = new Node<>(30);
    assertTrue(ValidateBst.isValidBst(root));
  }

  @Test
  public void exampleTreeIsValid() {
    assertTrue(ValidateBst.isValidBst(buildExample()));
  }

  @Test
  public void valueOnCorrectSideOfEveryAncestorIsValid() {
    Node<Integer> root = new Node<>(50);
    root.left = new Node<>(25);
    root.right = new Node<>(75);
    root.right.left = new Node<>(55);
    assertTrue(ValidateBst.isValidBst(root));
  }

  @Test
  public void valueOnWrongSideOfGrandparentIsInvalid() {
    Node<Integer> root = new Node<>(50);
    root.left = new Node<>(30);
    root.right = new Node<>(70);
    root.left.right = new Node<>(60);
    assertFalse(ValidateBst.isValidBst(root));
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
