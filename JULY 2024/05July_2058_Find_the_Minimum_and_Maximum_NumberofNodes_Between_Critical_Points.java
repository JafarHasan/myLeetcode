import java.util.LinkedList;

//Definition for singly-linked list.
public class ListNode {
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

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] array = new int[2];
        if (head == null || head.next == null || head.next.next == null) {
            return new int[] { -1, -1 };
        }
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode nextNode = head.next.next;
        int end = 2, start = -1, min = Integer.MAX_VALUE, minDistance = Integer.MAX_VALUE;
        while (nextNode != null) {
            if ((curr.val > prev.val && curr.val > nextNode.val) || (curr.val < prev.val && curr.val < nextNode.val)) {
                if (start != -1) {
                    int diff = end - start;
                    minDistance = Math.min(minDistance, diff);
                }
                start = end;
                min = Math.min(min, start);
            }
            end++;
            prev = curr;
            curr = nextNode;
            nextNode = nextNode.next;
        }
        array[0] = minDistance == Integer.MAX_VALUE ? -1 : minDistance;
        array[1] = (min == Integer.MAX_VALUE || min == start) ? array[0] : start - min;
        return array;
    }
}