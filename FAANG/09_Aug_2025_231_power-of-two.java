
class Solution {

    public boolean isPowerOfTwo(int n) {
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
}

class Solution_UsingBits {

    public boolean isPowerOfTwo(int n) {
        if (n < 0) {
            return false;
        }
        String num = Integer.toBinaryString(n);
        if (num.charAt(0) != '1') {
            return false;
        }
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }
}
