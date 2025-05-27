
import java.util.*;

class Solution_usingHashMap {

    private boolean isPossibleToFormed(int no, Map<Integer, Integer> map) {
        Map<Integer, Integer> temp = new HashMap<>();
        int a = no / 100;
        int b = (no / 10) % 10;
        int c = no % 10;

        temp.put(a, temp.getOrDefault(a, 0) + 1);
        temp.put(b, temp.getOrDefault(b, 0) + 1);
        temp.put(c, temp.getOrDefault(c, 0) + 1);

        for (int key : temp.keySet()) {
            if (temp.get(key) > map.getOrDefault(key, 0)) {
                return false;
            }
        }
        return true;

    }

    public int[] findEvenNumbers(int[] digits) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int ele : digits) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 100; i <= 999; i += 2) {
            if (isPossibleToFormed(i, map)) {
                set.add(i);
            }
        }
        int size = set.size();
        int ans[] = new int[size];
        int idx = 0;
        for (int ele : set) {
            ans[idx++] = ele;
        }
        return ans;

    }
}
