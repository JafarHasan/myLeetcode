class Solution {
    public int findMaximum(int[] arr) {
        // code here
        if(arr[0]>arr[1])return arr[0];
        for(int i=1;i<arr.length-1;i++){
            if(arr[i-1]<arr[i] && arr[i]>arr[i+1])return arr[i];
        }
        return arr[arr.length-1];
        
    }
}s