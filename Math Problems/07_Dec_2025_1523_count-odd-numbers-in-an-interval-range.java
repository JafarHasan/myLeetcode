class Solution {
    //TLE
    public int countOdds(int low, int high) {
        int N = high - low + 1;
        //if even No of elements even==odd
        if (N % 2 == 0)
            return N / 2;
        //add No of elements
        else {
            //if starting with even No then 
            if (low % 2 == 0) {
                return N / 2;
                //if starting with an odd No
            } else if (low % 2 == 1) {
                return N / 2 + 1;
            }
        }
        return 0;
    }
}

class Solution_BF {
    //TLE
    public int countOdds(int low, int high) {
        int ans = 0;
        for (int i = low; i <= high; i++) {
            if (i % 2 == 1)
                ans++;
        }
        return ans;
    }
}