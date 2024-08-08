
//  Definition for singly-linked list.

import java.util.Arrays;

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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        for (int[] row : ans) {
            Arrays.fill(row, -1);
        }
        int left = 0, right = n - 1, top = 0, down = m - 1;
        while (head != null || (left <= right && top <= down)) {
            // filling first row 0->n-1
            for (int i = left; i <= right; i++) {
                if (head == null)
                    break;
                ans[top][i] = head.val;
                head = head.next;
            }
            // move to the next row
            top++;
            // filling last col
            for (int i = top; i <= down; i++) {
                if (head == null)
                    break;
                ans[i][right] = head.val;
                head = head.next;
            }
            // move to the 2nd last col
            right--;

            if (top <= down) {
                // filling last row reverse right->left
                for (int i = right; i >= left; i--) {
                    if (head == null)
                        break;
                    ans[down][i] = head.val;

                    head = head.next;
                }
                // move to up 2nd last row
                down--;
            }
            if (left <= right) {
                // filling first col reverse order down->top
                for (int i = down; i >= top; i--) {
                    if (head == null)
                        break;
                    ans[i][left] = head.val;
                    head = head.next;
                }
                // move to the 2nd col
                left++;
            }

        }
        return ans;
    }
}