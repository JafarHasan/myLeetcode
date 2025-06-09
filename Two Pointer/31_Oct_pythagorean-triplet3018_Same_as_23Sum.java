
import java.util.*;

class Solution {

    boolean pythagoreanTriplet(int[] arr) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;

        for (int i = 2; i < n; i++) {
            int c = arr[i];
            int left = 0;
            int right = i - 1;
            while (left < right) {
                int a = arr[left];
                int b = arr[right];

                if (a * a + b * b == c * c) {
                    return true;
                } else if (a * a + b * b < c * c) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false;

    }
}
