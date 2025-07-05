
import java.util.*;

class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums2.length;
        map.put(nums2[n - 1], -1);

        Stack<Integer> st = new Stack<>();
        st.push(nums2[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            int curr = nums2[i];
            while (!st.isEmpty() && curr >= st.peek()) {
                st.pop();
            }
            if (st.isEmpty()) {
                map.put(curr, -1);
            } else {
                map.put(curr, st.peek());
            }
            st.push(curr);
        }
        int ans[] = new int[nums1.length];
        int i = 0;
        for (int ele : nums1) {
            ans[i++] = map.get(ele);
        }
        return ans;

    }
}
