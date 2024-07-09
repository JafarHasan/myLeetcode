class Solution {
    // TC:O(N) SC:O(1)
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double waitingTime = 0;
        int finishTime = 0;

        for (int i = 0; i < n; i++) {
            int arrival = customers[i][0];
            int serviceTime = customers[i][1];

            // Calculate finish time of current customer
            finishTime = Math.max(finishTime, arrival) + serviceTime;

            // Calculate waiting time for current customer
            waitingTime += finishTime - arrival;
        }

        return waitingTime / n;
    }
}