
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

    public int getDecimalValue(ListNode head) {
        int ans = 0;
        for (; head != null; head = head.next) {
            ans = ans * 2 + head.val;

        }
        return ans;
    }

}

class Solution_BF {

    public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        int pow = 0;
        int ans = 0;
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '1') {
                ans += Math.pow(2, pow);
            }
            pow++;
        }
        return ans;
    }
}
