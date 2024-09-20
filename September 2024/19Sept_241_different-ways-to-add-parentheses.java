class Solution {
    //calling recursion two times in for loop of n size
    //TC:O(N*2^N) SC:O(N) stack
    private List<Integer> solve(String exp){
        List<Integer> ans=new ArrayList<>();
        int n=exp.length();
        for(int i=0;i<n;i++){
            char ch=exp.charAt(i);
            if(ch=='+'|| ch=='-'|| ch=='*'){
                List<Integer> left_result=solve(exp.substring(0,i));//left subsbtring from i
                List<Integer> right_result=solve(exp.substring(i+1));//right substring from i+1 
                //on ith char is operator
                for(int x:left_result){
                    for(int y:right_result){
                        if(ch=='+'){
                            ans.add(x+y);
                        }
                        else if(ch=='-'){
                            ans.add(x-y);
                        }
                        else if(ch=='*'){
                            ans.add(x*y);
                        }    
                    }
                }
            }
        }
        //there was no operator in a String exp i.e exp=123
        if(ans.size()==0)
            ans.add(Integer.parseInt(exp));
        return ans;
    }
    public List<Integer> diffWaysToCompute(String exp) {
        return solve(exp);
    }
}