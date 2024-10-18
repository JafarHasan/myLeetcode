package Greedy;

class Solution {
    // TC:O(N) SC:O(N) Greedy
    public int maximumSwap(int num) {
        String s = Integer.toString(num);
        int n = s.length();
        int arr[] = new int[s.length()];
        int idx = 0;
        // making array from string
        for (char ch : s.toCharArray()) {
            arr[idx++] = ch - '0';
        }
        // find the right max elements and keep track of indices
        int right[] = new int[n];
        right[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            int rightMaxIdx = right[i + 1];
            if (arr[i] > arr[rightMaxIdx]) {
                right[i] = i;
            } else {
                right[i] = rightMaxIdx;
            }
        }

        for (int i = 0; i < n; i++) {

            if (arr[i] < arr[right[i]]) { // swap with max element and break
                int rightMaxIdx = right[i];
                int temp = arr[i];
                arr[i] = arr[rightMaxIdx];
                arr[rightMaxIdx] = temp;
                break;
            }
        }

        // Iterate through the array and construct the number
        int number = 0;
        for (int i = 0; i < arr.length; i++) {
            number = number * 10 + arr[i];
        }
        return number;

    }
}

/**
 * test cases
 * 115
 * 1993
 * 10909091
 */
// BF but Failed 93/112
class Solution2 {
    public int maximumSwap(int num) {
        // StringBuilder sb=new StringBuilder(num);

        String s = Integer.toString(num);
        int arr[] = new int[s.length()];
        int idx = 0;
        for (char ch : s.toCharArray()) {
            arr[idx++] = ch - '0';
        }
        int max = 0, idx1 = 0, idx2 = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (arr[i + 1] >= arr[i]) {
                idx1 = i;
                int j = i + 1;
                while (j < s.length()) {
                    if (arr[j] >= max) {
                        idx2 = j;
                        max = arr[j];
                    }
                    j++;
                }
                break;
            }

        }
        // swap
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
        // Initialize the result as 0
        int number = 0;

        // Iterate through the array and construct the number
        for (int i = 0; i < arr.length; i++) {
            number = number * 10 + arr[i];
        }
        return number;

    }
}
/**
 * test cases
 * 115
 * 1993
 * 10909091
 */