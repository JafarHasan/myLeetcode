import java.util.*;

class Solution {
    // TC;O(n^2) SC:O(n)
    public int findTheWinner1(int n, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(i + 1);
        }
        int i = 0;
        // O(N)
        while (al.size() > 1) {
            int idx = (i + k - 1) % al.size();
            al.remove(idx);// O(N)
            i = idx;

        }
        return al.get(0);
    }

    // using Queue TC:O(N x K) SC:O(N)
    public int findTheWinner2(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        while (q.size() > 1) { // O(N)
            int temp = k;
            while (temp-- > 1) { // O(K)
                q.offer(q.poll());
            }
            q.poll();
        }
        return q.poll();
    }

    // TC:o(N) SC:O(1)
    public int findTheWinner(int n, int k) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = (ans + k) % i;
        }
        return ans + 1;
    }
}