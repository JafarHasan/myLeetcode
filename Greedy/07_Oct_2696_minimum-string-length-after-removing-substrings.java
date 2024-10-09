package Greedy;

import java.util.*;

class Solution {
    // Greedy Approach
    // TC:O(N) SC:O(N) for char[] 2ms
    public int minLength(String s) {
        int n = s.length();
        char[] st = new char[n + 1];
        int lastIdx = -1;
        for (char ch : s.toCharArray()) {
            if (lastIdx > -1 && ch == 'B' && st[lastIdx] == 'A') {
                lastIdx--;
            } else if (lastIdx > -1 && ch == 'D' && st[lastIdx] == 'C') {
                lastIdx--;
            } else {
                lastIdx++;
                st[lastIdx] = ch;
            }
        }
        return lastIdx + 1;
    }

}

class Solution1 {
    /*
     * Why STACK check string FCACDBD we need to target last element
     * remove CD we got FCABD
     * remove AB w got FCD
     * remove CD we got F now we cant remove anything
     * return length i.e 1
     */
    // TC:O(N) SC:O(N) for Stack 4ms
    public int minLength(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // if curr ele is B and curr prev ele is A so we found one AB just remove prev A
            if (ch == 'B' && !st.isEmpty() && st.peek() == 'A') {
                st.pop();
            }
            // if curr ele is D and curr prev ele is C so we found one CD just remove prev C
            else if (ch == 'D' && !st.isEmpty() && st.peek() == 'C') {
                st.pop();
            }
            // any other char push into the stack
            else {
                st.push(ch);
            }
        }
        return st.size();
    }
}
