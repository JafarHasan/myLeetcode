class Solution {
    // SC:O(n) SC:O(k*n) n=s.length();
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            int no = (ch - 'a' + 1);
            sb.append(no);
        }

        while (k-- > 0) {
            int temp = 0;
            for (int digit : sb.toString().toCharArray()) {
                temp += (digit - '0');
            }
            sb = new StringBuilder(String.valueOf(temp));
        }

        return Integer.parseInt(sb.toString());
    }
}

// Fast Solution
class Solution2 {
    public int getLucky(String s, int k) {
        int sum = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int temp = s.charAt(i) - 96;
            while (temp > 0) {
                int rem = temp % 10;
                sum += rem;
                temp /= 10;
            }
        }
        k--;
        int num = sum;
        while (k > 0) {
            sum = 0;
            int temp = num;
            while (temp > 0) {
                int rem = temp % 10;
                sum += rem;
                temp /= 10;
            }
            num = sum;
            k--;
        }
        return sum;
    }
}