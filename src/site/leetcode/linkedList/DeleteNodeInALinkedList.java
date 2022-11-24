package site.leetcode.linkedList;

//https://leetcode.com/problems/delete-node-in-a-linked-list/
public class DeleteNodeInALinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //Time and space complexity are both O(1).
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
