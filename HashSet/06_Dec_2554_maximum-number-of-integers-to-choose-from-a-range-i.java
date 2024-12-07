import java.util.*;

class Solution {
    // TC:O(N) SC:O(1001) which will be consider as constant space a M=length of
    // banned array beast 100%
    public int maxCount(int[] banned, int n, int maxSum) {
        boolean ban[] = new boolean[10001];
        for (int ele : banned) {
            ban[ele] = true;
        }
        int sum = 0;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            // if its not banned then add it and check if we can take it
            if (ban[i] == false) {
                // if sum is<=maxSum after adding curr Element than we can take it
                if ((sum + i) <= maxSum) {
                    sum += i;
                    // increase the cnt
                    cnt++;
                }
                // if we cant take it so we will not be able to take
                // all next elements just return cnt
                else
                    return cnt;

            }
        }
        return cnt;

    }
}

class Solution2 {
    // TC:O(N) SC:O(M) M=length of banned array
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for (int ele : banned) {
            set.add(ele);
        }
        int sum = 0;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            // if its not banned then add it and check if we can take it
            if (!set.contains(i)) {
                // if sum is<=maxSum after adding curr Element than we can take it
                if ((sum + i) <= maxSum) {
                    sum += i;
                    // increase the cnt
                    cnt++;
                }
                // if we cant take it so we will not be able to take
                // all next elements just return cnt
                else
                    return cnt;

            }
        }
        return cnt;
    }
}