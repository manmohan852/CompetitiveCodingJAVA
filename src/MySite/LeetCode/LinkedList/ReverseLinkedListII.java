package MySite.LeetCode.LinkedList;

import site.systemDesign.lruCache.ListNode;
// https://leetcode.com/problems/reverse-linked-list-ii/description/
public class ReverseLinkedListII {
    public static void main(String[] args) {

    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode oneBefore = dummy, cur = head;
        for(int i = 1; i < m; i++){
            oneBefore = cur;
            cur = cur.next;
        }
        ListNode next = null, prev = null;
        for(int i = m; i <= n; i++){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        ListNode temp = oneBefore.next;
        oneBefore.next = prev;
        temp.next = cur;
        return dummy.next;
    }
}
