class Solution {
    // TC:O(NxM) N=length of Sentence,M=length of SearchWord
    // SC:O(N)
    public int isPrefixOfWord(String sentence, String searchWord) {
        String words[] = sentence.split("\\s");
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord))
                return i + 1;
        }
        return -1;
    }
}

class Solution2 {
    // TC:O(NxM) N=length of Sentence,M=length of SearchWord
    // SC:O(N)
    public int isPrefixOfWord(String sentence, String searchWord) {
        String words[] = sentence.split("\\s");
        for (int i = 0; i < words.length; i++) {

            if (containsSuffix(words[i], searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }

    private boolean containsSuffix(String s, String sub) {
        int n = s.length();
        int m = sub.length();
        if (m > n)
            return false;
        int i = 0;
        while (i < Math.min(m, n)) {
            if (s.charAt(i) != sub.charAt(i)) {
                return false;
            }
            i++;
        }
        return i == m;
    }
}
