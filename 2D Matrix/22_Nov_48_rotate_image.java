class Solution {
    //TC:O(NxM) SC:O(1)
    private void reverseRow(int[]arr){
        int n=arr.length;
        int left=0;
        int right=n-1;
        while(left<right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
    public void rotate(int[][] matrix) {
        //transpose Matrix
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=i;j<m;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //reverse Image
        for(int[] row:matrix){
            reverseRow(row);
        }
        
    }
}