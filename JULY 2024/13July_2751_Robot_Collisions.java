import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    // TC:O(NlogN) SC:O(N)
    public List<Integer> survivedRobotsHealths(int[] pos, int[] health, String dir) {
        int n = pos.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        // sort the index array based on position array
        Arrays.sort(indices, (a, b) -> pos[a] - pos[b]);

        List<Integer> robots = new ArrayList<>();
        for (int i : indices) {
            // if robot is movind right simply add
            if (dir.charAt(i) == 'R') {
                robots.add(i);
            } else {
                // robots is moving left so they will collide with right
                while (robots.size() > 0 && health[i] > 0) {
                    // find the last robots health moving right (that will be first to collide) so
                    // here its a LIFO(Stack)
                    int j = robots.get(robots.size() - 1);// getting the idx
                    if (health[j] > health[i]) {
                        // if health of robot moving right is greater than health of robot moving left
                        // so left will be destroyed
                        health[i] = 0;
                        // and right health will decrease by 1
                        health[j]--;

                    } else {// if health of robot moving right is smaller than health of robot moving left
                        // right will be destroyed left health will decrese by one
                        robots.remove(robots.size() - 1);
                        if (health[j] < health[i])
                            health[i] -= 1;// health of left decrease by 1
                        else {
                            health[i] -= health[i];
                        }
                        health[j] = 0;// health of right =0;

                    }

                }
            }
        }
        List<Integer> positiveHealths = new ArrayList<>();
        for (int h : health) {
            if (h > 0) {
                positiveHealths.add(h);
            }
        }
        return positiveHealths;
    }
}
