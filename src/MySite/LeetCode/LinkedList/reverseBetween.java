package MySite.LeetCode.LinkedList;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class reverseBetween {

      public ListNode reverseBetween1(ListNode head, int m, int n) {
            if(m == n || head == null) return head;

            ListNode front = new ListNode(-1);
            front.next = head;
            ListNode oneBefore = front;

            ListNode current = head;

            for(int i = 1; i < m; i++) {
                  oneBefore = current;
                  current = current.next;
            }

            ListNode previous = null;

            for(int i = m; i <= n; i++) {
                  ListNode next = current.next;
                  current.next = previous;
                  previous = current;
                  current = next;
            }

            ListNode temp = oneBefore.next;
            oneBefore.next = previous;
            temp.next = current;

            return front.next;
      }

}
