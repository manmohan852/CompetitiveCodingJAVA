package site.byteToByte;

public class SplitALinkedList {
    private class Node {
        int value;
        Node next;
    }

    public Node divide(Node list) {
        if (list == null) return null;
        Node runner = list.next;

        while (runner != null) {
            runner = runner.next;
            if (runner == null) break;
            runner = runner.next;
            list = list.next;
        }

        Node toReturn = list.next;
        list.next = null;
        return toReturn;
    }
}
