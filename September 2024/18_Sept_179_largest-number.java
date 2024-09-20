import java.util.Arrays;

/**
 * nums =
 * [3,30,34,5,9]
 * Stdout
 * 0 3 3 3 4 5 9
 * Output
 * "9543330"
 * Expected
 * "9534330"
 */
class Solution1 { // FAILED
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int ele : nums) {
            sb.append(ele);
        }
        char arr[] = sb.toString().toCharArray();
        Arrays.sort(arr);
        for (char i : arr) {
            System.out.print(i + " ");
        }
        StringBuilder temp = new StringBuilder();
        for (char ele : arr) {
            temp.insert(0, ele);
        }
        return temp.toString();
    }
}

class Solution {
    // TC:O(NlogN) N=nums.length SC:O(N)
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);// convert each Int no to String
        }
        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));// check for String conctination 3,30 330 or 303
        for (String i : str) {
            System.out.print(i + " ");
        }
        StringBuilder temp = new StringBuilder();
        for (String s : str) {
            temp.append(s);
        }
        return temp.charAt(0) == '0' ? "0" : temp.toString();
    }
}