import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int key : map.keySet()) {
            pq.add(new Pair(key, map.get(key)));

        }

        int n = nums.length;
        int ans[] = new int[n];
        int cnt = 0;
        while (pq.size() > 0 && k-- > 0) {
            ans[cnt++] = pq.poll().val;
        }
        int result[] = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            result[i] = ans[i];
        }
        return result;
        // return new int[]{};
    }

    public class Pair implements Comparable<Pair> {
        int val;
        int freq;

        Pair(int v, int f) {
            this.val = v;
            this.freq = f;
        }

        public int compareTo(Pair o) {
            return o.freq - this.freq;
        }
    }
}

// 2nd method
class Solution2 {
    // SC:O(N) TC:O(N)
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int key : map.keySet()) {
            pq.add(new Pair(key, map.get(key)));
            if (pq.size() > k) {
                pq.poll();
            }

        }

        int cnt = pq.size();
        int i = 0;
        int result[] = new int[cnt];
        while (pq.size() > 0 && k-- > 0) {
            result[i++] = pq.poll().val;
        }

        return result;

    }

    // using min heap
    public class Pair implements Comparable<Pair> {
        int val;
        int freq;

        Pair(int v, int f) {
            this.val = v;
            this.freq = f;
        }

        public int compareTo(Pair p) {
            return this.freq - p.freq;
        }
    }
}
// while(pq.size()>0){
// Pair temp=pq.poll();
// System.out.println(temp.val+" "+temp.freq);
// }
// while(pq.size()>0){
// Pair temp=pq.poll();
// System.out.println(temp.val+" "+temp.freq);
// }