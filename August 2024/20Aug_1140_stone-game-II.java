import java.util.Arrays;

class Solution {
    public int stoneGameII(int[] piles) {
        int[][][] dp = new int[piles.length + 1][piles.length + 1][2];
        for (int i = 0; i <= piles.length; i++) {
            for (int j = 0; j <= piles.length; j++)
                Arrays.fill(dp[i][j], -1);
        }
        return helper(piles, 0, 1, 1, dp);

    }

    int helper(int[] piles, int ind, int turn, int m, int[][][] dp) {

        if (ind >= piles.length)
            return 0;

        if (dp[ind][m][turn] != -1)
            return dp[ind][m][turn];

        int take = 0;
        int maxi = turn == 1 ? -1 : Integer.MAX_VALUE;

        for (int i = 1; i <= Math.min(2 * m, piles.length - ind); i++) {

            take += piles[ind + i - 1];
            if (turn == 1) {
                maxi = Math.max(maxi, take + helper(piles, i + ind, 0, Math.max(m, i), dp));
            } else {
                maxi = Math.min(maxi, helper(piles, i + ind, 1, Math.max(m, i), dp));

            }
        }

        return dp[ind][m][turn] = maxi;
    }
}

// GAME STRATEGY
// // WHEN ITS YOUR TURN,DO YOUR BEST (MAX) ALICE'S TURN
// // WHEN ITS YOUR OPPOSITE TURN,EXPECT (MIN )THE WROSE BOB'S TURN

/*
 * PILES=[2,7,9,4,4]
 * A
 * M=1 1<=X<=2 MAX 2 PILES CAN PICK 2+7=9 SCORE
 * 
 * B M=MAX(M,X)
 * M=2 1<=X<=4 MAX 4 PILES CAN PICK 9+4+4=17 SCORE WIN FAILED
 */

/*
 * 
 * PILES=[2,7,9,4,4]
 * A TURN
 * M=1 1<=X<=2 MAX 2 PILES CAN PICK BUT PICK ONLY X=1 (2) SCORE=2
 * 
 * B TURN
 * M=1 1<=X<=2 MAX 2 PILES CAN PICK ,PICKED X=2 ( 7 9) SCORE=16
 * 
 * A TURN
 * M=2 1<=X<=4 MAX 4 PILES CAN PICK CHOOSE X=2 REMAINING (4 4) SCORE 10
 * ALICE CAN GET MAX=10 POINTS
 * 
 * 
 */
