import java.util.PriorityQueue;

class Solution {
    // TC:O(N) SC:O(N)
    public int findKthLargest2(int[] nums, int k) {
        // max-heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int ele : nums) {
            pq.add(ele);
        }
        while (pq.size() > 0 && pq.size() > k) {
            pq.poll();
        }
        return pq.peek();

    }

    public int findKthLargest(int[] nums, int k) {
        // max-heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int ele : nums) {
            pq.offer(ele);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}