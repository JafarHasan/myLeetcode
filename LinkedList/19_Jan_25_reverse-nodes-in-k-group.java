
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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        // Step 1: Count k nodes to determine if we should proceed
        ListNode temp = head;
        int count = 0;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        // // If there are less than k nodes, return the head as is
        if (count < k) {
            return head;
        }

        // Step 2: Reverse first k nodes
        ListNode curr = head, prev = null, next = null;
        count = 0;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // Step 3: Recursively call for the remaining nodes
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        // Return the new head
        return prev;
    }

}
