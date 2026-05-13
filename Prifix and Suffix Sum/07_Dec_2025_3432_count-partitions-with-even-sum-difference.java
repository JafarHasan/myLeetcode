
class Solution {

    public int countPartitions(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        return sum % 2 == 0 ? n - 1 : 0;
    }
}

class Solution_Using_Prefix {

    public int countPartitions(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];//SC:O(N)
        prefix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            prefix[i] = prefix[i + 1] + nums[i];
        }
        int sum = 0;
        ;
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += nums[i];
            if ((sum - prefix[i + 1]) % 2 == 0) {
                cnt++;
            }
        }
        return cnt;

    }
}
