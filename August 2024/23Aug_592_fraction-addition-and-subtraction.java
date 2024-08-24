import java.util.ArrayList;

class Solution2 {
    // Fails some test cases
    public String fractionAddition(String exp) {
        char op = '+';
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '+' || ch == '-') {
                op = ch;
            } else if (ch == '/') {
                int num = exp.charAt(i - 1) - '0';
                int deno = exp.charAt(i + 1) - '0';

                if (op == '-') {
                    num = num * (-1);
                    op = '+';
                }

                list.add(num);
                list.add(deno);
                i++;
            }
        }

        while (list.size() != 2) {
            int num1 = list.get(0);
            int deno1 = list.get(1);
            Pair p1 = new Pair(num1, deno1);

            int num2 = list.get(2);
            int deno2 = list.get(3);
            Pair p2 = new Pair(num2, deno2);

            list.remove(0);
            list.remove(0);
            list.remove(0);
            list.remove(0);

            Pair temp = p1.add(p2);
            list.add(0, temp.num);
            list.add(1, temp.deno);

        }

        System.out.print(list);
        int num = list.get(0);
        int deno = list.get(1);
        int sign = 1;
        if (num < 0) {
            sign = -1;
            num *= -1;
        }
        if (deno < 0) {
            sign *= -1;
            deno *= -1;
        }

        return sign * num + "/" + deno;
    }

    class Pair {
        int num;
        int deno;

        Pair(int n, int d) {
            this.num = n;
            this.deno = d;
        }

        public Pair add(Pair other) {

            int n = this.num * other.deno + this.deno * other.num;
            int d = this.deno * other.deno;
            int hcf = getHCF(n, d);
            this.num = n / hcf;
            this.deno = d / hcf;
            return new Pair(num, deno);

        }

        // rec HCF log(n);
        public int getHCF(int a, int b) {
            if (a == 0)
                return b;
            if (b == 0)
                return a;
            return getHCF(b % a, a);
        }
    }
}

// Correct Mehthod
class Solution1 {
    public String fractionAddition(String exp) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = exp.length();
        int i = 0;

        while (i < n) {
            int sign = 1;
            if (exp.charAt(i) == '+' || exp.charAt(i) == '-') {
                if (exp.charAt(i) == '-') {
                    sign = -1;
                }
                i++;
            }

            // Extract numerator
            int num = 0;
            while (i < n && Character.isDigit(exp.charAt(i))) {
                num = num * 10 + (exp.charAt(i) - '0');
                i++;
            }
            num *= sign;

            // Skip '/'
            i++;

            // Extract denominator
            int deno = 0;
            while (i < n && Character.isDigit(exp.charAt(i))) {
                deno = deno * 10 + (exp.charAt(i) - '0');
                i++;
            }

            // Add numerator and denominator to list
            list.add(num);
            list.add(deno);
        }
        while (list.size() != 2) {
            int num1 = list.get(0);
            int deno1 = list.get(1);
            Pair p1 = new Pair(num1, deno1);

            int num2 = list.get(2);
            int deno2 = list.get(3);
            Pair p2 = new Pair(num2, deno2);

            list.remove(0);
            list.remove(0);
            list.remove(0);
            list.remove(0);

            Pair temp = p1.add(p2);
            list.add(0, temp.num);
            list.add(1, temp.deno);

        }

        System.out.print(list);
        int num = list.get(0);
        int deno = list.get(1);
        int sign = 1;
        if (num < 0) {
            sign = -1;
            num *= -1;
        }
        if (deno < 0) {
            sign *= -1;
            deno *= -1;
        }

        return sign * num + "/" + deno;
    }

    class Pair {
        int num;
        int deno;

        Pair(int n, int d) {
            this.num = n;
            this.deno = d;
        }

        public Pair add(Pair other) {

            int n = this.num * other.deno + this.deno * other.num;
            int d = this.deno * other.deno;
            int hcf = getHCF(n, d);
            this.num = n / hcf;
            this.deno = d / hcf;
            return new Pair(num, deno);

        }

        // rec HCF log(n);
        public int getHCF(int a, int b) {
            if (a == 0)
                return b;
            if (b == 0)
                return a;
            return getHCF(b % a, a);
        }
    }
}

// 3rd Methods shorts
class Solution {

    public String fractionAddition(String expression) {
        int num = 0;
        int denom = 1;

        // separate expression into signed numbers
        String[] nums = expression.split("/|(?=[-+])");

        for (int i = 0; i < nums.length; i += 2) {
            int currNum = Integer.valueOf(nums[i]);
            int currDenom = Integer.valueOf(nums[i + 1]);

            num = num * currDenom + currNum * denom;
            denom = denom * currDenom;
        }

        int gcd = Math.abs(FindGCD(num, denom));

        num /= gcd;
        denom /= gcd;

        return num + "/" + denom;
    }

    private int FindGCD(int a, int b) {
        if (a == 0)
            return b;
        return FindGCD(b % a, a);
    }
}