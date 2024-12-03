import java.util.Stack;

class Solution {
    // TC:O(N*max freq) n=length of string s
    // SC:O(N)
    class Pair {
        char ch;
        int freq;

        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            // if a char is already present on top increase its freq by 1
            if (!st.isEmpty() && ch == st.peek().ch) {
                int freq = st.pop().freq;
                st.push(new Pair(ch, freq + 1));
                // else add a new char with freq 1
            } else {
                st.push(new Pair(ch, 1));
            }
            // if we have the same freq char=k on top delete it
            if (!st.isEmpty() && ch == st.peek().ch && st.peek().freq == k) {
                st.pop();
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            Pair temp = st.pop();
            char ch = temp.ch;
            int freq = temp.freq;
            while (freq-- > 0) {
                sb.append(ch);
            }
        }
        return sb.reverse().toString();
    }
}