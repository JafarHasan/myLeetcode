
class Solution {

    // beats 100% 2ms TC:O(N) SC:O(3*N)->o(N)
    /*
     * s=001011
     * char arr= [0,0,1,0,1,1];
     * cumSumL of 1=[0,0,1,1,2,3]; prefix=[0,0,1,2,4,7];
     * cumSumR of 1=[3,3,3,2,2,1]; suffix=[14,11,8,5,3,1]
     * ans[]=prefix[i+1]+suffix[i-1];
     */
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        if (n == 1) {
            return new int[]{0};
        }
        char arr[] = boxes.toCharArray();
        int cumSumL[] = new int[n];
        int one = 0;
        // left to right
        for (int i = 0; i < n; i++) {
            if (arr[i] == '1') {
                one++;
            }
            cumSumL[i] = one;
        }

        int cumSumR[] = new int[n];
        // right to left
        one = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == '1') {
                one++;
            }
            cumSumR[i] = one;
        }

        // prefix of cumSumL
        for (int i = 1; i < n; i++) {
            cumSumL[i] += cumSumL[i - 1];
        }
        // for(int ele:cumSumL){
        // System.out.print(ele+",");
        // }
        for (int i = n - 2; i >= 0; i--) {
            cumSumR[i] += cumSumR[i + 1];
        }

        int[] ans = new int[n];
        ans[0] = cumSumR[1];
        ans[n - 1] = cumSumL[n - 2];
        for (int i = 1; i < n - 1; i++) {
            ans[i] = cumSumL[i - 1] + cumSumR[i + 1];
        }
        return ans;

    }

    // TC:O(n*cnt1) sc:O(N) BF
    public int[] minOperations1(String boxes) {
        int n = boxes.length();
        char arr[] = boxes.toCharArray();
        // store the indices of 1
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == '1') {
                cnt1++;
            }
        }
        int idx[] = new int[cnt1];
        int index = 0;
        // store the indixes of all ones
        for (int i = 0; i < n; i++) {
            if (arr[i] == '1') {
                idx[index++] = i;
            }
        }
        int cnt = 0;
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            cnt = 0;
            for (int j = 0; j < cnt1; j++) {
                cnt += Math.abs(idx[j] - i);
            }
            ans[i] = cnt;
        }
        return ans;
    }

    // TC:O(n^2) sc:O(N) BF
    public int[] minOperations2(String boxes) {
        int n = boxes.length();
        char arr[] = boxes.toCharArray();
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == '0') {
                    continue;
                } // if(arr[j]=='1'){
                else {
                    cnt += Math.abs(j - i);
                }
            }
            ans[i] = cnt;
        }
        return ans;
    }
}
