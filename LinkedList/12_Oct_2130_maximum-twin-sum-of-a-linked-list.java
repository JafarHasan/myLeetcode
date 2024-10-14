package LinkedList;

import java.util.*;

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
    // TC:O(N) SC:O(N) 5ms Best
    final int maxSize = 100001;

    public int pairSum(ListNode head) {
        final int[] arr = new int[maxSize];
        int idx = 0;
        while (head != null) {
            arr[idx++] = head.val;
            head = head.next;
        }
        int i = 0, j = idx - 1;
        int maxTwinSum = 0;
        while (i < j) {
            int n1 = arr[i];
            int n2 = arr[j];
            maxTwinSum = Math.max(maxTwinSum, n1 + n2);
            i++;
            j--;
        }
        return maxTwinSum;
    }
}

class Solution2 {
    // TC:O(N) SC:O(N)
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int i = 0, j = list.size() - 1;
        int maxTwinSum = Integer.MIN_VALUE;
        while (i < j) {
            int n1 = list.get(i);
            int n2 = list.get(j);
            maxTwinSum = Math.max(maxTwinSum, n1 + n2);
            i++;
            j--;
        }
        return maxTwinSum;
    }
}

class Solution3 {
    // reverse Half of LinkedList and use Two pointer
    public int pairSum(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow;
        temp.next = null;
        ListNode prev = null;
        ListNode next = second;
        while (second != null) {
            next = next.next;
            second.next = prev;
            prev = second;
            second = next;

        }
        int sum = 0, max = 0;
        while (head != null) {
            sum = head.val + prev.val;
            max = (max > sum) ? max : sum;
            head = head.next;
            prev = prev.next;
        }
        return max;
    }
}