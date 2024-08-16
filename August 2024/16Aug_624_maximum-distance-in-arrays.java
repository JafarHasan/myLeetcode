import java.util.List;

class Solution {
    // TC:O(n) SC:O(1)
    // n=arrays.size();
    public int maxDistance(List<List<Integer>> arrays) {

        int smallest = arrays.get(0).get(0);
        int biggest = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDis = 0;
        for (int i = 1; i < arrays.size(); i++) {
            int currSmallest = arrays.get(i).get(0);
            int currBiggest = arrays.get(i).get(arrays.get(i).size() - 1);
            maxDis = Math.max(maxDis, Math.abs(currBiggest - smallest));
            maxDis = Math.max(maxDis, Math.abs(biggest - currSmallest));
            smallest = Math.min(smallest, currSmallest);
            biggest = Math.max(biggest, currBiggest);

        }

        return maxDis;
    }
}