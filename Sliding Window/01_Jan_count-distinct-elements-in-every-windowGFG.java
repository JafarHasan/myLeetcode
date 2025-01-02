//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());

            ArrayList<Integer> ans = new Solution().countDistinct(arr, k);

            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            t--;
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        int n=arr.length;
         // Map to keep track of frequency of elements in the current window
        HashMap<Integer, Integer> map = new HashMap<>();
        //for the firs window
        for(int i=0;i<k;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        //add ans of first window
        ans.add(map.size());
        for(int i=k;i<n;i++){
            int curr=arr[i];
            int removEle=arr[i-k];
            //remove out of window element
            map.put(removEle,map.getOrDefault(removEle,0)-1);
            //if remove element is not present delete it completely
            if(map.get(removEle)==0){
                map.remove(removEle);
            }
            //put the curr element in window
             map.put(curr,map.getOrDefault(curr,0)+1);
             //add ans of curr window to the result
             ans.add(map.size());
        }
        return ans;
    }
}
