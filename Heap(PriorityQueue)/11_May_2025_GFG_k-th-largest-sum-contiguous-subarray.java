
import java.util.*;

class Solution {

    //TC:O(N^2*log(k))
    //SC:O(logK)
    public static int kthLargest(int[] arr, int k) {
        // code here
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                pq.add(sum);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}
