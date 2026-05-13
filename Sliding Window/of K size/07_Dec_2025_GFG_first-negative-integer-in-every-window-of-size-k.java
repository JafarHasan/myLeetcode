
import java.util.*;

class Solution {

    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        //TC:O(NxK)
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean f = false;
        //saving all -ve elemets idx
        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) {
                q.add(i);
            }
        }
        if (!q.isEmpty()) {
            ans.add(arr[q.peek()]);
        } else {
            ans.add(0);
        }
        for (int i = k; i < arr.length; i++) {
            //remove out of window ele if exists in Queuee
            if (!q.isEmpty() && q.peek() <= i - k) {
                q.poll();
            }
            //add new ele if its -ve
            if (arr[i] < 0) {
                q.add(i);
            }
            if (!q.isEmpty()) {
                ans.add(arr[q.peek()]);
            } else {
                ans.add(0);
            }
        }
        return ans;
    }
}

class Solution_BF {

    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        //TC:O(NxK)
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length - k + 1; i++) {
            boolean flag = false;
            for (int j = i; j < i + k; j++) {
                if (arr[j] < 0) {
                    ans.add(arr[j]);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                ans.add(0);
            }
        }
        return ans;
    }
}
