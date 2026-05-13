
import java.util.*;

class Solution {

    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        long ans = 0;
        int turn = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans = ans + Math.max((happiness[i] - turn), 0);
            turn++;
            if (turn == k) {
                break;
            }
        }
        return ans;
    }
}

class Solution_my {

    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long ans = 0l;
        int dec = 0;
        int n = happiness.length;

        for (int i = n - 1; i >= 0 && k > 0; i--) {
            if (happiness[i] - dec <= 0) {
                break;
            }
            ans += happiness[i] - dec;
            dec++;
            k--;

        }

        return ans;
    }

}
