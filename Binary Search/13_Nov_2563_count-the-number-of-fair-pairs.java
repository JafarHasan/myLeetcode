class Solution {
    //Beats 100%
    long countLess(int[] nums, int val) {
        long res = 0;
        for (int i = 0, j = nums.length - 1; i < j; ++i) {
            while (i < j && nums[i] + nums[j] > val)
                --j;
            res += j - i;
        }
        return res;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countLess(nums, upper) - countLess(nums, lower - 1);
    }
}

class Solution2 {
    // passed TC:O(NLogN) SC:O(1) using BS
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        long cnt = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int left = lowerBound(nums, i + 1, n - 1, lower - nums[i]);
            int right = upperBound(nums, i + 1, n - 1, upper - nums[i]);
            cnt += (right - left + 1);
        }
        return cnt;
    }

    private int lowerBound(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return start;
    }

    private int upperBound(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return end;
    }
}

class Solution3 {
    // Brute Force 47//54 passed TC:O(N^2) SC:O(1)
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                if (lower <= sum && sum <= upper) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}