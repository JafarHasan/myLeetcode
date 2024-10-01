import java.util.*;

class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;
        int remCnt[] = new int[k]; // will work as a HashMap
        for (int ele : arr) {
            int rem = ((ele % k) + k) % k; // Ensure the remainder is non-negative
            remCnt[rem]++;

        }
        // Check for remainder 0 exp 5 10 both will rem 0 when k=5
        if (remCnt[0] % 2 != 0) {
            return false; // Remainder 0 must have an even count
        }
        // check Pair also 1+4 and 2+3 for 5 1 idx rem should be equal to 4idx rem and
        // same in 2 3
        for (int i = 1; i <= k / 2; i++) {
            if (remCnt[i] != remCnt[k - i]) {
                return false;
            }
        }
        return true;

    }
}

// Using HashMap 36ms
class Solution3 {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            int rem = ((num % k) + k) % k;// avoiding -ve rem
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        // neutralize:
        for (int rem : map.keySet()) {
            if (rem == 0) {
                if (map.get(rem) % 2 != 0) {
                    return false;
                }

            } else if (!map.get(rem).equals(map.get(k - rem))) {
                return false;
            }
        }
        return true;
    }
}

class Solution2 {
    // TC:O(N^2) SC:O(1) Brute Force but fail
    /**
     * arr =
     * [-10,10]
     * k =2
     * Output
     * false
     * Expected
     * true
     */
    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (((arr[i] + arr[j]) >= 0) && (arr[i] + arr[j]) % k >= 0) {
                    System.out.print("( " + arr[i] + "," + arr[j] + ")" + ",");
                    cnt++;
                    if (cnt == n / 2)
                        return true;
                }
            }
        }
        System.out.println(cnt);
        return false;
    }
}