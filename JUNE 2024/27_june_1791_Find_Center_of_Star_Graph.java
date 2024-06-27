class Solution {
    // public int findCenter(int[][] edges) {
    // int n = edges.length;
    // int maxNode=0;
    // // Find the maximum node value
    // for (int i = 0; i < n; i++) {
    // maxNode = Math.max(maxNode, Math.max(edges[i][0], edges[i][1]));
    // }
    // int indegree[] = new int[maxNode + 1];// SC:O(n)
    // for (int i = 0; i < n; i++) {
    // int src = edges[i][0];
    // int dest = edges[i][1];

    // indegree[src]++;
    // indegree[dest]++;
    // }
    // // Check for the node with indegree n-1
    // for (int i = 1; i <= maxNode; i++) {
    // if (indegree[i] == maxNode - 1) {
    // return i;
    // }
    // }
    // return -1;
    // }

    // TC;O(1) SC:O(1)
    public int findCenter(int[][] edges) {
        int a = edges[0][0];
        int b = edges[0][1];

        if (a == edges[1][0] || a == edges[1][1])
            return a;
        else
            return b;
    }
}
