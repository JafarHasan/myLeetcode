
class Solution {
    public int[][] transpose(int[][] matrix) {
        //transpose Matrix
        int n=matrix.length;
        int m=matrix[0].length;
        int result[][]=new int[m][n];//change dimensions n,m to m ,n
        //iterate for new mXn matrix
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result[i][j]=matrix[j][i];
            }
        }
        return result;
    }
}