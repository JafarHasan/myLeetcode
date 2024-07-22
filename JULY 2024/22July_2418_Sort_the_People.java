import java.util.*;

class Solution {
    // TC:O(NLogN) SC:O(N)
    class Pair implements Comparable<Pair> {
        int hgt;
        int idx;

        Pair(int hgt, int idx) {
            this.hgt = hgt;
            this.idx = idx;
        }

        public int compareTo(Pair p) {
            // return p.hgt - this.hgt;
            return Integer.compare(p.hgt, this.hgt);
        }
    }

    // Method 1
    public String[] sortPeople2(String[] names, int[] h) {
        int n = h.length;
        Pair temp[] = new Pair[n];
        for (int i = 0; i < n; i++) {
            temp[i] = new Pair(h[i], i);
        }

        Arrays.sort(temp);// TC:O(nlogn)
        String ans[] = new String[n];
        for (int i = 0; i < n; i++) {
            Pair p = temp[i];
            int idx = p.idx;
            ans[i] = names[idx];

        }
        return ans;
    }

    // Method 2
    public String[] sortPeople(String[] names, int[] h) {
        int n = h.length;
        Pair2 temp[] = new Pair2[n];
        for (int i = 0; i < n; i++) {
            temp[i] = new Pair2(names[i], h[i]);
        }
        Arrays.sort(temp);// TC:O(nlogn)
        for (int i = 0; i < n; i++) {
            names[i] = temp[i].name;
        }
        return names;

    }

    class Pair2 implements Comparable<Pair2> {
        String name;
        int hgt;

        Pair2(String name, int hgt) {
            this.name = name;
            this.hgt = hgt;
        }

        public int compareTo(Pair2 p) {
            // return p.hgt - this.hgt;//sort array based on height
            return Integer.compare(p.hgt, this.hgt);
        }
    }

}
