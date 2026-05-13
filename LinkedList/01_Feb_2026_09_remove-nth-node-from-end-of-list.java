
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    //TC:O(N) SC:O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;

        while (n-- > 0) {
            fast = fast.next;
        }

        // if fast is null, remove head
        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}

class Solution_2 {
    //TC:O(N) SC:O(N)

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            st.add(temp);
            temp = temp.next;
        }
        while (n-- > 0 && !st.isEmpty()) {
            st.pop();
        }
        if (st.empty()) {
            return head.next;
        }
        temp = st.peek();
        temp.next = temp.next.next;
        return head;
    }
}

class Solution_1 {

    //O(2N) SC:O(1) N=length of LL
    private int length(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        int len = length(head);
        if (n == len) {
            return head.next;
        }
        ListNode temp = head;
        int go = len - n;
        for (int i = 1; i < go; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}
