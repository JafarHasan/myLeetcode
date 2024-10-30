package LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode prev = node;
        while (node.next != null) {
            prev = node;
            // swap/update curr node val to next node value
            prev.val = node.next.val;
            node = node.next;
        }
        // make second last value next null
        prev.next = null;

    }
}
