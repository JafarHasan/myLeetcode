
class Solution {
    // TC:O(N) SC:O(1)
    public boolean lemonadeChange(int[] bills) {

        int cnt5 = 0, cnt10 = 0;
        for (int ele : bills) {
            if (ele == 5) {
                cnt5++;// collect $5
            } else if (ele == 10) {
                if (cnt5 > 0) {
                    cnt5--; // give one $5 as change
                    cnt10++;
                } else {
                    return false;
                }
            } else {
                if (cnt5 > 0 && cnt10 > 0) {
                    cnt5--;// give one $5 as change
                    cnt10--;// give one $10 as change total 15$ change given
                } else if (cnt5 > 2 && cnt10 == 0) {
                    cnt5 -= 3;// give 5+5+5 when 10 is not available

                } else {
                    return false;
                }

            }
        }
        return true;
    }
}