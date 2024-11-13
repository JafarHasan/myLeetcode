package StringQuestions;

class Solution {
    // TC:O(N)SC:O(N)
    public boolean isCircularSentence(String sentence) {
        // checking first and last char
        if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1))
            return false;
        String[] sen = sentence.split(" ");
        for (int i = 0; i < sen.length - 1; i++) {
            if (sen[i].charAt(sen[i].length() - 1) != sen[i + 1].charAt(0))
                return false;
        }

        return true;
    }
}

class Solution2 {
    // TC:O(N)SC:O(N)
    public boolean isCircularSentence(String sentence) {
        String[] sen = sentence.split(" ");
        String s = sen[0];
        char last = s.charAt(s.length() - 1);
        for (int i = 1; i < sen.length; i++) {
            s = sen[i];
            char currFirst = s.charAt(0);
            char currLast = s.charAt(s.length() - 1);
            if (last != currFirst)
                return false;
            last = currLast;
        }
        // checking last String last char ==to first String first char
        String a = sen[0];
        String b = sen[sen.length - 1];
        if (a.charAt(0) != b.charAt(b.length() - 1))
            return false;
        return true;
    }
}
