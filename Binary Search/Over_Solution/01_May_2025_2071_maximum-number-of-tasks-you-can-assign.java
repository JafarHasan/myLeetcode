
import java.util.*;

class Solution {

    //Weakest task(asc order)->Stromgest workers(desc order)
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int n = tasks.length;
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int lo = 0;//min we can do 0 task
        int hi = n;//max we can do all the task
        int pans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossible(tasks, workers, mid, pills, strength)) {
                //i want more task
                pans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return pans;
    }

    private boolean isPossible(int[] t, int[] w, int mid, int pills, int strength) {
        if (mid > w.length) {
            return false;
        }
        int[] tasksK = new int[mid];
        int[] workersK = new int[mid];
        for (int i = 0; i < mid; i++) {
            tasksK[i] = t[i];
        }
        for (int i = 0; i < mid; i++) {
            workersK[i] = w[w.length - mid + i];
        }

        for (int i = mid - 1; i >= 0 && pills > 0; i--) {
            if (tasksK[i] > workersK[i]) {
                tasksK[i] -= strength;
                pills--;
            }
        }

        Arrays.sort(tasksK);
        for (int i = 0; i < mid; i++) {
            if (workersK[i] < tasksK[i]) {
                return false;
            }
        }
        return true;

    }
}
