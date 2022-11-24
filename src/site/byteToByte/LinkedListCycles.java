package site.byteToByte;

import java.util.HashSet;

public class LinkedListCycles {

    private class Node{
        int val;
        Node next;
    }

    // Algorithm using extra space. Mark visited nodes and check that you
    // only visit each node once.
    public boolean hasCycle(Node n) {
        HashSet<Node> visited = new HashSet<Node>();
        for (Node curr = n; curr != null; curr = curr.next) {
            if (visited.contains(curr)) return true;
            visited.add(curr);
        }

        return false;
    }

    // Floyd's algorithm. Increment one pointer by one and the other by two.
    // If they are ever pointing to the same node, there is a cycle.
    // Explanation: https://www.quora.com/How-does-Floyds-cycle-finding-algorithm-work
    public boolean hasCycleFloyd(Node n) {
        if (n == null) return false;
        Node slow = n;
        Node fast = n.next;

        while (fast != null && fast.next != null) {
            if (fast == slow) return true;
            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }
}
