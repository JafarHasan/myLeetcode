package LinkedList;

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
// 114ms 100% beast using resursion
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode result;
        if (list1.val < list2.val) {
            result = list1;
            result.next = mergeTwoLists(list1.next, list2);

        } else {
            result = list2;
            result.next = mergeTwoLists(list1, list2.next);

        }

        return result;
    }
}

class Solution1 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1 = list1;
        ListNode l2 = list2;
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = new ListNode(0);
        ListNode dummy = head;

        while (l1 != null && l2 != null) {
            if (l1.val == l2.val) {
                dummy.next = new ListNode(l1.val);
                dummy = dummy.next;
                dummy.next = new ListNode(l2.val);
                dummy = dummy.next;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1.val < l2.val) {
                dummy.next = new ListNode(l1.val);
                dummy = dummy.next;
                l1 = l1.next;
            } else {
                dummy.next = new ListNode(l2.val);
                dummy = dummy.next;
                l2 = l2.next;
            }

        }
        while (l1 != null) {
            dummy.next = new ListNode(l1.val);
            dummy = dummy.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            dummy.next = new ListNode(l2.val);
            dummy = dummy.next;
            l2 = l2.next;
        }
        return head.next;
    }
}

class Solution2 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1 = list1;
        ListNode l2 = list2;
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = new ListNode(0);
        ListNode dummy = head;

        while (l1 != null && l2 != null) {
            if (l1.val == l2.val) {
                dummy.next = new ListNode(l1.val);
                dummy = dummy.next;
                dummy.next = new ListNode(l2.val);
                dummy = dummy.next;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1.val < l2.val) {
                dummy.next = new ListNode(l1.val);
                dummy = dummy.next;
                l1 = l1.next;
            } else {
                dummy.next = new ListNode(l2.val);
                dummy = dummy.next;
                l2 = l2.next;
            }

        }
        if (l1 != null) {
            dummy.next = l1;
        }
        if (l2 != null) {
            dummy.next = l2;
        }
        return head.next;
    }
}