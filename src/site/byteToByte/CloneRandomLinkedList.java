package site.byteToByte;

import java.util.HashMap;

public class CloneRandomLinkedList {
    // Private node class
    private static class Node {
        int value;
        Node next;
        Node random;
    }

    // Copy list using extra space. Store mapping of old nodes to new nodes
    public static Node cloneExtraSpace(Node n) {
        if (n == null) return n;

        // Map nodes in old list to equivalent nodes in new list
        HashMap<Node, Node> mapping = new HashMap<Node, Node>();

        // Create new linked list, minus the random node pointers. Save mapping
        // of equivalent old node to new node
        Node copy = new Node();
        Node nCurr = n, copyCurr = copy;
        mapping.put(nCurr, copyCurr);

        while (nCurr.next != null) {
            copyCurr.next = new Node();
            nCurr = nCurr.next;
            copyCurr = copyCurr.next;
            mapping.put(nCurr, copyCurr);
        }

        // Copy the random pointers. Find the random pointer in the original
        // list and look up the equivalent using the map
        nCurr = n;
        copyCurr = copy;
        while (nCurr != null) {
            copyCurr.random = mapping.get(nCurr.random);
            nCurr = nCurr.next;
            copyCurr = copyCurr.next;
        }

        return copy;
    }

    // Copy list without using extra space. Interleave the nodes from the new
// with the nodes from the original list. Then separate the new list from
// the old
    public static Node cloneNoExtraSpace(Node n) {
        if (n == null) return n;

        // Create new nodes in between the original nodes
        Node nCurr = n;
        while (nCurr != null) {
            Node temp = new Node();
            temp.value = nCurr.value;
            temp.next = nCurr.next;
            nCurr.next = temp;
            nCurr = nCurr.next.next;
        }

        // Copy random pointers
        nCurr = n;
        while (nCurr != null) {
            nCurr.next.random = nCurr.random.next;
            nCurr = nCurr.next.next;
        }

        // Separate new nodes from old nodes
        Node copy = n.next;
        nCurr = n;
        while (nCurr.next != null) {
            Node tmp = nCurr.next;
            nCurr.next = nCurr.next.next;
            nCurr = tmp;
        }

        return copy;
    }
}
