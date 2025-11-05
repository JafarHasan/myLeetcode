
import java.util.*;

class Solution {
    
    private int findSumOfTopXElements(Map<Integer, Integer> map, int x) {
        //find top x frequent elements 
        // min-heap: smallest freq (and value) at top
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1]; // smaller frequency first
            } else {
                return a[0] - b[0]; // if same freq, smaller value first

            }
        });

        for (int key : map.keySet()) {
            pq.add(new int[]{key, map.get(key)});

            while (pq.size() > x) {
                pq.poll();
            }
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            sum += temp[0] * temp[1];
        }
        return sum;
    }

    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int i = 0;
        int j = 0;
        int idx = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (j < n) {
            //add new element in map
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            //if we find a k size window
            if (j - i + 1 == k) {
                //find top x elements and their sum 
                //add them in ans array
                ans[idx++] = findSumOfTopXElements(map, x);
                //remove last elements from map
                map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            j++;

        }
        return ans;
    }
}
