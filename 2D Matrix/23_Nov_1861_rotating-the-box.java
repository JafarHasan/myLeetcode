class Solution {
    //TC:O(n*m) SC:O(1)
    private void reverse(char[] array) {
        int left = 0; // Start pointer
        int right = array.length - 1; // End pointer

        while (left < right) {
            // Swap elements at left and right
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            // Move towards the middle
            left++;
            right--;
        }
    }

    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;
        // rotate 90 deg (transpose and reverse each row)
        // transpose
        char ans[][] = new char[m][n];// dimensions are swapped
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = box[j][i];
            }
        }
        // reverse each row
        for (char row[] : ans) {
            reverse(row);
        }

        // apply gravity
        for(int j=0;j<n;j++){
            int bottomSpace=m-1;
            for(int i=m-1;i>=0;i--){
                if(ans[i][j]=='*'){
                    bottomSpace=i-1;
                    continue;
                }
                if(ans[i][j]=='#'){
                    ans[i][j]='.';
                    ans[bottomSpace][j]='#';
                    bottomSpace--;
                }
            }
        }
        return ans;

    }
}
class Solution2{
    //TC:O(n*m*n) SC:O(1)
    private void reverse(char[] array) {
        int left = 0; // Start pointer
        int right = array.length - 1; // End pointer

        while (left < right) {
            // Swap elements at left and right
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            // Move towards the middle
            left++;
            right--;
        }
    }

    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;
        // rotate 90 deg (transpose and reverse each row)
        // transpose
        char ans[][] = new char[m][n];// dimensions are swapped
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = box[j][i];
            }
        }
        // reverse each row
        for (char row[] : ans) {
            reverse(row);
        }

        // apply gravity
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                if (ans[i][j] == '.') {
                    // if its a space
                    int stoneRow = -1;
                    for (int k = i - 1; k >= 0; k--) {
                        if (ans[k][j] == '*')
                            break;
                        else if (ans[k][j] == '#') {
                            stoneRow = k;
                            break;
                        }
                    }
                    if (stoneRow != -1) {
                        ans[i][j] = '#';
                        ans[stoneRow][j] = '.';
                    }
                }

            }
        }
        return ans;

    }
}