import java.util.*;

class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int size=adj.size();
        boolean[] vis=new boolean[size];
        ArrayList<Integer> list=new ArrayList<>();
        dfs(adj,0,vis,list);
        return list;
    }
    private void dfs(ArrayList<ArrayList<Integer>> adj,int src,boolean[] vis,ArrayList<Integer> list){
        vis[src]=true;
        list.add(src);
        
        for(int nbr:adj.get(src)){
            if(!vis[nbr]){
                dfs(adj,nbr,vis,list);
            }
        }
    }
}