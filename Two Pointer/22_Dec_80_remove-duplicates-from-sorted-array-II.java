
class Solution_best {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length; // if size ≤ 2, no need to modify

        int k = 2;  // start from 3rd position (since first two are always allowed)

        for (int i = 2; i < nums.length; i++) {
            // Compare current num with the element two places before in the valid portion
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
class Solution_One {
    public int removeDuplicates(int[] nums) {
        int j = 0, k = 1;
        for (int i = 2; i < nums.length; i++) {
            //already same
            if (nums[j] == nums[k] && nums[k] == nums[i])
                continue;

            j = k;
            k++;
            nums[k] = nums[i];
            
        }
        return k + 1;
    }
}
class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (j == 1 || nums[i] != nums[j - 2]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if (n <= 2)
            return n;
        int i = 1, idx = 1;
        int dup = 1;
        while (i < n) {
            if (nums[i] == nums[i - 1]) {
                dup++;
            } else {
                dup = 1;
            }
            if (dup < 3) {
                nums[idx++] = nums[i];
            }
            i++;
        }
        return idx;

    }
}