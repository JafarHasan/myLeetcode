package AddTwoNumber;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        int val1 = 0, val2 = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            } else {
                val1 = 0;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            } else {
                val2 = 0;
            }
            int sum = val1 + val2 + c;
            if (sum > 9) {
                c = 1;
                sum = sum % 10;
            } else {
                c = 0;
            }
            dummy.next = new ListNode(sum);
            dummy = dummy.next;

        }
        if (c == 1)
            dummy.next = new ListNode(c);
        return head.next;
    }
}