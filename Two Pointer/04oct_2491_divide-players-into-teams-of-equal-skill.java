import java.util.*;

class Solution {

    // TC:O(nlogn) sc:O(1) using sorting and Two pointer
    public long dividePlayers1(int[] skill) {
        long ans = 0;
        int n = skill.length;
        // find the sum of skills
        int sum = 0;
        for (int ele : skill) {
            sum += ele;
        }

        // find target of Pair sum
        int target = (sum) / (n / 2);

        // now we need to find Pair with this target sum

        Arrays.sort(skill);
        // finding Pairs using two pointers
        int i = 0, j = n - 1;
        while (i < j) {
            int n1 = skill[i];
            int n2 = skill[j];

            // check this Pair is equals to target if not return -1
            if (n1 + n2 != target)
                return -1;
            // calculate chemistry
            ans += n1 * n2;
            i++;
            j--;

        }
        return ans;
    }

    // TC:O(n) sc:O(1001)->O(1) using freq array (or HashMap) and sorting beats 96%
    // 3ms
    public long dividePlayers(int[] skill) {
        long chem = 0;
        int n = skill.length;
        int[] freq = new int[1001];// given constraints 1000

        // find the sum of skills and cnt freq of each ele
        int sum = 0;
        for (int ele : skill) {
            sum += ele;
            freq[ele]++;
        }
        // check how many teams we can make
        int team = n / 2;
        if (sum % team != 0)
            return -1;

        int target = sum / team;
        for (int i = 0; i < n; i++) {
            int currSkill = skill[i];
            int remainSkill = target - currSkill;
            if (freq[remainSkill] <= 0)
                return -1;
            chem += currSkill * remainSkill;
            freq[remainSkill]--;
        }
        return chem / 2; // it will take all duplicate (2 4) and (4 2) so /2
    }
}