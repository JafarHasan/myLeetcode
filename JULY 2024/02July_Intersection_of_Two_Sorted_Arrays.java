import java.util.*;

class Solution {
    // TC:O(N) SC:O(N) will work for unsorted array also order should be same in ans
    // as they appear in arrays
    // static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int
    // n, ArrayList<Integer> arr2, int m)
    // {
    // ArrayList<Integer> ans=new ArrayList<Integer>();
    // LinkedHashMap<Integer,Integer> map1=new LinkedHashMap<>();
    // for(int ele:arr1){
    // map1.put(ele,map1.getOrDefault(ele,0)+1);
    // }
    // LinkedHashMap<Integer,Integer> map2=new LinkedHashMap<>();
    // for(int ele:arr2){
    // map2.put(ele,map2.getOrDefault(ele,0)+1);
    // }
    // for(int key:map1.keySet()){
    // if(map2.containsKey(key)){
    // int freq=Math.min(map1.get(key),map2.get(key));
    // while(freq-->0){
    // ans.add(key);
    // }
    // }
    // }
    // return ans;

    // }
    // TC:O(N) SC:O(1) for Sorted Array
    static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m) {
        ArrayList<Integer> ans = new ArrayList<Integer>();

        int i = 0, j = 0;
        while (i < n && j < m) {
            int val1 = arr1.get(i);
            int val2 = arr2.get(j);
            if (val1 == val2) {
                ans.add(val1);
                i++;
                j++;
            }

            else if (val2 > val1) {
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }
}