class Solution {
    // TC:O(N) N=WORD.LENGTH;SC;O(1) CONSTANT SPACE
    public int minimumPushes(String word) {
        // 2 3 4 5 6 7 8 9
        int key[] = new int[10];// 0-9 idx we will use 2-9 idx as 2-9 keys are available
        int idx = 2;// assigning char from 2 key
        int charCnt = 1;
        for (char ch : word.toCharArray()) {
            if (idx > 9) {
                idx = 2;
                charCnt++;
            }
            key[idx] += charCnt;
            idx++;
        }
        int keyPressCnt = 0;
        for (int i = 2; i <= 9; i++) {
            keyPressCnt += key[i];
        }
        return keyPressCnt;


    }
    //2nd method
    public int minimumPushes2(String word) {
        // 2 3 4 5 6 7 8 9
        int key[] = new int[10];// 0-9 idx we will use 2-9 idx as 2-9 keys are available
        int idx = 2;// assigning char from 2 key
         int keyPressCnt = 0;
        for (char ch : word.toCharArray()) {
            if (idx > 9) {
                idx = 2;
            }
            key[idx] ++;
             keyPressCnt+=key[idx];
            idx++;
           
        }
        return keyPressCnt;

    }

    // OPTIMIZATION
    // TC:O(N) SC:O(1)
    public int minimumPushes3(String word) {
        int n = word.length();
        int ans = 0;
        while (n > 0) {
            ans += n;
            n -= 8;
        }
        return ans;
    }
}