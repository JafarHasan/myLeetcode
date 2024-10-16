package StringQuestions;

class Solution {
    private static void printTime(String s) {
        for (int i = 2; i <= 7; i++) {
            System.out.print(s.charAt(i));
        }
    }

    static void timeConversion(String s) {
        // get hrs
        int h1 = s.charAt(0) - '0';
        int h2 = s.charAt(1) - '0';
        int hh = (h1 * 10 + h2 % 10);
        if (s.charAt(8) == 'A') {
            if (hh == 12) {
                System.out.print("00");
                printTime(s);
            } else {
                // pint as it is
                for (int i = 0; i <= 7; i++) {
                    System.out.print(s.charAt(i));
                }
            }
        }
        // if time is in PM
        else {
            if (hh == 12) {
                System.out.print("12");
            } else {
                hh = hh + 12;
                System.out.print(hh);
            }
            printTime(s);
        }
    }
}