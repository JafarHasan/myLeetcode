class Solution {
    // TC:O(N) SC:O(1)
    public int minOperations(String[] logs) {
        int depth = 0;
        for (String s : logs) {
            if (s.equals("./")) {
                continue;
            } else if (s.equals("../")) {
                depth--;
                if (depth < 0)
                    depth = 0;
            } else {
                depth++;
            }
        }
        return depth;
    }
}