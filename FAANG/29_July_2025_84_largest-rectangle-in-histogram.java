
import java.util.*;

class Solution {

    //TC:O(N) SC:O(N)
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int lb[] = new int[n];
        int rb[] = new int[n];
        //for i=0 lb[i]=-1;means(i-1)
        //for i=n rb[n-1]=n means (i+1)
        for (int i = 0; i < n; i++) {
            lb[i] = i - 1;
            rb[i] = i + 1;
        }
        //till when we can expand left boundry
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && heights[j] >= heights[i]) {
                j = lb[j];
            }
            lb[i] = j;
        }
        //till when we can expand right boundry
        for (int i = n - 1; i >= 0; i--) {
            int j = i + 1;
            while (j < n && heights[j] >= heights[i]) {
                j = rb[j];
            }
            rb[i] = j;
        }
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = rb[i] - lb[i] - 1;
            int height = heights[i];

            ans = Math.max(ans, width * height);
        }
        return ans;

    }
}

class Solution_Bf {
    //TC:O(N+N+N)=>O(N) SC:O(N+N)=O(N)

    //Next Smaller to Left if not found keep -1
    private int[] nextSmallerToLeft(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] nsel = new int[n];
        nsel[0] = -1;
        st.push(0);

        for (int i = 1; i < n; i++) {
            while (!st.empty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nsel[i] = -1; 
            }else {
                nsel[i] = st.peek();
            }

            st.push(i);
        }
        return nsel;
    }

    //Next Smaller to right if not found keep n
    private int[] nextSmallerToRight(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] nser = new int[n];
        nser[n - 1] = n;
        st.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            while (!st.empty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nser[i] = n; 
            }else {
                nser[i] = st.peek();
            }

            st.push(i);
        }
        return nser;
    }

    public int largestRectangleArea(int[] heights) {
        int[] lb = nextSmallerToLeft(heights);
        int[] rb = nextSmallerToRight(heights);

        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = rb[i] - lb[i] - 1;
            int height = heights[i];

            ans = Math.max(ans, width * height);
        }
        return ans;
    }
}
