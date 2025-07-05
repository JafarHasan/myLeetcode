
class Solution {

    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int m = (n % k == 0) ? (int) n / k : (int) n / k + 1;
        int idx = 0;
        String ans[] = new String[m];

        int i = 0;
        while (i < n) {
            //if a group can be form 
            //form it and save it
            if (i + k <= n) {
                ans[idx++] = s.substring(i, i + k);
                i += k;
                //else we cant make a grp of size k break
            } else {
                break;
            }
        }
        //we all k size grp can be formed they have been formed in while loop
        //so return ans
        if (n % k == 0) {
            return ans;
        }
        ///else if String is still left with grp size<k
        //form it and fill it with fill untill its len==k
        StringBuilder grp = new StringBuilder(s.substring(i));
        int len = k - grp.length();

        //append fill char until shorter grp size==k
        while (len > 0) {
            grp.append(fill);
            len--;
        }
        ///store it in the last idx
        ans[m - 1] = grp.toString();
        //return ans
        return ans;

    }

    //TC:O(N^2) SC:O(1)
    public String[] divideString_UsingString(String s, int k, char fill) {
        int n = s.length();
        int m = (n % k == 0) ? (int) n / k : (int) n / k + 1;
        int idx = 0;
        String ans[] = new String[m];
        String grp = "";
        int i = 0;
        while (i < n) {
            if (i + k <= n) {
                ans[idx++] = s.substring(i, i + k);
                i += k;
            } else {
                break;
            }
        }
        if (n % k == 0) {
            return ans;
        }
        grp = s.substring(i);
        int len = 0;
        if (grp.length() < k) {
            len = k - grp.length();
        }
        while (len > 0) {
            grp += fill;
            len--;
        }
        ans[m - 1] = grp;

        return ans;

    }
}
