package site.gfg.LinkedList;

import java.util.Stack;

//https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/

public class ReverseLinkedListInGroupOfSizeK {

    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    //Time Complexity: O(n)
    Node reverse(Node head, int k) {
        Node current = head;
        Node next = null;
        Node prev = null;
        int count = 0;
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if (next != null)
            head.next = reverse(next, k);
        return prev;
    }

    //Time Complexity: O(n)
    //Space  Complexity: O(k)
    static Node ReverseUsingStack(Node head, int k) {
        Stack<Node> mystack = new Stack<Node>();
        Node current = head;
        Node prev = null;

        while (current != null) {
            int count = 0;
            while (current != null && count < k) {
                mystack.push(current);
                current = current.next;
                count++;
            }
            while (mystack.size() > 0) {
                if (prev == null) {
                    prev = mystack.peek();
                    head = prev;
                    mystack.pop();
                } else {
                    prev.next = mystack.peek();
                    prev = prev.next;
                    mystack.pop();
                }
            }
        }
        prev.next = null;
        return head;
    }

    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        ReverseLinkedListInGroupOfSizeK llist = new ReverseLinkedListInGroupOfSizeK();

		/* Constructed Linked List is 1->2->3->4->5->6->
		7->8->8->9->null */
        llist.push(9);
        llist.push(8);
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Given Linked List");
        llist.printList();

        llist.head = llist.reverse(llist.head, 3);

        System.out.println("Reversed list");
        llist.printList();
    }
}
