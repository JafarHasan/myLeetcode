
class Solution {

    // TC O(1)SC:O(1)
    // n=0 colored_cell=0;
    //  n=1 colored_cell=1;
    //   n=2 colored_cell=5; n^2+(n-1)^2
    //    n=3 colored_cell=13;
    //     n=4 colored_cell=25;
    //     formula n^2+(n-1)^2
    public long coloredCells(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return (long) Math.pow(n, 2) + (long) Math.pow((n - 1), 2);

    }
}
