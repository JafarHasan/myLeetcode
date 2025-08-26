
class Solution {

    public int maximum69Number(int num) {
        char[] c = String.valueOf(num).toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '6') {
                c[i] = '9';
                break;
            }
        }

        return Integer.parseInt(String.valueOf(c));
    }
}

class Solution_Bf {

    public int maximum69Number(int num) {
        int temp = num;
        int len = 0;
        while (temp > 0) {
            len++;
            temp /= 10;
        }
        System.out.println(len);
        int arr[] = new int[len];
        int size = len - 1;
        while (num > 0) {
            arr[size--] = num % 10;
            num /= 10;
        }
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        for (int i = 0; i < len; i++) {
            if (arr[i] == 6) {
                arr[i] = 9;
                break;
            }
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = ans * 10 + arr[i];
        }
        return ans;
    }
}
