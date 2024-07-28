import java.util.*;

class Solution {
    int stepsTime(int steps, int time, int change) {
        int res = 0;
        while (--steps > 0) {
            res += time;
            if ((res / change) % 2 == 1)
                res = (res / change + 1) * change;
        }
        return res + time;
    }

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        /// making graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int row[] : edges) {
            int src = row[0];
            int dest = row[1];

            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }
        int step = -1;
        int[] minSteps = new int[n + 1];
        Arrays.fill(minSteps, 10001);
        List<Integer> q = new ArrayList<>(List.of(1));
        while (!q.isEmpty() && ++step <= minSteps[n] + 1) {
            List<Integer> q1 = new ArrayList<>();
            for (int i : q) {
                if (step == minSteps[i] || step > minSteps[i] + 1)
                    continue;
                minSteps[i] = Math.min(minSteps[i], step);
                if (i == n && step > minSteps[n])
                    return stepsTime(step, time, change);
                for (int j : graph.get(i))
                    q1.add(j);
            }
            q = q1;
        }
        return stepsTime(minSteps[n] + 2, time, change);
    }

}