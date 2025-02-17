
import java.util.*;

class Solution {

    //TC:O(NlogN) SC:O(N)
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int ele : nums) {
            pq.add((long) ele);
        }

        int operations = 0;
        while (pq.peek() < k) {
            long x = pq.poll();
            long y = pq.poll();
            long sum = Math.min(x, y) * 2 + Math.max(x, y);
            pq.add(sum);
            operations++;

        }
        return operations;
    }
}
