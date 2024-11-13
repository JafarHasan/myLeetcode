class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];
        int flag[] = new int[1];
        for (int i = 0; i < n; i++) {
            int idx = 0;
            for (int j = 0; j < m; j++) {

                if (board[i][j] == word.charAt(0)) {
                    dfs(board,i, j, n, m, word, idx, flag,vis);

                }
            }
        }
        if(flag[0]==1) return true;
        return false;

    }

    public void dfs(char[][] mat, int i, int j, int n, int m, String word, int idx, int[] flag,int[][] vis) {

        if (idx == word.length()) {
            flag[0] = 1;
            return;
        }
        if (i < 0 || j < 0 || i >=n|| j >=m  || mat[i][j] != word.charAt(idx)|| vis[i][j] == 1)
            return;
        vis[i][j] = 1;// visited
        dfs(mat, i + 1, j, n, m, word, idx + 1, flag,vis);
        dfs(mat, i, j + 1, n, m, word, idx + 1, flag,vis);
        dfs(mat, i - 1, j, n, m, word, idx + 1, flag,vis);
        dfs(mat, i, j - 1, n, m, word, idx + 1, flag,vis);
        vis[i][j]=0;//mark unvisited
    }
}