
class Solution {

    //TC:O(NxM)
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int cnt = 0;
        for (String s : bank) {
            int curr = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '1') {
                    curr++;
                }
            }

            if (curr != 0) {
                cnt += prev * curr;
                prev = curr;
            }
        }
        return cnt;
    }
}
