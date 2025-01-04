
import java.util.Stack;

class Solution2 {

    private int[] nextGreaterElementRight(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int rb[] = new int[n];
        rb[n - 1] = -1;
        st.push(n - 1);// stored the last idx
        for (int i = n - 2; i >= 0; i--) {
            int ele = arr[i];
            while (!st.isEmpty() && ele >= arr[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0) {
                rb[i] = -1;
            } else {
                rb[i] = st.peek();
            }
            st.push(i);

        }
        for (int ele : rb) {
            System.out.print(ele + " ");
        }
        return rb;
    }

    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int rb[] = nextGreaterElementRight(temp, n);
        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (rb[i] == -1) {
                ans[i] = 0;
            } else {
                ans[i] = rb[i] - i;
            }
        }
        return ans;

    }
}

// TC:O(N) SC:O(1)
class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        while (i < temperatures.length) {
            while (stack.size() != 0 && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
            i++;
        }
        return ans;
    }
}
