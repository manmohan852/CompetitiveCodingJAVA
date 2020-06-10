package site.gfg.binarytree;

import java.util.Stack;

public class IterativeInorderTraversal {
    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    void inorder() {
        if (root == null)
            return;
        Stack<Node> s = new Stack<Node>();
        Node curr = root;
        while (curr != null || s.size() > 0) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            /* Current must be NULL at this point */
            curr = s.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }
}
