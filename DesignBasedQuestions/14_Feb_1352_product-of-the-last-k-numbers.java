
import java.util.*;

class ProductOfNumbers { // TLE TC:O(1) SC:O(1)

    List<Integer> list;
    int prefix;

    public ProductOfNumbers() {
        list = new ArrayList<>();
        prefix = 1;
    }

    public void add(int num) {
        if (num == 0) {
            list = new ArrayList<>();
            prefix = 1;
        } else {
            prefix *= num;
            list.add(prefix);
        }
    }

    public int getProduct(int k) {
        // System.out.println(list);
        int size = list.size();
        if (k == size) {
            return prefix;
        } else if (k > size) {
            return 0;
        } else {
            return prefix / list.get(size - 1 - k);
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers(); obj.add(num); int param_2 =
 * obj.getProduct(k);
 */
class ProductOfNumbersBruteForce { // TLE TC:O(K) SC:O(1)

    List<Integer> list;
    int size;

    public ProductOfNumbersBruteForce() {
        list = new ArrayList<>();
        size = 0;
    }

    public void add(int num) {
        list.add(num);
        size++;
    }

    public int getProduct(int k) {
        // System.out.println(list);
        int mul = 1;
        for (int i = size - k; i < size; i++) {
            if (list.get(i) == 0) {
                return 0;
            }
            mul *= list.get(i);
        }
        // System.out.println(mul);
        return mul;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers(); obj.add(num); int param_2 =
 * obj.getProduct(k);
 */
