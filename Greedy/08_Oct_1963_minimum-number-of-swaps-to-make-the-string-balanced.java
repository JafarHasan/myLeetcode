package Greedy;

import java.util.*;

class Solution {
    // Using Two Pointer Greedy TC;O(N) SC:O(1) 13ms BEst
    public int minSwaps(String s) {
        int n = s.length();
        int swap = 0;
        int open = 0;
        for (char ch : s.toCharArray()) {
            // cnt Open [
            if (ch == '[') {
                open++;
            } else {// ch==']'
                if (open > 0) {
                    // its a balanced
                    open--;
                } else {
                    // one swap needed
                    swap++;
                    open++;
                }
            }
        }
        return swap;
    }
}

/**
 * Observation 1: If we are left with a string of length n in stack
 * then,no of swaps needed:
 * n=2 : 1 swap
 * n=4 : 1 swap
 * n=6 : 2 swap
 * n=8 : 2 swap
 * n=10 : 3 swap
 * ((n/2)+1)/2
 * and so on.
 */
class Solution1 {
    // Using STACK TC;O(N) SC:O(N) 122ms
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        int swap = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                st.push(ch);
            } else {// ch==']'
                if (!st.isEmpty() && st.peek() == '[') {
                    // it will be valid pair just remove it
                    st.pop();
                } else {
                    st.push(ch);
                }
            }
        }
        swap = st.size() / 2;
        return (swap + 1) / 2;
    }
}
