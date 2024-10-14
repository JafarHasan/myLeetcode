import java.util.*;

class Solution {
    // TC:O(NlogN) for PQ operations and SC:O(N)
    public long maxKelements(int[] nums, int k) {
        long score = 0;
        // max heap
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        // also PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->b-a);

        for (int ele : nums) {
            pq.add(ele);
        }
        while (!pq.isEmpty() && k > 0) {
            // take max ele
            int val = pq.poll();
            // add into score
            score += val;
            // find Ceil and add into PQ also pq.add((int)Math.ceil((double)max/3));
            pq.add((int) Math.ceil(val / 3.0));
            k--;
        }
        return score;

    }
}