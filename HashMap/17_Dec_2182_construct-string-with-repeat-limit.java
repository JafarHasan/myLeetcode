class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        StringBuilder sb = new StringBuilder();
        int arr[] = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        // find largest chaar first
        int i = 25;
        while (i >= 0) {
            // skip those chars whose freq is 0 means not present in string s
            if (arr[i] == 0) {
                i--;
                continue;
            }
            char ch = (char) ('a' + i);
            // we can use only this freq of char which is min
            int freq = Math.min(arr[i], repeatLimit);
            // append the char freq times
            sb.append(String.valueOf(ch).repeat(freq));
            // decrease the freq
            arr[i] -= freq;

            if (arr[i] > 0) {
                // find next largest char
                int j = i - 1;
                while (j >= 0 && arr[j] == 0) {
                    j--;
                }
                if (j < 0) {
                    // no char found so break
                    break;
                }
                // append the one second largest char to
                sb.append((char) ('a' + j));
                arr[j]--;

            }

        }
        return sb.toString();
    }
}