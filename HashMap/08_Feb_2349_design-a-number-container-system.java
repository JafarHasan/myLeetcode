
import java.util.*;
class NumberContainers {
    Map<Integer, TreeSet<Integer>> map;
    Map<Integer, Integer> m;
    public NumberContainers() {
        map = new HashMap<>();
        m = new HashMap<>();

    }

    public void change(int index, int number) {
        m.put(index, number);
        if (!map.containsKey(number)) {
            map.put(number, new TreeSet<>());
        }
        map.get(number).add(index);
    }

    public int find(int number) {
        if (!map.containsKey(number)) {
            return -1;
        }
        for (Integer a : map.get(number)) {
            if (m.get(a) == number) {
                return a;
            }
        }
        return -1;
    }
}

class NumberContainers2 {

    //TLE TC:O(N*logN) SC:O(N)
    //so that all idx are unique and in sorted order to get the smallest one
    Map<Integer, TreeSet<Integer>> map;

    public NumberContainers2() {
        map = new HashMap<>();
    }

    private void checkAndReplace(int idx, int no) {
        // For each key in the map that is not equal to 'no',
        // remove the index 'idx' from that list if it exists.
        for (int key : map.keySet()) {
            if (key != no && map.get(key).contains(idx)) {
                map.get(key).remove(Integer.valueOf(idx));
            }
        }
    }

    public void change(int index, int number) {
        checkAndReplace(index, number);
        if (map.containsKey(number)) {
            TreeSet<Integer> list = map.get(number);
            if (!list.contains(index)) {
                list.add(index);
            }
        } else {
            TreeSet<Integer> list = new TreeSet<>();
            list.add(index);
            map.put(number, list);
        }
    }

    public int find(int number) {
        if (map.containsKey(number) && !map.get(number).isEmpty()) {
            // Return the first index in the list for the given number.
            return map.get(number).first();
        }
        return -1;
    }
}


/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
