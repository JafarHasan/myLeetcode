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
    // TC:O(N) SC:O(N)
    public ListNode modifiedList2(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for (int ele : nums) {
            set.add(ele);
        }
        ListNode head2 = new ListNode(0);
        ListNode dummy = head2;
        while (head != null) {
            if (!set.contains(head.val)) {
                dummy.next = new ListNode(head.val);
                dummy = dummy.next;
            }

            head = head.next;

        }
        return head2.next;

    }

    // Solution 2 Modified original list TC:O(N) SC:O(N)
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for (int ele : nums) {
            set.add(ele);
        }

        while (head != null && set.contains(head.val)) {
            ListNode temp = head;
            head = head.next;
            temp = null;// deleting hanging nodes

        }
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (set.contains(curr.next.val)) { // need to delete
                ListNode temp = curr.next;
                curr.next = curr.next.next;
                temp = null;

            } else {
                curr = curr.next;
            }
        }
        return head;

    }
}