class Solution {
    // Google
    // we can remove stone only if either that row has one stone or coloum has one
    // stone
    // or both hv one stone
    // same as connected componants
    // Hash Table Depth-First Search Union Find Graph

    // TC:O(N) SC:O(N)
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean[] vis = new boolean[n];
        int group = 0;
        for (int i = 0; i < n; i++) {
            // if stone is not visited
            if (vis[i] == false) {
                dfs(stones, i, vis);
                group++;
            }

        }
        return n - group;
    }

    private void dfs(int[][] stones, int idx, boolean[] vis) {
        vis[idx] = true;// mark visited

        for (int i = 0; i < stones.length; i++) {
            int r = stones[idx][0];
            int c = stones[idx][1];

            if ((vis[i] == false) && (stones[i][0] == r || stones[i][1] == c)) {
                dfs(stones, i, vis);
            }
        }

    }
}