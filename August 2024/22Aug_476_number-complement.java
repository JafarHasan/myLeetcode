class Solution2 {
    // TC:O(N) SC:O(N)
    public StringBuilder decimalToBinary(int num) {
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            int binary = num % 2;
            sb.insert(0, binary);
            num /= 2;
        }
        return sb;
    }

    public StringBuilder flipBits(StringBuilder s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                sb.append(1);
            } else {
                sb.append('0');
            }
        }
        return sb;
    }

    public int convertBinaryToDecimal(StringBuilder sb) {
        int num = 0;
        int pow = 0;
        for (int i = sb.length() - 1; i >= 0; i--) {
            char ch = sb.charAt(i);
            if (ch != '0') {
                num += Math.pow(2, pow);
            }

            pow++;

        }
        return num;

    }

    public int findComplement(int num) {

        // 1.convert given no to binary
        StringBuilder sb = decimalToBinary(num);

        // 2.flips all 0 to 1 and all 1 to 0
        sb = flipBits(sb);

        // convert the binary no to decimal again
        int ans = convertBinaryToDecimal(sb);

        return ans;
    }
}

// Optimize one TC:O(1) SC:O(1) BIT MANIPULATION

class Solution {
    public int findComplement(int num) {

        // convert num to binary(it will be a string)
        int length = Integer.toBinaryString(num).length();

        // shift one l time to get one at the starting
        int mask = (1 << length) - 1; // -1 to get all 111 equal to length

        // Xor all
        return mask ^ num;

    }
}

/*
 * Note:
 * 
 * This question
 * is the
 * same as 1009:
 * https:leetcode.com/problems/complement-of-base-10-integer/
 */