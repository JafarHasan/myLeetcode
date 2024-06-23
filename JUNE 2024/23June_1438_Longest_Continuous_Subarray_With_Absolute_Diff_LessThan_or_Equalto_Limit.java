class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int si = 0, ei = 0;

        // minHeap
        PriorityQueue<Pair1> minHeap = new PriorityQueue<>(); // | ele | idx |
        // maxHeap
        PriorityQueue<Pair2> maxHeap = new PriorityQueue<>();

        // can also initialize like this but hv to remove compareTo() from pair1 ans
        // pair2
        // PriorityQueue<Pair1> minHeap = new PriorityQueue<>((a, b) -> a.ele - b.ele);
        // PriorityQueue<Pair2> maxHeap = new PriorityQueue<>((a, b) -> b.ele - a.ele);

        int i = 0, j = 0;
        int maxLength = 0;

        while (j < n) {
            maxHeap.add(new Pair2(nums[j], j));
            minHeap.add(new Pair1(nums[j], j));

            // While the difference between max and min elements in the current window
            // exceeds limit
            while (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek().ele - minHeap.peek().ele > limit) {
                // Move the left pointer (i) to the right until the condition is satisfied
                i = Math.min(maxHeap.peek().idx, minHeap.peek().idx) + 1;

                // Remove elements from heaps whose indices are outside the current window [i,
                // j]
                while (maxHeap.size() > 0 && maxHeap.peek().idx < i) {
                    maxHeap.poll();
                }
                while (minHeap.size() > 0 && minHeap.peek().idx < i) {
                    minHeap.poll();
                }

            }
            // Update maxLength
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }
        return maxLength;

    }

    class Pair1 implements Comparable<Pair1> {
        int ele, idx;

        Pair1(int ele, int idx) {
            this.ele = ele;
            this.idx = idx;
        }

        public int compareTo(Pair1 p) {
            return this.ele - p.ele;
        }
    }

    class Pair2 implements Comparable<Pair2> {
        int ele, idx;

        Pair2(int ele, int idx) {
            this.ele = ele;
            this.idx = idx;
        }

        public int compareTo(Pair2 p) {
            return p.ele - this.ele;
        }
    }

}