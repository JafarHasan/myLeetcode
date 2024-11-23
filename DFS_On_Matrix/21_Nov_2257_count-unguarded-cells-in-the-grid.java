
class Solution {
    private void markGuard(int row,int col,int[][]vis){
        //UP
        for(int i=row-1;i>=0;i--){
            if(vis[i][col]==1|| vis[i][col]==2){
                break;
            }
            vis[i][col]=4;
        }
        //DOWN
        for(int i=row+1;i<vis.length;i++){
            if(vis[i][col]==1|| vis[i][col]==2){
                break;
            }
            vis[i][col]=4;
        }
        //LEFT
        for(int j=col-1;j>=0;j--){
            if(vis[row][j]==1|| vis[row][j]==2){
                break;
            }
            vis[row][j]=4;
        }
        //RIGHT
        for(int j=col+1;j<vis[0].length;j++){
            if(vis[row][j]==1|| vis[row][j]==2){
                break;
            }
            vis[row][j]=4;
        }
    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        //visit each guard
        //check all 4 dir
        //mark viisted
        int vis[][]=new int[m][n];

        //mark guard pos
        for(int row[]:guards){
            int i=row[0];
            int j=row[1];
            vis[i][j]=1;//mark gurad as 1
        }

        //mark walls pos
        for(int row[]:walls){
            int i=row[0];
            int j=row[1];
            vis[i][j]=2;//mark wall as 2
        }

        //visit and marked guarded cells
        for(int row[]:guards){
            int i=row[0];
            int j=row[1];
            markGuard(i,j,vis);//check all 4 dir and mark guarded cell
        }
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}