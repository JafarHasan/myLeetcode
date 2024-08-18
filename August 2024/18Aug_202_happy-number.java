import java.util.HashSet;

class Solution {
    private final int arr[] = { 0, 1, 4, 9, 16, 25, 36, 49, 64, 81 };

    public int squareSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += arr[n % 10];
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int temp = n;
        while (temp > 1) {
            if (set.contains(temp))
                return false;
            set.add(temp);
            temp = squareSum(temp);

        }
        return temp == 1;

    }
}