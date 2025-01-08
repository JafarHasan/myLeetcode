
class Solution {

    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shift = new int[n + 1];

        for (int[] shiftOp : shifts) {
            int start = shiftOp[0], end = shiftOp[1], direction = shiftOp[2];
            shift[start] += (direction == 1 ? 1 : -1);
            if (end + 1 < n) {
                shift[end + 1] -= (direction == 1 ? 1 : -1);
            }
        }

        int currentShift = 0;
        for (int i = 0; i < n; ++i) {
            currentShift += shift[i];
            shift[i] = currentShift;
        }

        StringBuilder result = new StringBuilder(s);
        for (int i = 0; i < n; ++i) {
            int netShift = (shift[i] % 26 + 26) % 26;
            result.setCharAt(i, (char) ('a' + (s.charAt(i) - 'a' + netShift) % 26));
        }

        return result.toString();
    }

    /// TLE 37/39 passed
    public String shiftingLetters2(String s, int[][] shifts) {
        int n = s.length();
        char arr[] = s.toCharArray();
        for (int row[] : shifts) {
            int si = row[0];
            int ei = row[1];
            int dir = row[2];
            convert(arr, si, ei, dir);
        }
        return new String(arr);
    }

    private void convert(char[] arr, int si, int ei, int dir) {
        if (dir == 1) {
            for (int i = si; i <= ei; i++) {
                arr[i] = (char) ('a' + (arr[i] - 'a' + 1) % 26);
            }
        } else {
            for (int i = si; i <= ei; i++) {
                arr[i] = (char) ((arr[i] - 'a' - 1 + 26) % 26 + 'a');
            }
        }
    }
}
