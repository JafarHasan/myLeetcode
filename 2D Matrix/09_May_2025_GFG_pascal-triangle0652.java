
import java.util.*;

class Solution {

    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        // code here
        int ans[][] = new int[n][n];

        for (int row[] : ans) {
            Arrays.fill(row, 1);
        }

        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                ans[i][j] = ans[i - 1][j - 1] + ans[i - 1][j];
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(ans[i][j]+" ");
        //     }
        //     System.out.println();

        // }
        ArrayList<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ansList.add(ans[n - 1][i]);
        }
        return ansList;

    }
}
