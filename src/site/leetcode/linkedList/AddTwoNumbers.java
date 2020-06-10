package site.leetcode.linkedList;

import site.gfg.LinkedList.ReverseLinkedList;

import java.util.List;

//https://leetcode.com/problems/add-two-numbers/
//2. Add Two Numbers
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbersDigitsReversed(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = reverse(l1), q = reverse(l2), curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return reverse(dummyHead.next);
    }

    public static void main(String[] args) {
        //The digits are stored in reverse order
        //adding 349 + 465 = 814
        ListNode node1 = new ListNode(9);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);
        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);

        ListNode res = addTwoNumbersDigitsReversed(node1, node2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

        //adding 943 + 564 = 1507
        ListNode node3 = new ListNode(9);
        node3.next = new ListNode(4);
        node3.next.next = new ListNode(3);
        ListNode node4 = new ListNode(5);
        node4.next = new ListNode(6);
        node4.next.next = new ListNode(4);

        ListNode res2 = addTwoNumbers2(node3, node4);
        while (res2 != null) {
            System.out.println(res2.val);
            res2 = res2.next;
        }

    }
}
