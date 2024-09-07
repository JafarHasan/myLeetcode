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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    // TC:O(N*M) N=no of nodes in BT M=no of nodes in LL
    private boolean isHeadEqualsToRoot(ListNode head, TreeNode root) {
        // if linked list completed OR means if there is an empty LL
        if (head == null) {
            return true;
        }
        // if BT has ended but no LL found OR there is an empty BT
        if (root == null) {
            return false;
        }

        if (head.val != root.val) {
            return false;
        }

        return isHeadEqualsToRoot(head.next, root.left) || isHeadEqualsToRoot(head.next, root.right);
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null)
            return false;
        return isHeadEqualsToRoot(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
}