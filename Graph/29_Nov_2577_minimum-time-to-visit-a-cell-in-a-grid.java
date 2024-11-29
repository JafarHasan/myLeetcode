class Solution {
    //source 0,0
    //destination [n-1][m-1]
    //to move forward t>=grid[i][j]
    //SC:O(N*M)+O(N*M)
    //TC:O(t+logV) t=edges E (cells n*m) V=vertives (cells(n*m)) 
    public int minimumTime(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][1]>1 && grid[1][0]>1)return -1;
        boolean vis[][] = new boolean[n][m];
        int result[][] = new int[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0,0,0});
        int direction[][]={{0,1},{-1,0},{0,-1},{1,0}};
        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            int time=temp[0];
            int i=temp[1];
            int j=temp[2];

            if(i==n-1 && j==m-1)return result[n-1][m-1];

            if(vis[i][j]==true){
                continue;

            }
            vis[i][j]=true;

            for(int[] dir:direction){
                int row=i+dir[0];
                int col=j+dir[1];

                if(row<0 || row>=n || col<0 || col>=m){
                    continue;
                }

                if(grid[row][col]<=time+1){
                    pq.add(new int[]{time+1,row,col});
                    result[row][col]=time+1;
                }
                else if((grid[row][col]-time)%2==0){
                    pq.add(new int[]{grid[row][col]+1,row,col});
                    result[row][col]=grid[row][col]+1;
                }
                else{
                     pq.add(new int[]{grid[row][col],row,col});
                    result[row][col]=grid[row][col];
                }
            }
        }
        return result[n-1][m-1];

    }
}