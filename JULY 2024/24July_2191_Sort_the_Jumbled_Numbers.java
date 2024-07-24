
import java.util.*;

class Solution {
    class Pair implements Comparable<Pair> {
        int no;
        int idx;

        Pair(int no, int idx) {
            this.no = no;
            this.idx = idx;
        }

        public int compareTo(Pair p) {
            return this.no - p.no;
        }
    }

    // tc:o(NlogN) SC:O(N)
    public int[] sortJumbled(int[] mapp, int[] nums) {
        int n = nums.length;
        Pair temp[] = new Pair[n];
        for (int i = 0; i < n; i++) {
            int ele = nums[i];
            String numStr = ele + "";
            String mappStr = mappedNo(numStr, mapp);
            int newNo = Integer.parseInt(mappStr);
            temp[i] = new Pair(newNo, i);
        }
        Arrays.sort(temp);
        int ans[] = new int[n];
        int i = 0;
        for (Pair p : temp) {
            ans[i++] = nums[p.idx];
        }
        return ans;

    }

    public String mappedNo(String num, int[] mapp) {
        StringBuilder s = new StringBuilder("");
        for (char ch : num.toCharArray()) {
            int idx = ch - '0';
            s.append(mapp[idx]);
        }
        return s.toString();
    }

    // 2nd Method without converting no to String opimization
    public int[] sortJumbled2(int[] mapp, int[] nums) {
        int n = nums.length;
        Pair temp[] = new Pair[n];
        for (int i = 0; i < n; i++) {
            int ele = nums[i];
            int mappNo = mappedNumber(ele, mapp);
            temp[i] = new Pair(mappNo, i);

        }
        Arrays.sort(temp);
        int ans[] = new int[n];
        int i = 0;
        for (Pair p : temp) {
            ans[i++] = nums[p.idx];
        }
        return ans;
    }

    public int mappedNumber(int ele, int[] mapp) {
        int place = 1;
        int ansNo = 0;
        if (ele == 0) {
            return mapp[0];
        }
        while (ele > 0) {
            int rem = ele % 10;
            ansNo += mapp[rem] * place;
            place *= 10;
            ele /= 10;
        }
        return ansNo;
    }
}