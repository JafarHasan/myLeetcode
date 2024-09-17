import java.util.Arrays;
import java.util.List;

class Solution1 {
    // TC:O(N) SC:O(N)
    public int findMinDifference(List<String> tPoints) {
        int[] list = new int[tPoints.size()];
        for (int i = 0; i < tPoints.size(); i++) {
            String time = tPoints.get(i);
            String hh = time.substring(0, 2);// get HH
            int h = Integer.parseInt(hh) * 60;
            String mm = time.substring(3);
            int m = Integer.parseInt(mm);
            int mints = h + m;
            list[i] = mints;
        }
        Arrays.sort(list);
        int minDiff = Integer.MAX_VALUE;
        // min DIff betweeen adjacent time
        for (int i = 1; i < list.length; i++) {

            minDiff = Math.min(minDiff, list[i] - list[i - 1]);
        }
        return Math.min(minDiff, 24 * 60 - list[list.length - 1] + list[0]);

    }
}

class Solution {
    // TC:O(N) SC:O(N)
    public int findMinDifference(List<String> tPoints) {
        int[] list = new int[tPoints.size()];
        for (int i = 0; i < tPoints.size(); i++) {

            String time = tPoints.get(i);
            int hh = Integer.parseInt(time.substring(0, 2));// get HH convert into Int
            int mm = Integer.parseInt(time.substring(3));// get mm convert into int
            list[i] = hh * 60 + mm;// convert time in minutes
        }
        Arrays.sort(list);
        int minDiff = Integer.MAX_VALUE;
        // min DIff betweeen adjacent time
        for (int i = 1; i < list.length; i++) {
            minDiff = Math.min(minDiff, list[i] - list[i - 1]);
        }
        // time between last ans first
        return Math.min(minDiff, 24 * 60 - list[list.length - 1] + list[0]);

    }
}