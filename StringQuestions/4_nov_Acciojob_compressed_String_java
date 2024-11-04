import java.util.*;
import java.io.*;

public class Main {
	static void compressedString(String s) {
        
        
        StringBuilder str=new StringBuilder("");
        for(int i=0;i<s.length();i++){
    
            char ch=s.charAt(i);
            int freq=1;
            while(i+1<s.length() && ch==s.charAt(i+1)){
                i++;
                freq++;
            }
            str.append(ch);
            if(freq>=2){
                str.append(freq);
            }
           
        }
        System.out.print(str);
        
     }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-- > 0){
            String s = br.readLine();
            compressedString(s);
            System.out.println();
        }
    }
}