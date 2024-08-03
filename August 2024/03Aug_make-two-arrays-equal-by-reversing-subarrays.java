import java.util.*;

class Solution {
    // only 104/108 cases passed
    /**
     * [1,2,2,3]
     * arr =
     * [1,1,2,3]
     * Output
     * true
     * Expected
     * false
     */
    public boolean canBeEqual2(int[] target, int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int ele : target) {
            set.add(ele);
        }
        for (int ele : arr) {
            if (!set.contains(ele)) {
                return false;
            }
        }
        return true;
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        int cnt1[] = new int[1001];
        int cnt2[] = new int[1001];

        for (int ele : target) {
            cnt1[ele]++;
        }
        for (int ele : arr) {
            cnt2[ele]++;
        }
        return Arrays.equals(cnt1, cnt2);
    }
}