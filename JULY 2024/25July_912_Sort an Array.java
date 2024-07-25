import java.util.*;
class Solution {
    // SC:O(N) TC:O(N) using Priority Queue
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int ele : nums) {
            pq.add(ele);
        }
        int i = 0;
        while (!pq.isEmpty()) {
            nums[i++] = pq.poll();
        }
        return nums;
    }
}