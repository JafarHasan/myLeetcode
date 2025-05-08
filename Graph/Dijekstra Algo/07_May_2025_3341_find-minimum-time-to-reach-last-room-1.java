
import java.util.*;

class Solution {

    //TC:O(MxN)*log(NxM)=>pq.add and pq.poll take log(size) TC
    private final int directions[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    //given a weighted graph as matrix
    //want to find MINIMUM so use Dijekstra Algo
    public int minTimeToReach(int[][] moveTime) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();//all cells will be inserted SC:O(NxM)
        //sourse (0,0)
        //detination (n-1,m-1)
        int n = moveTime.length;
        int m = moveTime[0].length;
        int ans[][] = new int[n][m];
        for (int r[] : ans) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        //sourse timing to reach sourse itself is 0
        ans[0][0] = 0;//already 0 is there
        pq.add(new Pair(0, 0, 0));//time=0,row=0,col=0

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int currTime = p.time;
            int row = p.i;
            int col = p.j;

            //we are on destination
            if (row == n - 1 && col == m - 1) {
                return currTime;
            }

            for (int d[] : directions) {
                int new_i = row + d[0];
                int new_j = col + d[1];

                ///is safe to move next i j
                if (new_i >= 0 && new_i < n && new_j >= 0 && new_j < m) {
                    //if wait will be -ve it will become 0
                    int wait = Math.max(0, moveTime[new_i][new_j] - currTime);
                    int arrTime = currTime + wait + 1;

                    if (ans[new_i][new_j] > arrTime) {
                        ans[new_i][new_j] = arrTime;
                        pq.add(new Pair(arrTime, new_i, new_j));
                    }
                }
            }
        }
        return -1;

    }

    class Pair implements Comparable<Pair> {

        int time;
        int i;
        int j;

        Pair(int t, int i, int j) {
            this.time = t;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Pair other) {
            return this.time - other.time;
        }
    }
}
