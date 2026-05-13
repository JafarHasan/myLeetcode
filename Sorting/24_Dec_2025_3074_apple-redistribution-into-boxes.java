
import java.util.*;

class Solution {

    public int minimumBoxes(int[] apple, int[] capacity) {

        int sum = 0;
        for (int a : apple) {
            sum += a;
        }
        Arrays.sort(capacity);//O(NlogN)
        int cnt = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            sum -= capacity[i];
            cnt++;
            if (sum <= 0) {
                return cnt;
            }
        }
        return capacity.length;
    }
}
