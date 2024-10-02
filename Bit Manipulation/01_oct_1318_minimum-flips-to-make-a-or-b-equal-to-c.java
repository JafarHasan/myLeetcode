class Solution {
    public int minFlips(int a, int b, int c) {
        int flip = 0;
        while (a != 0 || b != 0 || c != 0) {
            // if c's right most bit=1 then
            if ((c & 1) == 1) {
                if ((a & 1) == 0 && (b & 1) == 0) {
                    flip++;
                }
            }
            // if c's (RMB)MSB is 0
            else {
                if ((a & 1) == 1) {
                    flip++;
                }
                if ((b & 1) == 1) {
                    flip++;
                }
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return flip;
    }
}
/**
 * find right most bit (num&1) exp=1001 & 1=0001 rmb=1
 * Right shift num>>=1
 */