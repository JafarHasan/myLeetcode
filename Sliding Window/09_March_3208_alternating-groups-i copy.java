
class Solution {

    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int pre = colors[i];
            int curr = colors[(i + 1) % n];
            int next = colors[(i + 2) % n];
            if (pre != curr && curr != next) {
                ans++;
            }
        }
        return ans;
    }
}
