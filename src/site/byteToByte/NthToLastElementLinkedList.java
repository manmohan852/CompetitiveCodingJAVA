package site.byteToByte;

public class NthToLastElementLinkedList {
    // Private node class
    private class Node {
        private int value;
        private Node next;

        private Node(int value) {
            this.value = value;
        }
    }

    public Node nthToLast(Node node, int n) {
        Node curr = node;
        Node follower = node;

        // Iterate curr forward by n. If you reach the end of the list then it is
        // shorter than n, so you can't possible have an nth-to-last node
        for (int i = 0; i < n; i++) {
            if (curr == null) return null;
            curr = curr.next;
        }

        // If length is exactly n, the nth-to-last node would be null
        if (curr == null) return null;

        // Move both nodes forward in unison until curr is at the end of the list
        while (curr.next != null) {
            curr = curr.next;
            follower = follower.next;
        }

        return follower;
    }
}
