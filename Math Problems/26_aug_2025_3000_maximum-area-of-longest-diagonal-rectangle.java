
class Solution {

    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = 0;
        int maxDia = 0;
        int n = dimensions.length;
        for (int i = 0; i < n; i++) {
            int l = dimensions[i][0];
            int b = dimensions[i][1];

            int currDia = l * l + b * b;
            int currArea = l * b;

            if (currDia > maxDia || (currDia == maxDia && currArea > maxArea)) {
                maxArea = currArea;
                maxDia = currDia;
            }
        }

        return maxArea;
    }
}

class Solution2 {

    public int areaOfMaxDiagonal(int[][] di) {
        int maxArea = 0;
        int dig = 0;
        for (int i = 0; i < di.length; i++) {
            int width = di[i][0];
            int length = di[i][1];
            int currDig = (int) Math.sqrt(Math.pow(width, 2) + Math.pow(length, 2));
            if (currDig > dig) {
                dig = currDig;
                maxArea = Math.max(maxArea, length * width);
            }

        }
        return maxArea;
    }
}
