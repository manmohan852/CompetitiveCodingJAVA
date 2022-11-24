package site.byteToByte;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLevelOrder {
    private class Node {
        int value;
        Node left;
        Node right;
    }

    public void traverse(Node tree) {
        if (tree == null) return;
        Queue<Node> toVisit = new LinkedList<>();
        toVisit.add(tree);
        while (!toVisit.isEmpty()) {
            Node curr = toVisit.remove();
            System.out.println(curr.value);
            if (curr.left != null) toVisit.add(curr.left);
            if (curr.right != null) toVisit.add(curr.right);
        }
    }
}
