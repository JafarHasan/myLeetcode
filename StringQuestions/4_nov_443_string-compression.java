class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int freq[] = new int[256];
        int n = chars.length;
       
        for (int i = 0; i < n; i++) {
            char ch=chars[i];
             int cnt=1;
             while(i+1<n && ch==chars[i+1]){
                i++;
                cnt++;
                
             }
             sb.append(ch);
             if(cnt>1){
                sb.append(cnt);
             }
      
        }
        //filling the temp arrat based on freq and remving duplicate chars
        char[] temp=sb.toString().toCharArray();
        for(int i=0;i<temp.length;i++){
            chars[i]=temp[i];
        }

        return temp.length;
    }
}