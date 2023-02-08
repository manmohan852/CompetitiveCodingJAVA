package MySite.LeetCode.LinkedList;


import site.systemDesign.lruCache.ListNode;

public class reverseBetween {
      public static void main(String[] args) {

      }
      public ListNode reverseBetween1(ListNode head, int m, int n) {
            if(m == n || head == null) return head;

            ListNode front = new ListNode();
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
