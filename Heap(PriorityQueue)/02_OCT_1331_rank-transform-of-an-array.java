import java.util.*;

class Solution {
    // Using Map TC:O(NlogN) SC:O(2N)=>O(N)
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0)
            return arr;
        HashMap<Integer, Integer> map = new HashMap<>();
        int temp[] = arr.clone();
        Arrays.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            map.putIfAbsent(temp[i], map.size() + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;

    }
}

class Solution2 {
    // Using Min Heap TC:O(N) SC:O(N)
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0)
            return arr;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(new Pair(arr[i], i));
        }
        int rank = 1;
        Pair p = pq.poll();
        int idx = p.idx;
        int val = p.val;
        arr[idx] = rank;
        while (!pq.isEmpty()) {
            p = pq.poll();
            int currIdx = p.idx;
            int currVal = p.val;
            if (currVal != val) {
                rank++;
            }
            val = currVal;
            arr[currIdx] = rank;
        }
        return arr;
    }
}

class Pair implements Comparable<Pair> {
    int val;
    int idx;

    Pair(int v, int i) {
        this.val = v;
        this.idx = i;
    }

    public int compareTo(Pair p) {
        return this.val - p.val;
    }
}