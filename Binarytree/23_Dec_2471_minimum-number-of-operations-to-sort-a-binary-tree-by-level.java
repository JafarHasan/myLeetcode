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
import java.util.*;
class Solution {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int ans = 0;
        q.add(root);/// q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int[] arr = new int[size];
            int idx = 0;
            while (size-- > 0) {
                TreeNode curr = q.poll();
                arr[idx++] = curr.val;
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            ans += minNoOfSwapToSortTheArray(arr, arr.length);
        }
        return ans;

    }

    private int minNoOfSwapToSortTheArray(int[] arr, int n) {
        int[] temp = arr.clone();
        Arrays.sort(temp);
        HashMap<Integer, Integer> map = new HashMap<>();

        // Store original indices of array elements
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        int swaps = 0;
        for (int i = 0; i < n; i++) {
            // If the current element is already in the correct position, continue
            if (arr[i] == temp[i]) {
                continue;
            }

            // Perform a swap
            swaps++;
            int correctIdx = map.get(temp[i]);

            // Update the mapping after the swap
            map.put(arr[i], correctIdx);
            map.put(temp[i], i);

            // Swap elements in the array
            int tempVal = arr[i];
            arr[i] = arr[correctIdx];
            arr[correctIdx] = tempVal;
        }
        return swaps;
    }
}