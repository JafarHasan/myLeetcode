import java.util.*;

class Solution {
    // passed TC:O(NlogN) SC:O(N)
    public int minGroups(int[][] intervals) {
        // sort based on starting points
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // we want min ending points so store in PQ
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int row[] : intervals) {
            int start = row[0];
            int end = row[1];
            if (!pq.isEmpty() && start > pq.peek()) {
                // we can add in same group
                pq.poll();// logN in pQ

            }
            // store next end points
            pq.add(end);
        }
        return pq.size();

    }
}

class Solution1 {
    // TLE 34/35 passed TC:O(N*K) SC:O(N)
    public int minGroups(int[][] intervals) {
       
        // sort based on starting points
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // trying to store ending points and currStart>previous end of any prev group
        List<Integer> endingPoints = new ArrayList<>();
        for (int row[] : intervals) {
            int start = row[0];
            int end = row[1];
            boolean added = false;
            // iterate on list
            for (int i = 0; i < endingPoints.size(); i++) {
                if (start > endingPoints.get(i)) {// we can keep this in same group
                    endingPoints.set(i, end);
                    added = true;
                    break;
                }
            }
            if (!added) {
                endingPoints.add(end);
            }
        }

        return endingPoints.size();

    }
}

class Solution2 {
    // BF TLE 29/35 passed using group intervals with non overlaping
    // TC:O(N*K) where n=length of interval K=avg length of inner List
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<List<int[]>> group = new ArrayList<>();
        List<int[]> sub = new ArrayList<>();
        sub.add(new int[] { intervals[0][0], intervals[0][1] });
        group.add(sub);

        for (int i = 1; i < n; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            boolean added = false;

            for (List<int[]> curr : group) {
                int[] lastInterval = curr.get(curr.size() - 1);
                int lastEnd = lastInterval[1];

                // If current interval does not overlap with the last in this group
                if (currStart > lastEnd) {
                    curr.add(new int[] { currStart, currEnd });
                    added = true;
                    break; // Break out after adding to this group
                }
            }

            // If the current interval did not fit into any existing group, create a new
            // group
            if (!added) {
                List<int[]> newList = new ArrayList<>();
                newList.add(new int[] { currStart, currEnd });
                group.add(newList);
            }
        }

        return group.size();
    }
}