import java.util.*;
class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        
        List<List<Integer>> graph=new ArrayList<>();
        int n=edges.length;
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e:edges){
            int src=e[0];
            int dest=e[1];
            graph.get(src).add(dest);
        }
        boolean[] vis=new boolean[V];
        boolean[] inRec=new boolean[V];
        
        
        for(int i=0;i<V;i++){
            if(!vis[i] && dfs(graph,i,vis,inRec))return true;
        }
        return false;

        
    }
    private boolean dfs(List<List<Integer>> graph,int src,boolean[] vis,boolean[] inRec){
        vis[src]=true;
        inRec[src]=true;
        
        for(int nbr:graph.get(src)){
            if(!vis[nbr] && dfs(graph,nbr,vis,inRec)){
                return true;
            }
            else if(inRec[nbr])return true;
        }
        inRec[src]=false;
        return false;
    }
}