
class Solution {

    //TC:O(sqrt(val))
    private boolean isPrime(int val) {
        if (val < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(val); i++) {
            if (val % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int getNearestPrime(int val) {

        if (isPrime(val)) {
            return val;
        }
        int left = val - 1;
        int right = val + 1;

        while (left >= 2 && !isPrime(left)) {
            left--;
        }

        while (!isPrime(right)) {
            right++;
        }

        //if both the diffrence is same like
        //     5 <-- val=6 --> 7
        //return min prime i.e 5
        if (left >= 2 && (val - left == right - val)) {
            return Math.min(left, right);
        } //if left difference is smaller return left
        else if (left >= 2 && (val - left < right - val)) {
            return left;
        } //otherwise return right
        else {
            return right;
        }
    }

    Node primeList(Node head) {
        // code here

        Node curr = head;
        while (curr != null) {
            if (!isPrime(curr.val)) {
                curr.val = getNearestPrime(curr.val);
            }
            curr = curr.next;

        }
        return head;

    }
}
