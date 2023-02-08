package MySite.LeetCode.LinkedList;

import site.systemDesign.lruCache.ListNode;
// https://leetcode.com/problems/reverse-linked-list/
public class reverseLinkedList {


    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode temp = null;
        while(cur != null){
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
