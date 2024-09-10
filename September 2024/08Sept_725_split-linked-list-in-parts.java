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

/*
 * head =[1,2,3,4,5,6,7,8,9,10] here len=10=n
 * k =3
 * Output=[[1,2,3,4],[5,6,7],[8,9,10]]
 */
class Solution {
    private int length(ListNode h) {
        int cnt = 0;
        while (h != null) {
            cnt++;
            h = h.next;
        }
        return cnt;
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        if (k == 0) {
            return new ListNode[] { head };
        }
        if (head == null) {
            ListNode[] ans = new ListNode[k];
            Arrays.fill(ans, null);
            return ans;
        }
        int temp[] = new int[k];// to store split parts 10=[4,3,3]
        int len = length(head); // length of LL i.e=n
        int base = len / k;/// 10/3=3 parts total
        int rem = len % k;// 10%3=1 1 part is greater than other 4 is greater than 3 3

        // fillings parts no in temp
        for (int i = 0; i < k; i++) {
            temp[i] = base;

        }
        // increasing one to remaining parts(3++=4 =>[4 3 3]=10)
        for (int i = 0; i < rem; i++) {
            temp[i]++;
        }
        // ans arrays of size k=3
        ListNode ans[] = new ListNode[k];
        for (int i = 0; i < k; i++) {
            int parts = temp[i];

            ListNode prev = head;
            ans[i] = prev;// putting the head of parts in ans arrray
            while (parts-- > 0 && head != null) {
                prev = head;
                head = head.next;
            }
            // making parts ending node null to split LL
            prev.next = null;
            // if LL is empty then return ans
            if (head == null)
                return ans;
        }
        return ans;

    }
}

// TC:O(N) SC:O(N)