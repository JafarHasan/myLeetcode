
class Solution {

    // TC:O(N) SC:O(N)
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder sb = new StringBuilder();
        long sum = 0;
        //start right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            //take curr char
            char ch = s.charAt(i);
            //add suffix sum
            sum += shifts[i];
            //shift curr char (suffix time)
            char newChar = (char) ('a' + (ch - 'a' + sum) % 26);
            sb.append(newChar);
        }
        return sb.reverse().toString();
    }
}
