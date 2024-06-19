class Solution {
    // TC:O(sqrt(c)) SC:(N)
    // public boolean judgeSquareSum(int c) {
    // HashSet<Integer> set = new HashSet<>();
    // int high=(int)Math.sqrt(c);
    // for (int i = 0; i <= high; i++) {
    // set.add(i*i);
    // }
    // for(int i=0;i<=high;i++){
    // int want=c-(i*i);
    // if(set.contains(want)){
    // return true;
    // }
    // }
    // return false;
    // }
    // two pointer TC:O(SQRT(C)) SC:O(1)
    public boolean judgeSquareSum(int c) {
        if (c < 0)
            return false;
        long lo = 0, hi = (long) Math.sqrt(c);
        while (lo <= hi) {
            long sum = lo * lo + hi * hi;
            if (sum == c)
                return true;
            else if (sum < c)
                lo++;
            else
                hi--;
        }
        return false;
    }
}
