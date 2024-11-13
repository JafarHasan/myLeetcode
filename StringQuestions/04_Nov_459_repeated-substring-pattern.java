class Solution {
    
    // TC:o(N) SC:O(1)
   
     public boolean repeatedSubstringPattern(String s) {
        String temp=s+s;
         return temp.substring(1,temp.length()-1).contains(s);
     }
 }
 class Solution2 {
    //TC:O(N^2) SC:O(N)
    public boolean repeatedSubstringPattern(String s) {
         int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                String substring = s.substring(0, i);
                StringBuilder repeated = new StringBuilder();
                for (int j = 0; j < n / i; j++) {
                    repeated.append(substring);
                }
                if (repeated.toString().equals(s)) return true;
            }
        }
        return false;
    }
}
 class Solution3 {
     
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