class Solution {
    
    // TC:o(N) SC:O(1)
   
     public boolean repeatedSubstringPattern(String s) {
        String temp=s+s;
         return temp.substring(1,temp.length()-1).contains(s);
     }
 }
 class Solution2 {
     
     //Brute Force TC:O(N^3) SC:O(N)
     private boolean check(String sb,StringBuilder s){
         while(s.indexOf(sb)!=-1){
             int idx=s.indexOf(sb);
             s.delete(idx,idx+sb.length());
         }
         return s.length()==0;
     }
     public boolean repeatedSubstringPattern(String s) {
         int n=s.length();
         for(int i=0;i<n/2;i++){
             for(int j=i+1;j<n;j++){
                 if(check(s.substring(i,j),new StringBuilder(s))){
                     return true;
                 }
             }
         }
         return false;
     }
 }