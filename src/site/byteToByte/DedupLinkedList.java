package site.byteToByte;

import java.util.HashSet;

public class DedupLinkedList {
    public class Node {
        int val;
        Node next;
    }

    public void removeDups(Node n) {
        HashSet<Integer> nodes = new HashSet<Integer>();
        Node prev = null;
        while (n != null) {
            if (nodes.contains(n.val)) {
                prev.next = n.next;
            } else {
                nodes.add(n.val);
                prev = n;
            }
            n = n.next;
        }
        prev.next = null;
    }

    public void removeDups2(Node n) {
        while (n != null) {
            Node curr = n;
            while (curr.next != null) {
                if (curr.next.val == n.val) {
                    curr.next = curr.next.next;
                } else {
                    curr = curr.next;
                }
            }
            n = n.next;
        }
    }
}
