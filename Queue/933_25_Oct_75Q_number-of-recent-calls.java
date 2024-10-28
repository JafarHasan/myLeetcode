class RecentCounter {
    Queue<Integer> q;
    public RecentCounter() {
        q=new LinkedList<>();
     
    }
    
    public int ping(int t) {   
        
         q.offer(t);
        while(!q.isEmpty() && t-3000>q.peek()){
            q.poll();
        }
        return q.size();
        
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
class RecentCounter2 {
    List<Integer> list;
    int i=0,j=-1;
    public RecentCounter2() {
        list=new ArrayList<>();
        i=0;
        j=-1; 
    }
    
    public int ping(int t) {   
        
        list.add(t);
        j++;
        while(i<j && list.get(j)-3000>list.get(i)){
            i++;
        }
        return j-i+1;
        
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */