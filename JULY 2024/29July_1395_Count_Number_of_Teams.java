class Solution {
    // TC:O(N^2) SC:O(1)
    public int numTeams(int[] rating) {
        int n = rating.length;
        int team = 0;
        for (int j = 1; j < n - 1; j++) {

            int cntLeftSmaller = 0, cntLeftGreater = 0;
            int cntRightSmaller = 0, cntRightGreater = 0;

            // checking all smaller & greater in left side
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j])
                    cntLeftSmaller++;
                else if (rating[i] > rating[j])
                    cntLeftGreater++;
            }
            // checking all smaller & greater in right side
            for (int k = j + 1; k < n; k++) {
                if (rating[k] < rating[j])
                    cntRightSmaller++;
                else if (rating[k] > rating[j])
                    cntRightGreater++;
            }

            team += cntRightSmaller * cntLeftGreater + cntLeftSmaller * cntRightGreater;
        }
        return team;

    }
}