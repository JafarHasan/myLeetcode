import  java.util.*;
class Solution {
    // TC: positions=6;
    /// total possiblities 6 5 4 3 2 1
    // tc:O(!6)//constant
    // SC:O(!6) constant
    public int slidingPuzzle(int[][] board) {
        int n = 2;
        int m = 3;
        StringBuilder start = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                start.append(board[i][j]);
            }
        }
        String target = "123450";
        // BFS
        Queue<String> q = new LinkedList<>();
        q.add(start.toString());
        Map<Integer, List<Integer>> map = new HashMap<>();
        // Use Arrays.asList() directly create and add the list
        map.put(0, Arrays.asList(1, 3)); // if 0 idx is 0 then it can be swapped with the idx 1,3
        map.put(1, Arrays.asList(0, 2, 4));
        map.put(2, Arrays.asList(1, 5));
        map.put(3, Arrays.asList(0, 4));
        map.put(4, Arrays.asList(1, 3, 5));
        map.put(5, Arrays.asList(2, 4));

        Set<String> vis = new HashSet<>();
        vis.add(start.toString());
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String curr = q.poll();
                if (curr.equals(target))
                    return level;
                int idxOfZero = curr.indexOf('0');// finding idx of 0
                for (int swapIdx : map.get(idxOfZero)) {
                    StringBuilder newState = new StringBuilder(curr);
                    swap(newState, idxOfZero, swapIdx);
                    if (!vis.contains(newState.toString())) {
                        q.offer(newState.toString());
                        vis.add(newState.toString());
                    }
                }
            }
            level++;
        }
        return -1;
    }

    private void swap(StringBuilder sb, int i, int j) {
        // Get the characters at the specified indices
        char charAtI = sb.charAt(i);
        char charAtJ = sb.charAt(j);

        // Swap the characters
        sb.setCharAt(i, charAtJ);
        sb.setCharAt(j, charAtI);
    }
}