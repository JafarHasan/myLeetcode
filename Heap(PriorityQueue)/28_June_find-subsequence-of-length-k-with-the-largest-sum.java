import java.util.*;
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        // Store each element with its original index
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1]; // tie-breaker by index if needed
            return a[0] - b[0]; // min-heap based on value
        });

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[] { nums[i], i });
            if (pq.size() > k)
                pq.poll(); // keep only top k elements
        }

        // Now we have k largest elements, but we need to sort them by index
        List<int[]> list = new ArrayList<>(pq);
        list.sort(Comparator.comparingInt(a -> a[1]));

        // Build result
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i)[0];
        }

        return res;
    }

}