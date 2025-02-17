
import java.util.*;

class Solution {

    //group all those number whose sum of digits are same 
    //<9,{45,63,90}> in map
    private int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public int maximumSum(int[] nums) {
        int n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int digit = sumOfDigits(nums[i]);
            if (map.containsKey(digit)) {
                map.get(digit).add(nums[i]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                map.put(digit, list);
            }
        }
        int result = 0;
        for (int key : map.keySet()) {
            if (map.get(key).size() < 2) {
                continue;
            } else {
                List<Integer> list = map.get(key);
                int size = list.size();
                Collections.sort(list);
                result = Math.max(result, list.get(size - 1) + list.get(size - 2));
            }
        }
        return result == 0 ? -1 : result;

    }
}

class SolutionBruteForce {

    // O(Nx(log(no of digits in greatest no)+O(N^2)
    // TLE 71/83 SC:O(N)
    private int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public int maximumSum(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = sumOfDigits(nums[i]);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && ans[i] == ans[j]) {
                    result = Math.max(result, nums[i] + nums[j]);
                }
            }
        }
        return result == 0 ? -1 : result;
    }
}
