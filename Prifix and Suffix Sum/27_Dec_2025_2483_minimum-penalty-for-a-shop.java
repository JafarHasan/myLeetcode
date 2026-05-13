class Solution {
    //TC:O(N) SC:O(1)
    public int bestClosingTime(String customers) {
        int maxScore = 0, score = 0, rightTime = -1;
        for (int i = 0; i < customers.length(); i++) {
            score += (customers.charAt(i) == 'Y') ? 1 : -1;
            if (score > maxScore) {
                maxScore = score;
                rightTime = i;
            }
        }
        return rightTime + 1;
    }
}

class Solution_Bf {
    //SC:O(2N+2)->O(N)
    //TC:O(N)
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] prefix = new int[n + 1];
        int[] suffix = new int[n + 1];
        // prefix[0] = customers.charAt(0) == 'N' ? 1 : 0;
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1];
            if (customers.charAt(i - 1) == 'N') {
                prefix[i]++;
            }
        }
        // suffix[n - 1] = customers.charAt(n - 1) == 'Y' ? 1 : 0;
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1];
            if (customers.charAt(i) == 'Y') {
                suffix[i]++;
            }
        }
        for (int ele : prefix)
            System.out.print(ele + " ");

        System.out.println();
        for (int ele : suffix)
            System.out.print(ele + " ");
        int minPa = n + 1;
        int idx = 0;
        for (int i = 0; i <= n; i++) {
            if (minPa > (prefix[i] + suffix[i])) {
                minPa = prefix[i] + suffix[i];
                idx = i;
            }
        }
        return idx;
    }
}