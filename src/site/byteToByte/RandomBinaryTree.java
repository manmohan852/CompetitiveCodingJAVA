package site.byteToByte;

import java.util.Random;

public class RandomBinaryTree {
    // Individual node of the tree
    private class Node {
        Node left;
        Node right;
        int val;
        int children;
    }

    // The root of the tree
    private Node root;
    private Random rand;

    // Return each node with probability 1/N
    public int getRandomNode() {
        if (root == null) throw new NullPointerException();

        // This is an index of a node in the tree. Indices go in sorted order.
        int count = rand.nextInt(root.children + 1);
        return getRandomNode(root, count);
    }

    // Recursive method. Binary search through tree to find the index. We use
// the number of children to determine which direction to go
    private int getRandomNode(Node curr, int count) {
        if (count == countOfNodeInSubTree(curr.left)) return curr.val;
        if (count < countOfNodeInSubTree(curr.left)) return getRandomNode(curr.left, count);

        // The new index becomes the index of the same node but now within the
        // subtree rather than the whole tree
        return getRandomNode(curr.right, count - countOfNodeInSubTree(curr.left) - 1);
    }

    // Return the number of nodes in a given subtree
    private int countOfNodeInSubTree(Node n) {
        if (n == null) return 0;
        return n.children + 1;
    }
}
