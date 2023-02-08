package MySite.LeetCode.LinkedList;
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) {

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy, cur = dummy.next, fast = dummy.next;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        return dummy.next;
    }
}
