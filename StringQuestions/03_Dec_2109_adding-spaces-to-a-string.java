class Solution {
    // TC:O(N) SC;O(N)
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s);
        int cnt = 0;
        for (int idx : spaces) {
            int mainIdx = idx + cnt;
            sb.insert(mainIdx, ' ');
            // now every char will shift to next position
            // if array[i]=5 than char ' ' will be added to 6
            // hence cnt++;
            cnt++;
        }
        return sb.toString();
    }
}