package MySite.LeetCode.LinkedList;

import site.systemDesign.lruCache.ListNode;

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
