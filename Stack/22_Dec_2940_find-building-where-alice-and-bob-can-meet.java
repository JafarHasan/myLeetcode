class Solution {
    public int[] leftmostBuildingQueries(int[] A, int[][] queries) {
        int n = A.length, qn = queries.length;
        List<int[]>[] que = new ArrayList[n];
        for (int i = 0; i < n; i++)
            que[i] = new ArrayList();
        PriorityQueue<int[]> h = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] res = new int[qn];
        Arrays.fill(res, -1);
        // Step 1
        for (int qi = 0; qi < qn; qi++) {
            int i = queries[qi][0], j = queries[qi][1];
            if (i < j && A[i] < A[j]) {
                res[qi] = j;
            } else if (i > j && A[i] > A[j]) {
                res[qi] = i;
            } else if (i == j) {
                res[qi] = i;
            } else { // Step 2
                que[Math.max(i, j)].add(new int[] { Math.max(A[i], A[j]), qi });
            }
        }
        // Step 3
        for (int i = 0; i < n; i++) {
            while (!h.isEmpty() && h.peek()[0] < A[i]) {
                res[h.poll()[1]] = i;
            }
            for (int[] q : que[i]) {
                h.add(q);
            }
        }

        return res;
    }
}



class Solution1 {
    // TLE 949/952
    // next Greater element
    private int[] nextGreaterElement(int[] hgh) {
        Stack<Integer> st = new Stack<>();
        int n = hgh.length;
        int nge[] = new int[n];
        nge[n - 1] = -1;
        st.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            int ele = hgh[i];
            while (!st.isEmpty() && ele >= hgh[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }
            st.push(i);
        }
        return nge;

    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int[] next = nextGreaterElement(heights);

        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];

            if (a == b) {
                ans[i] = a;
                continue;
            }

            if (a > b && heights[a] > heights[b]) {
                ans[i] = a;
                continue;
            } else if (b > a && heights[b] > heights[a]) {
                ans[i] = b;
                continue;
            }

            int right_index = (a > b) ? a : b;

            for (int j = right_index; j < n; j++) {
                if (next[j] == -1)
                    break;
                if (heights[a] < heights[next[j]] && heights[b] < heights[next[j]]) {
                    ans[i] = next[j];
                    break;
                }
            }
        }

        return ans;
    }

}