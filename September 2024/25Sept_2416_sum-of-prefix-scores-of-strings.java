import java.util.HashMap;

class Solution1 {
    // TLE 30/38 passed TC:O(NXM) SC:O(N)
    public int[] sumPrefixScores(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : words) {
            for (int i = 1; i <= s.length(); i++) {
                String sub = s.substring(0, i);
                map.put(sub, map.getOrDefault(sub, 0) + 1);
            }
        }
        System.out.println(map);
        int n = words.length;
        int ans[] = new int[n];
        int idx = 0;
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                String sub = s.substring(0, i);
                if (map.containsKey(sub)) {
                    ans[idx] += map.get(sub);
                }
            }
            idx++;
        }
        return ans;
    }
}

// OPTIMAL USING TRIE
// T.C : O(n*l), n = number of words, l = average length of each word
// S.C : O(n*l), need to store all characters of words
class Solution {
    class TrieNode {
        int countP = 0; // stores the number of prefixes ending here
        TrieNode[] children = new TrieNode[26]; // array to store children

        // Constructor to initialize a new TrieNode
        public TrieNode() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            countP = 0;
        }
    }

    public void insert(String word, TrieNode root) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();

            }
            node.children[idx].countP += 1;
            node = node.children[idx];
        }

    }

    public int getScore(String word, TrieNode root) {
        TrieNode node = root;
        int sum = 0;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            sum += node.children[idx].countP;
            node = node.children[idx];
        }
        return sum;
    }

    public int[] sumPrefixScores(String[] words) {

        TrieNode root = new TrieNode();
        // insert all words into trie
        for (String s : words) {
            insert(s, root);
        }
        int n = words.length;
        int result[] = new int[n];
        // Calculate the sum of prefix scores for each word
        for (int i = 0; i < n; i++) {
            result[i] = getScore(words[i], root);
        }

        return result;
    }
}