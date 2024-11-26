class Solution {
    public int findChampion(int n, int[][] edges) {
        int indegree[]=new int[n];
        for(int row[]:edges){
            int dest=row[1];
            indegree[dest]++;
        }
       
        int champion=-1;
        for(int i=0;i<n;i++){
            int ele=indegree[i];
            if(ele==0 && champion==-1){
                champion=i;
            }
            else if(ele==0)return -1;
        }
        return champion;
    }
}