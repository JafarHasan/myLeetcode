
class Solution {

    //Accepted TC:O(N) SC:O(1) dont consider prefix[] space
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prefix[] = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];

        }
        int mul = 1;
        for (int i = n - 1; i >= 0; i--) {
            prefix[i] = prefix[i] * mul;
            mul *= nums[i];
        }
        return prefix;

    }

    //TC:o(N) SC:O(2N) not allowed
    public int[] productExceptSelf_Using_Prefix_Suffix_Arrays(int[] nums) {
        int n = nums.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }
        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }
        int res[] = new int[n];
        res[0] = suffix[1];
        res[n - 1] = prefix[n - 2];
        for (int i = 1; i < n - 1; i++) {
            res[i] = prefix[i - 1] * suffix[i + 1];
        }
        return res;

    }

    //TC:O(n^2) SC:O(1)
    public int[] productExceptSelf_using_zero_cnt_lessLoop(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        int zero = 0;
        int total = 1;
        for (int ele : nums) {
            if (ele == 0) {
                zero++;
                continue;
            }
            total *= ele;

        }

        //if there is more than one zero
        //everthing is zero
        if (zero > 1) {
            return res; 
        }//if there is only one zero
        else if (zero == 1) {
            for (int i = 0; i < n; i++) {
                res[i] = (nums[i] == 0) ? total : 0;
            }
        } else {
            for (int i = 0; i < n; i++) {
                res[i] = (int) total / nums[i];
            }

        }
        return res;

    }

    //TC:O(n) SC:O(1) Beats 99% But lots of loop and check
    public int[] productExceptSelf_Using_zero_cnt(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        int zero = 0;
        int total = 1;
        for (int ele : nums) {
            if (ele == 0) {
                zero++;
            }

        }

        //if there is more than one zero
        //everthing is zero
        if (zero > 1) {
            return res; 
        }//if there is only one zero
        else if (zero == 1) {
            for (int i = 0; i < n; i++) {
                if (nums[i] != 0) {
                    total *= nums[i];
                }
            }
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    res[i] = total;
                    return res;
                }
            }
        } else {
            total = 1;
            for (int i = 0; i < n; i++) {
                total *= nums[i];
            }
            for (int i = 0; i < n; i++) {
                res[i] = (int) total / nums[i];
            }

        }
        return res;
    }

    //TC:O(n^2) SC:O(1)
    public int[] productExceptSelf_BF(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            int mul = 1;
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    mul *= nums[j];
                }
            }
            res[i] = mul;
        }
        return res;
    }
}
