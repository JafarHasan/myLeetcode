class Solution {
    public boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
            return true;
        return false;
    }

    public String reverseVowels(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        char arr[] = s.toCharArray();
        while (left <= right) {
            // while left is not on a vowel char
            while (left < right && !isVowel(arr[left])) {
                left++;
            }
            // while right is not on a vowel char
            while (right > left && !isVowel(arr[right])) {
                right--;
            }
            // when both vowels are same dont need to swap it
            // if (arr[left] == arr[right]) {
            // left++;
            // right--;
            // continue;
            // }
            // now left and right are both on a vowel just swap it
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;

        }
        return new String(arr);
    }
}