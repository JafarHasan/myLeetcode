class Solution {
    /*
     * k = 3 (maximum number of projects we can finish)
     * w = 0 (initial capital)
     * profits = [10, 5, 20, 15] (pure profit for each project)
     * capital = [0, 2, 1, 3] (minimum capital required to start each project)
     * ans=45 10+20+15
     */
    // TC:O(N)*O(logN)->TC:O(NlogN) SC:O(N*2)for 2d array +O(N) for heap->O(N)
    //Greedy    Sorting     maxHeap
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // Arrays.sort(capital); //if we sort we cant find corresponding profit, so we
        // cant sort

        int n = capital.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, (a, b) -> {
            return a[0] - b[0];
        });

        // define a maxHeap to store only profits
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // another method to define a maxHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        // iterate 2d array
        int i = 0;
        while (k-- > 0) { // TC:O(K) //if w is>=all the capitals element then all elements goes to heap

            // that will cause a TC:O(N) and SC:O(N)
            while (i < n && arr[i][0] <= w) {
                // i can buy that
                pq.offer(arr[i][1]); // add()
                i++;
            }
            if (pq.size() == 0)
                break;
            w += pq.remove();// get the max profit [2nd method poll()]
            // pushing or poping ele in a heap takes O(logN) TC
        }

        return w;

    }
}