package StringQuestions;

class Solution {
    // TC:O(N) SC:O(1)
    public int closetTarget(String[] words, String target, int startIdx) {
        int n = words.length;
        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int dis = Math.abs(startIdx - i);
                int oppDis = n - dis;
                minDis = Math.min(minDis, Math.min(dis, oppDis));
            }

        }
        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }
}

class Solution2 { // Failed in some test cases
    public int closetTarget(String[] words, String target, int startIdx) {
        int left = -1;
        int right = -1;
        int n = words.length;
        int minDis = 0;

        // searching left
        int dis = 0;
        for (int i = startIdx; i < n; i++) {
            if (words[i % n].equals(target)) {
                left = dis;
                break;
            }
            dis++;

        }
        // searching right
        dis = 0;
        int j = startIdx;
        for (int i = 0; i < n; i++) {
            if (j == -1) {
                j = n - 1;
            }
            if (words[j].equals(target)) {
                right = dis;
                break;
            }
            j--;
            dis++;
        }
        if (left == -1 && right == -1)
            return -1;
        else if (left == -1)
            return right;
        else if (right == -1)
            return left;
        else
            return Math.min(left, right);
    }
}