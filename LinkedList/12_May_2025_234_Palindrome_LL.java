
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
    // 1  ->  2   ->  3   ->  4   ->  3   ->  2   ->  1
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode temp = head;
        //find middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 1  ->  2   ->  3   -> | 4 |  ->  3   ->  2   ->  1
        //reverse LL from mid point
        ///now mid is my new Head;
        ListNode prev = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        // 1  ->  2   ->  3   -> | 4 |  null<-  3   <-  2   <-  1
        //HEAD                                               PREV
        //now prev is my head of other half LL
        while (prev != null) {
            if (prev.val != head.val) {
                return false;
            }
                = head.n
            ext;
            prev = prev.next;
        }
        return true;

    }

    public boolean isPalindrome_usingSB(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode temp = head;
        while (temp != null) {
            sb.append(temp.val + "");
            temp = temp.next;
        }
        return isPalindromeHelper(sb.toString());
    }

    private boolean isPalindromeHelper(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
         
                  return false;
        }
            i
            
            j--;
        }
        return true;
    }


        