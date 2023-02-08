package MySite.LeetCode.LinkedList;
//  https://leetcode.com/problems/remove-linked-list-elements/
public class RemoveLinkedListElements {
    public static void main(String[] args) {

    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy, cur = dummy.next;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
                cur = pre.next;
            }
            else{
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
