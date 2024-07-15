
//Definition for singly-linked list.*

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
    // O(N) SC:O(1)
    public ListNode mergeNodes(ListNode head) {
        ListNode newHead = new ListNode();
        ListNode temp = newHead;
        while (head != null) {
            int sum = 0;
            while (head != null && head.val != 0) {
                sum += head.val;
                head = head.next;
            }
            ListNode node = new ListNode(sum);
            if (newHead == null) {
                newHead = node;
                temp = node;
            } else {
                temp.next = node;
                temp = temp.next;
            }
            head = head.next;
        }
        return newHead.next.next;// was printing 2 leading zeroes

    }





    // 2nd method SC:O(1) TC:(N)
    public ListNode mergeNodes1(ListNode head) {
        // Initialize a sentinel/dummy node with the first non-zero value.
        ListNode modify = head.next;
        ListNode nextSum = modify;

        while (nextSum != null) {
            int sum = 0;
            // Find the sum of all nodes until you encounter a 0.
            while (nextSum.val != 0) {
                sum += nextSum.val;
                nextSum = nextSum.next;
            }

            // Assign the sum to the current node's value.
            modify.val = sum;
            // Move nextSum to the first non-zero value of the next block.
            nextSum = nextSum.next;
            // Move modify also to this node.
            modify.next = nextSum;
            modify = modify.next;
        }
        return head.next;
    }
}