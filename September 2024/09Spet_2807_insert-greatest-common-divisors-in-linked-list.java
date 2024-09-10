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
    ///O(N) SC:O(1)

    //O(log(min(a,b)));
    private int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    //O(N) N=length No of nodes in LL
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // Storing the head
        ListNode dummy = head;
        ListNode curr = head;
        while (curr != null && curr.next != null) {

            ListNode next = curr.next;
            // find GCD of currNode and nextNode
            int gcd = getGCD(curr.val, next.val);
            // making new Node of GCD value
            ListNode gcdNode = new ListNode(gcd);
            // making bonds
            curr.next = gcdNode;
            gcdNode.next = next;
            // skipping GCD node and move to next Node
            curr = next;

        }
        // return stored head
        return dummy;
    }
}