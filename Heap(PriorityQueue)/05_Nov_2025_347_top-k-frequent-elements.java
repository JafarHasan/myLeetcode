
import java.util.*;

class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        for (int key : map.keySet()) {
            pq.add(new int[]{key, map.get(key)});
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];
        int idx = 0;
        while (!pq.isEmpty() && idx < k) {
            ans[idx++] = pq.poll()[0];
        }
        return ans;

    }
}
