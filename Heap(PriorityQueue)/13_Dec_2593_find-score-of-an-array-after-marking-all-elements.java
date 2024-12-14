import java.util.*;

class Solution {
    // Used arrayList as a PQ
    public long findScore(int[] nums) {
        int n = nums.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[] { nums[i], i });
        }
        boolean[] marked = new boolean[n];
        Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        long score = 0L;
        for (int[] curr : list) {
            int val = curr[0], index = curr[1];
            if (!marked[index]) {
                score += val;
                marked[index] = true;
                if (index - 1 >= 0)
                    marked[index - 1] = true;
                if (index + 1 < n)
                    marked[index + 1] = true;
            }
        }
        return score;
    }
}

class Solution2 {
    // TC:O(NlogN) SC:O(N) logN time taken by pq to sort
    // here i hv modified original array for mark
    public long findScore(int[] nums) {
        // min PriorityQueue
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        boolean mark[] = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[] { nums[i], i });
        }
        long score = 0;
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int idx = temp[1];
            // if idx is not marked means we can take that elements
            if (mark[idx] != true) {
                // add it to the score and mark
                score += nums[idx];
                // mark adjecent left
                if (idx > 0) {
                    mark[idx - 1] = true;
                }
                // mark adjecent right
                if (idx < nums.length - 1) {
                    mark[idx + 1] = true;
                }
            }
        }
        return score;

    }
}

class Solution3 {
    // TC:O(NlogN) SC:O(N) logN time taken by pq to sort
    // here i hv modified original array for mark
    class Pair implements Comparable<Pair> {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        public int compareTo(Pair P) {
            // if elemnts are not equal sort based on value
            if (this.val != P.val)
                return this.val - P.val;
            else// if elements are equals sort based on min idx
                return this.idx - P.idx;
        }
    }

    public long findScore(int[] nums) {
        // min PriorityQueue
        Queue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(new Pair(nums[i], i));
        }
        long score = 0;
        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            int val = temp.val;
            int idx = temp.idx;
            // if idx is not marked means we can take that elements
            if (nums[idx] != -1) {
                // add it to the score and mark
                score += nums[idx];
                // mark adjecent left
                if (idx > 0) {
                    nums[idx - 1] = -1;
                }
                // mark adjecent right
                if (idx < nums.length - 1) {
                    nums[idx + 1] = -1;
                }
            }
        }
        return score;

    }
}