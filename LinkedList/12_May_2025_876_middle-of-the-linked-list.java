
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

    public ListNode middleNode(ListNode head) {
        int size = 0;
        ListNode temp = head, curr = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        int idx = 0;

        while (idx < size / 2) {
            curr = curr.next;
            idx++;
        }
        return curr;

    }

    public ListNode middleNode_usingSlowAndFast(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;
    }
}
