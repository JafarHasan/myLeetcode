
import java.util.*;

class Solution {

    class Pair implements Comparable<Pair> {

        String w;
        int freq;

        Pair(String w, int freq) {
            this.w = w;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair other) {
            // Min-heap: lower frequency first
            if (this.freq == other.freq) {
                return other.w.compareTo(this.w); // reverse alphabetical (so lex smaller comes last)

            }
            return this.freq - other.freq;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Map<String, Integer> map = new HashMap<>();

        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : map.keySet()) {
            pq.add(new Pair(s, map.get(s)));
            while (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            ans.add(pq.poll().w);
        }
        Collections.reverse(ans);
        return ans;

    }
}
