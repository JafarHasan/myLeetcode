import java.util.*;

class Solution {
    /// BF TC:O(N) SC:O(N) 3ms best
    public int maxWidthRamp(int[] nums) {
        int maxWidth = 0;
        int n = nums.length;
        int rightMax[] = new int[n];
        // find the RightMax element from right to left
        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }
        int i = 0, j = 0;
        while (j < n) {
            while (i < j && nums[i] > rightMax[j]) {
                i++;
            }
            maxWidth = Math.max(maxWidth, j - i);
            j++;
        }

        return maxWidth;
    }
}

class Solution1 {
    // TC:O(N) SC:O(N) 27ms
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        // Stack Formation fill stack in decrsing order of ele(strore idx)
        for (int i = 0; i < n; i++) {
            if (st.isEmpty() || nums[i] < nums[st.peek()]) {
                st.push(i);
            }
        }
        int maxWidth = 0;
        // Traverse the array backwards
        for (int j = n - 1; j >= 0; j--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[j]) {
                maxWidth = Math.max(maxWidth, j - st.pop());
            }
        }
        return maxWidth;
    }
}

class Solution2 {
    /// BF TC:O(N^2) SC:O(1) TLE 95/101 passed
    public int maxWidthRamp(int[] nums) {
        int maxWidth = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] <= nums[j]) {
                    maxWidth = Math.max(maxWidth, (j - i));

                }
            }
        }
        return maxWidth;
    }
}