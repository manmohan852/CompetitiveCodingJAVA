package MySite.LeetCode.LinkedList;

import site.systemDesign.lruCache.ListNode;

//  https://leetcode.com/problems/middle-of-the-linked-list/
public class MiddleoftheLinkedList {
    public static void main(String[] args) {

    }
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
