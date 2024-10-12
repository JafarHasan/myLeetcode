import java.util.*;

class Solution {
    // TC:O(Nlogn) SC:O(N) 46ms
    public int smallestChair(int[][] times, int targetFriend) {
        int targetStart = times[targetFriend][0];
        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < times.length; ++i) {
            available.offer(i);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < times.length; ++i) {
            while (!pq.isEmpty() && pq.peek()[0] <= times[i][0]) {
                available.offer(pq.poll()[1]);
            }

            if (times[i][0] == targetStart) {
                break;
            }

            pq.offer(new int[] { times[i][1], available.poll() });
        }

        return available.peek();
    }
}

class Solution1 {
    // TC:O(N^2) SC:O(N) 112ms BF
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        // store the arrival time of target friends
        int arrivalTimeOfTargetFriend = times[targetFriend][0];
        // store the array based on arrival time
        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        int chairs[] = new int[n];

        for (int row[] : times) {
            int arrival = row[0];
            int depart = row[1];

            for (int i = 0; i < n; i++) {
                /// chairs is empty set depart time
                if (chairs[i] <= arrival) {
                    chairs[i] = depart;

                    if (arrival == arrivalTimeOfTargetFriend) {
                        return i;
                    }
                    break;
                }
            }
        }
        return -1;

    }
}
