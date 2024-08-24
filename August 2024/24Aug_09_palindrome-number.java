class Solution {
    //TC:O(LogN) SC:O(1)
    public boolean isPalindrome(int x) {
        if(x<0) return false;//-ve no is not a palindrome no
        int temp=x;
        int sum=0;
        while(x>0){
            sum=sum*10+(x%10);
            x/=10; //logN TC
        }
        if(sum==temp) return true;
        return false;
    }
}