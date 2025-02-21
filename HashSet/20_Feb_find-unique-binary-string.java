import java.util.*;
class Solution {

    // max decimal Value we can get from n=2^n-1
    private int convertToDecimal(String s) {
        int power = 0;
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch != '0') {
                ans += Math.pow(2, power);
            }
            power++;
        }
        return ans;
    }

    // TC:O(NxM) N=nums[i].length,m=nums.length();
    public String findDifferentBinaryString(String[] nums) {
        // prepare the set of decimal No
        int n = nums[0].length();
        Set<Integer> set = new HashSet<>();
        for (String s : nums) {
            set.add(convertToDecimal(s));
        }
        System.out.println(set);
        for (int i = 0; i <= n; i++) {// we can also i<=Math.pow(2,n)-1
            if (!set.contains(i)) {
                // Convert to binary string and pad with leading zeros to length n.
                String res = Integer.toBinaryString(i);
                res = String.format("%" + n + "s", res).replace(' ', '0');
                return res;
            }

        }
        return "";
    }
}
