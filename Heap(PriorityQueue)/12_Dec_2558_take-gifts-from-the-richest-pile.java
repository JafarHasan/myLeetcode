
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    // TC:O(NlogN) SC:O(N)
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for (int ele : gifts) {
            pq.add(ele);
        }

        while (k-- > 0) {
            int temp = (int) Math.floor(Math.sqrt(pq.poll()));
            pq.add(temp);
        }

        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;

    }
}