package site.byteToByte;

import java.util.Stack;

public class SortStack {
    // Tree node class
    public static class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    // Traverse tree iteratively. We do this by replicating the same process
// done recursively using an explicit stack
    public static void traverse(Node n) {
        Stack s = new Stack();
        // Add the leftmost branch to the stack
        addLeftToStack(s, n);

        // While there are elements in the stack, pop and move the minimum
        // possible distance to the right
        while (!s.isEmpty()) {
            Node curr = (Node) s.pop();
            System.out.println(curr.value);

            // Add the right child and any of its left children to the stack
            addLeftToStack(s, curr.right);
        }
    }

    // As long as the current node has a left pointer, add it to the stack and
// continue
    private static void addLeftToStack(Stack s, Node n) {
        while (n != null) {
            s.push(n);
            n = n.left;
        }
    }
}
