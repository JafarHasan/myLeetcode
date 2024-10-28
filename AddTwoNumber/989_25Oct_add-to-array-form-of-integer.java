package AddTwoNumber;

import java.util.*;
import java.util.Collections;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new LinkedList<>();
        int carry = k, sum = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            sum = num[i] + carry;
            result.add(0, sum % 10);
            carry = sum / 10;
        }

        if (carry != 0) {
            while (carry > 0) {
                result.addFirst(carry % 10);
                carry /= 10;
            }
        }

        return result;
    }
}

class Solution2 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ansList = new ArrayList<>();
        int val1 = 0;
        int val2 = 0;
        int sum = 0, c = 0;
        int i = num.length - 1;
        while (i >= 0 || k > 0) {
            val1 = (i >= 0) ? num[i] : 0;
            val2 = (k > 0) ? k % 10 : 0;
            k /= 10;
            i--;
            sum = val1 + val2 + c;
            if (sum > 9) {
                c = 1;
                sum %= 10;
            } else {
                c = 0;
            }
            ansList.add(0, sum);
        }
        if (c == 1) {
            ansList.add(0, c);
            c = 0;
        }
        return ansList;

    }
}