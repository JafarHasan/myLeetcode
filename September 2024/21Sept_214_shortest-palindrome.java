class Solution1 {
    // TLE 120/123 passed TC:O(n^2.m)
    // n is the length of the string, and 𝑚 is the number of iterations that could
    // be up to n
    private boolean isPalindrome(String s) { // TC:O(n)
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        int insertPos = 0;
        int last = s.length() - 1;
        while (true) {
            if (isPalindrome(sb.toString())) {
                return sb.toString();
            }
            sb.insert(insertPos, s.charAt(last));
            insertPos++;
            last--;

        }
    }
}

class Solution2 {
    // passed TC:O(n^2) SC:o(n)
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public String shortestPalindrome(String s) {
        int n = s.length();
        int maxLength = 0;
        // finding the longest Palindrome's length
        for (int i = 0; i < n; i++) {
            if (isPalindrome(s.substring(0, n - i))) {
                maxLength = n - i;
                break;
            }
        }
        String add = s.substring(maxLength);
        StringBuilder sb = new StringBuilder(add).reverse();
        return sb + s;

    }
}

class Solution {

    // TC:O(N) SC:O(N)
    public String shortestPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return s;
        }

        // Find the longest palindromic prefix
        int left = 0;
        for (int right = length - 1; right >= 0; right--) {
            if (s.charAt(right) == s.charAt(left)) {
                left++;
            }
        }

        // If the whole string is a palindrome, return the original string
        if (left == length) {
            return s;
        }

        // Extract the suffix that is not part of the palindromic prefix
        String nonPalindromeSuffix = s.substring(left);
        StringBuilder reverseSuffix = new StringBuilder(
                nonPalindromeSuffix).reverse();

        // Form the shortest palindrome by prepending the reversed suffix
        return reverseSuffix
                .append(shortestPalindrome(s.substring(0, left)))
                .append(nonPalindromeSuffix)
                .toString();
    }
}