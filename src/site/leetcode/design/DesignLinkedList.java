package site.leetcode.design;
//https://leetcode.com/problems/design-linked-list/
//707. Design Linked List
public class DesignLinkedList {
    LinkNode head = null;

    /**
     * Initialize your data structure here.
     */
    public DesignLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        LinkNode currentNode = head;
        while (index > 0 && currentNode != null) {
            currentNode = currentNode.next;
            index--;
        }
        if (currentNode == null) return -1;
        return currentNode.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if (head == null) {
            head = new LinkNode(val, null);
        } else {
            LinkNode node = new LinkNode(val, head);
            head = node;
        }
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (head == null) {
            head = new LinkNode(val, null);
        } else {
            LinkNode currentNode = head;
            while (currentNode.next != null)
                currentNode = currentNode.next;
            currentNode.next = new LinkNode(val, null);
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == 0) addAtHead(val);
        LinkNode currentNode = head;
        while (index > 1 && currentNode != null) {
            currentNode = currentNode.next;
            index--;
        }
        if (currentNode != null)
            currentNode.next = new LinkNode(val, currentNode.next);
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index == 0 && head != null) head = head.next;
        LinkNode currentNode = head;
        while (index > 1 && currentNode != null) {
            currentNode = currentNode.next;
            index--;
        }
        if (currentNode != null && currentNode.next != null)
            currentNode.next = currentNode.next.next;
    }
}

class LinkNode {
    int val;
    LinkNode next;

    public LinkNode(int val, LinkNode next) {
        this.val = val;
        this.next = next;
    }
}
