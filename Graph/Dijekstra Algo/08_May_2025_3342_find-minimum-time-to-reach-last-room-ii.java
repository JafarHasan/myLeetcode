
import java.util.*;

class Solution {

    /**
     * Time complexity: O(N∗Mlog(N∗M)) Space complexity: O(N∗M)
     */
    class Pair implements Comparable<Pair> {

        int time;
        int i;
        int j;
        int moveT;

        Pair(int t, int i, int j, int moveT) {
            this.time = t;
            this.i = i;
            this.j = j;
            this.moveT = moveT;
        }
        @Override
        public int compareTo(Pair other) {
            return this.time - other.time;
        }
    }

    private final int directions[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int ans[][] = new int[n][m];
        for (int r[] : ans) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        ans[0][0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, 0, 2));//time,i,j

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int currTime = p.time;
            int row = p.i;
            int col = p.j;
            int moveT = p.moveT;
            //IF WE ARE ON DESTINATION
            if (row == n - 1 && col == m - 1) {
                return currTime;
            }
            int new_move_time = (moveT == 1) ? 2 : 1;
            for (int d[] : directions) {
                int new_i = row + d[0];
                int new_j = col + d[1];

                //IS SAFE TO GO NEXT ROOM
                if (new_i >= 0 && new_i < n && new_j >= 0 && new_j < m) {
                    int new_time = Math.max(currTime, moveTime[new_i][new_j]) + new_move_time;

                    if (ans[new_i][new_j] > new_time) {
                        ans[new_i][new_j] = new_time;
                        pq.add(new Pair(new_time, new_i, new_j, new_move_time));
                    }

                }
            }
        }
        return -1;

    }
}
