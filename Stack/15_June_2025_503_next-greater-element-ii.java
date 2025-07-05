import java.util.*;
class Solution {

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int ans[] = new int[n];
        ans[n - 1] = -1;
        st.push(nums[n - 1]);
        for (int i = n * 2 - 2; i >= 0; i--) {
            int curr = nums[(i) % n];
            while (!st.isEmpty() && curr >= st.peek()) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i % n] = -1;
            } else {
                ans[i % n] = st.peek();
            }
            st.push(curr);
        }

        return ans;
    }
}
