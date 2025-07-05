
import java.util.*;

class Solution {

    public int findLucky(int[] arr) {
        int[] temp = new int[501];
        for (int val : arr) {
            temp[val]++;
        }
        for (int i = 500; i >= 1; i--) {
            if (temp[i] == i) {
                return i;
            }
        }
        return -1;
    }
}

class Solution_using_Map {

    ///TC:O(N) SC:O(N)
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        int ans = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == key) {
                if (ans < key) {
                    ans = key;
                }
            }
        }
        return (ans == 0) ? -1 : ans;
    }
}
