import java.util.ArrayList;
import java.util.List;

class Solution2 {
    // BF TC:O(N^2) SC:O(N) TLE
    public boolean isPalindrome(String s) {
        if (s.length() == 1)
            return true;
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public String nearestPalindromic(String n) {

        int m = n.length();
        if (m == 1)
            return (char) (n.charAt(0) - 1) + "";

        long number = Long.parseLong(n);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int cnt1 = 0;
        long temp = number;
        while (true) {
            cnt1++;
            temp--;
            sb1 = new StringBuilder(temp + "");
            if (isPalindrome(sb1.toString())) {
                break;
            }

        }
        temp = number;
        int cnt2 = 0;
        while (true) {
            cnt2++;
            temp++;
            sb2 = new StringBuilder(temp + "");
            if (isPalindrome(sb2.toString())) {
                break;
            }

        }
        if (cnt1 <= cnt2)
            return sb1.toString();
        return sb2.toString();

    }
}

class Solution {
    // TC:O(N) SC:O(5)=O(1)
    public String nearestPalindromic(String s) {
        int n = s.length();
        int mid = n / 2;
        long halfNo = Long.parseLong(s.substring(0, n % 2 == 0 ? mid : mid + 1));

        List<Long> possibleAns = new ArrayList<>(5);
        possibleAns.add(helper(halfNo, n % 2 == 0));
        possibleAns.add(helper(halfNo + 1, n % 2 == 0));
        possibleAns.add(helper(halfNo - 1, n % 2 == 0));
        possibleAns.add((long) (Math.pow(10, n - 1) - 1));
        possibleAns.add((long) (Math.pow(10, n) + 1));

        long diff = Long.MAX_VALUE;
        long ans = 0;
        long originalNo = Long.parseLong(s);

        for (long num : possibleAns) {
            if (num == originalNo)
                continue;

            if (Math.abs(num - originalNo) < diff) {
                diff = Math.abs(num - originalNo);
                ans = num;
            } else if (Math.abs(num - originalNo) == diff) {
                ans = Math.min(ans, num);
            }
        }
        System.out.print(possibleAns);
        return ans + "";
    }

    // Helper function to create a palindrome by mirroring the first half
    private long helper(long firstHalf, boolean isEven) {
        long result = firstHalf;
        if (!isEven)
            firstHalf /= 10; // If odd length, ignore the middle digit during mirroring

        // Mirror the digits
        while (firstHalf > 0) {
            result = result * 10 + firstHalf % 10;
            firstHalf /= 10;
        }

        return result;
    }
}