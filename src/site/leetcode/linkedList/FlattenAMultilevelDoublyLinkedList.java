package site.leetcode.linkedList;
//https://leetcode.com/articles/flatten-a-multilevel-doubly-linked-list/
public class FlattenAMultilevelDoublyLinkedList {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
        public Node (int val,Node prev, Node next){
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

        public Node (int val){
            this.val = val;
        }
    }

    //TimeComplexity : O(n)
    public static Node flatten(Node head) {
        if(head == null) return null;
        Node head2 = head;
        dfs(head2);
        return head;
    }

    public static Node dfs(Node node){
        if(node == null)
            return null;
        Node prev = null;
        while(node != null){
            Node next = node.next;
            Node child = node.child;
            if(child != null){
                node.next = child;
                child.prev = node;
                node.child = null;
                node = dfs(child);
            }
            node.next = next;
            if(next != null) {
                next.prev = node;
            }
            prev = node;
            node = node.next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);

        node1.prev = null;
        node1.next = node2;

        node2.prev = node1;
        node2.next = node3;

        node3.prev = node2;
        node3.next = node4;
        node3.child = node7;

        node4.prev = node3;
        node4.next = node5;

        node5.prev = node4;
        node5.next = node6;

        node6.prev = node5;
        node6.next = null;

        node7.next = node8;

        node8.prev = node7;
        node8.next = node9;
        node8.child = node11;

        node9.prev = node8;
        node9.next = node10;

        node10.prev = node9;
        node10.next = null;

        node11.next = node12;

        node12.prev = node11;
        node12.next = null;

        flatten(node1);

    }
}
