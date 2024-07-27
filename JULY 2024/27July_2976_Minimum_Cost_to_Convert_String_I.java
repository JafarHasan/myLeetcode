import java.util.*;

class Solution {
    // TC:O(N)+O(N)+O(26*26*26)=O(N)
    // SC:O(26*26)=O(1)
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] adjMatrix = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(adjMatrix[i], Integer.MAX_VALUE);
            adjMatrix[i][i] = 0;// diagonally cost 0 src to src itself
        }
        floydWarshall(adjMatrix, original, changed, cost);
        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            char sch = source.charAt(i);
            char tch = target.charAt(i);
            if (sch == tch)
                continue;

            if (adjMatrix[sch - 'a'][tch - 'a'] == Integer.MAX_VALUE) {
                // NO PATH EXISTS
                return (long) -1;
            } else
                ans += adjMatrix[sch - 'a'][tch - 'a'];
        }
        return ans;
    }

    public void floydWarshall(int[][] adjMatrix, char[] original, char[] changed, int[] cost) {
        for (int i = 0; i < cost.length; i++) {
            int src = original[i] - 'a';/// source char -a finding the idx in matrix
            int target = changed[i] - 'a';// target char -a finding the idx in matrix

            adjMatrix[src][target] = Math.min(adjMatrix[src][target], cost[i]);
        }
        // apply floydWarshall algo
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (adjMatrix[i][k] < Integer.MAX_VALUE && adjMatrix[k][j] < Integer.MAX_VALUE)
                        adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
                }
            }
        }
    }
}