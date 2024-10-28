package AddTwoNumber;

class Solution {
    public String addStrings(String nums1, String nums2) {

        StringBuilder sb = new StringBuilder();
        int i = nums1.length() - 1, j = nums2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int n1 = i >= 0 ? nums1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? nums2.charAt(j) - '0' : 0;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            i--;
            j--;
        }
        return sb.reverse().toString();

    }
}