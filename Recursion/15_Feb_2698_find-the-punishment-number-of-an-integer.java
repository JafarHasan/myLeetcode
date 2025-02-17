
class Solution {

    public int punishmentNumber(int n) {
        int result = 0;
        for (int num = 1; num <= n; num++) {
            int square = num * num;
            String s = square + "";
            if (check(s, num, 0, 0)) {
                result += square;
            }
        }
        return result;
    }

    private boolean check(String s, int num, int i, int currSum) {
        if (i == s.length()) {
            return currSum == num;
        }
        if (currSum > num) {
            return false;
        }
        boolean possible = false;
        for (int j = i; j < s.length(); j++) {
            String sub = s.substring(i, j + 1);
            int val = Integer.parseInt(sub);
            possible = possible || check(s, num, j + 1, currSum + val);

            if (possible == true) {
                return true;
            }
        }
        return possible;
    }

}
