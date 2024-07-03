import java.util.Arrays;
class Solution {
    // TC:O(NlogN) SC:O(N)
    public long maximumImportance(int n, int[][] roads) {
        long indegree[] = new long[n]; // to store the indegree of each nodes
        for (int[] edge : roads) {
            int src = edge[0];
            int dest = edge[1];
            indegree[src]++;
            indegree[dest]++;
        }
        Arrays.sort(indegree);
        long ans = 0l;
        long number = 1;
        for (long val : indegree) {
            ans += val * number;
            number++;
        }
        return ans;
    }
}
