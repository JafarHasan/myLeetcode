package Greedy;

class Solution {

    // Greedy Approach 0ms 100% beats best solution
    
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        int cntA = 0, cntB = 0, cntC = 0;
        int total = a + b + c;

        for (int i = 0; i < total; i++) {
            // if a is max freq
            if ((a >= b && a >= c && cntA < 2) || (cntB == 2 && a > 0) || (cntC == 2 && a > 0)) {
                // append char a
                sb.append('a');
                // keep counting to chek freq remain<=2
                cntA++;
                // decrease the total freq of a
                a--;
                // can add b,c 2 time so set its counter to 0
                cntB = 0;
                cntC = 0;
            } else if ((b >= a && b >= c && cntB < 2) || (cntA == 2 && b > 0) || (cntC == 2 && b > 0)) {
                // append char b
                sb.append('b');
                // keep counting to chek freq remain<=2
                cntB++;
                // decrease the total freq of b
                b--;
                // can add a,c 2 time, so set its counter to 0
                cntA = 0;
                cntC = 0;
            } else if ((c >= b && c >= a && cntC < 2) || (cntB == 2 && c > 0) || (cntA == 2 && c > 0)) {
                // append char c
                sb.append('c');
                // keep counting to chek freq remain<=2
                cntC++;
                // decrease the total freq of c
                c--;
                // can add b,a 2 time so set its counter to 0
                cntA = 0;
                cntB = 0;
            }

        }
        return sb.toString();

    }
}
