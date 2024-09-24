import java.util.Arrays;
import java.util.HashMap;

class Solution1 {
    // Brute Force TC:O(NXM*Math.min(n,m)) N=arr1.length,M=arr1.length
    // SC:O(1)
    // TLE:711/718 passed
    private int findPrefix(int x, int y) {
        String s1 = Integer.toString(x);
        String s2 = Integer.toString(y);
        int len = 0;
        int n = s1.length();
        int m = s2.length();
        int min = Math.min(n, m);
        for (int i = 0; i < min; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                len++;
            } else
                break;
        }
        return len;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int ans = 0;
        // Sort both arrays to bring similar prefixes closer together
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        // Compare only adjacent pairs in sorted arrays
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                // Find prefix between the current elements of arr1 and arr2
                int newLen = findPrefix(arr1[i], arr2[j]);
                ans = Math.max(ans, newLen);

            }
        }
        return ans;
    }

}

// import java.util.HashMap;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashMap<String, Integer> prefixMap = new HashMap<>();

        // Step 1: Build the prefix map for arr1
        for (int num : arr1) {
            String strNum = Integer.toString(num);
            StringBuilder prefix = new StringBuilder();
            for (char ch : strNum.toCharArray()) {
                prefix.append(ch);
                prefixMap.put(prefix.toString(), prefixMap.getOrDefault(prefix, 0) + 1);
            }
        }

        int maxLength = 0;

        // Step 2: Check for common prefixes in arr2
        for (int num : arr2) {
            String strNum = Integer.toString(num);
            StringBuilder prefix = new StringBuilder();
            for (char ch : strNum.toCharArray()) {
                prefix.append(ch);
                if (prefixMap.containsKey(prefix.toString())) {
                    maxLength = Math.max(maxLength, prefix.length());
                }
            }
        }

        return maxLength;
    }
}