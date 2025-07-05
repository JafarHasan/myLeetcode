
class Solution {

    public char kthCharacter(int k) {

        int position = Integer.bitCount(k - 1);

        return (char) ('a' + position);
    }
}

class Solution_2 {

    public char kthCharacter(int k) {
        String word = "a";
        return helper(word, k);
    }

    public static char helper(String word, int k) {
        if (word.length() >= k) {
            return word.charAt(k - 1);
        }
        int index = 0;
        StringBuilder str = new StringBuilder(word);
        while (index < word.length()) {
            char ch = word.charAt(index);
            str.append((char) (ch + 1));
            index++;
        }
        return helper(str.toString(), k);

    }
}

class Solution_BF {

    //TC:O(N^2) SC:O(N) Pure Brute Force
    public char kthCharacter(int k) {
        StringBuilder s = new StringBuilder("a");
        while (true) {
            System.out.println(s);
            if (s.length() >= k) {
                return s.charAt(k - 1);
            } else {
                StringBuilder temp = s;

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < temp.length(); i++) {
                    if (temp.charAt(i) == 'z') {
                        sb.append('a');
                    } else {
                        sb.append((char) (temp.charAt(i) + 1));
                    }
                }
                s.append(sb);
            }
        }

    }
}
