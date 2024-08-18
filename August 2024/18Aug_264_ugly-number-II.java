class Solution {
    public boolean isUgly(int n) {
        if (n == 1)
            return true;

        while (n % 2 == 0)
            n = n / 2;
        while (n % 3 == 0)
            n = n / 3;
        while (n % 5 == 0)
            n = n / 5;
        return n == 1;
    }

    // TLE 500/593 test passes
    public int nthUglyNumber2(int n) {
        if (n == 1)
            return 1;
        int nThUglyNo = 1;
        int cnt = 0;
        int i = 1;
        while (cnt < n) {
            if (isUgly(i)) {
                nThUglyNo = i;
                cnt++;
            }
            i++;

        }
        return nThUglyNo;
    }

    public int nthUglyNumber(int n) {
        int arr[] = new int[n + 1];
        int i2 = 1;
        int i3 = 1;
        int i5 = 1;// pointing to first Ugly no 1
        arr[1] = 1;// first ugly no is 1
        for (int i = 2; i <= n; i++) {
            int i2Next = arr[i2] * 2;
            int i3Next = arr[i3] * 3;
            int i5Next = arr[i5] * 5;

            int minUglyno = Math.min(i2Next, Math.min(i3Next, i5Next));
            arr[i] = minUglyno;
            if (minUglyno == i2Next)
                i2++;
            if (minUglyno == i3Next)
                i3++;
            if (minUglyno == i5Next)
                i5++;

        }
        return arr[n];// last element
    }

}