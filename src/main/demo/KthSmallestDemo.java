package demo;

import practice.KthSmallest;
import tree.Node;

/** A demo of KthSmallest on the seven-node search tree from the notes. */
public final class KthSmallestDemo {

  private KthSmallestDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    // The tree from the notes: 50 at the root, 30 and 70 below it, then 20, 40, 60, 80.
    Node<Integer> root = new Node<>(50);
    root.left = new Node<>(30);
    root.right = new Node<>(70);
    root.left.left = new Node<>(20);
    root.left.right = new Node<>(40);
    root.right.left = new Node<>(60);
    root.right.right = new Node<>(80);

    // The sorted order is 20 30 40 50 60 70 80. Expect 20, 50, and 80.
    System.out.println("k = 1: " + KthSmallest.kthSmallest(root, 1));
    System.out.println("k = 4: " + KthSmallest.kthSmallest(root, 4));
    System.out.println("k = 7: " + KthSmallest.kthSmallest(root, 7));
  }
}
