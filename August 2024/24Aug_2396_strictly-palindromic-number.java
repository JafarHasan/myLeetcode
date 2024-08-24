class Solution2 {
    public boolean isPalindrome(String s) {
        if (s.length() == 1)
            return true;
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public StringBuilder convertToBase(int n, int base) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, n % base);
            n /= base;
        }
        return sb;
    }

    public boolean isStrictlyPalindromic(int n) {
        int temp = n;
        for (int base = 2; base <= temp - 2; base++) {
            StringBuilder sb = convertToBase(n, base);
            if (!isPalindrome(sb.toString()))
                return false;
        }
        return true;
    }
}

/*
 * The condition is extreme hard to satisfy, think about it...
 * for every base b between 2 and n - 2...
 * 4 is not strictly palindromic number
 * 5 is not strictly palindromic number
 * ..
 * then the bigger, the more impossible.
 * Just return false
 */

class Solution {

    public boolean isStrictlyPalindromic(int n) {
        return false;
    }
}