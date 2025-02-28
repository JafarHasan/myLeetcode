class Solution {
    private final int mod = 1000000007;

    // TC:O(N) SC:O(1)
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int cnt = 0;
        int sum = 0;
        int evenSum = 1, oddSum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum % 2 == 0) {
                 evenSum++;
                cnt += oddSum;
            } else {
                oddSum++;
                cnt += evenSum;
                
                
            }
            cnt %= mod;
        }

        return cnt;
    }

    // TC:O(N^2) SC:O(1) 139/151 passed
    public int numOfSubarrays_Bf(int[] arr) {
        int n = arr.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum % 2 != 0) {
                    cnt++;
                }

            }
        }
        return cnt;
    }

    // TC:O(N^3) SC:O(1) Pure BF 102/151 passed
    public int numOfSubarrays_Pure_Bf(int[] arr) {
        int n = arr.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum % 2 != 0) {
                    cnt++;
                }

            }
        }
        return cnt;
    }
}