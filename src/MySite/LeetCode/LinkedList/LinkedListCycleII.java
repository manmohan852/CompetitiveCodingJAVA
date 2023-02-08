package MySite.LeetCode.LinkedList;
// leetcode.com/problems/linked-list-cycle-ii/
public class LinkedListCycleII {
    public static void main(String[] args) {

    }
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                int len = findLength(slow);
                return getHeadNode(len, head);
            }
        }
        return null;
    }
    private int findLength(ListNode node){
        ListNode temp = node.next;
        int len = 1;
        while(temp != node){
            temp = temp.next;
            len++;
        }
        return len;
    }
    private ListNode getHeadNode(int len, ListNode head){
        ListNode p1 = head, p2 = head;
        for(int i = 0; i < len; i++){
            p2 = p2.next;
        }
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
