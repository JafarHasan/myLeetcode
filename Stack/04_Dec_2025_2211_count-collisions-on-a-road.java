class Solution {
    public int countCollisions(String dir) {
        Stack<Character> st = new Stack<>();
        int cnt = 0;
        int i = 0, n = dir.length(), j = n - 1;
        //starting Left moving car wil never collide
        while (i < n && dir.charAt(i) == 'L')
            i++;
        //ending right moving car wil never collide
        while (j >= 0 && dir.charAt(j) == 'R')
            j--;
        int collision = 0;
        while (i <= j) {
            //either L or R
            if (dir.charAt(i) != 'S') {
                collision++;
            }
            i++;
        }
        return collision;

    }
}