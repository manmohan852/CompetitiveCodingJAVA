package site.byteToByte;

public class PrintReversedLinkedList {
    private class Node {
        int value;
        Node next;
    }

    public void printReversedList(Node n) {
        if (n == null) return;
        printReversedList(n.next);
        System.out.println(n.value);
    }
}
