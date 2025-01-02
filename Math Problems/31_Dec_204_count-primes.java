
import java.util.Arrays;

class Solution {
    //Use Sieve of Eratosthenes. TC:O(N*sqrt(N)) SC:O(N)
    public int countPrimes(int n) {
        if (n <= 2)
            return 0;
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        int cnt = 0;
        for (int i = 2; i * i < n; i++) {
            ///if prime[i] is a prime no so all its multiple will not be prime at all
            if (prime[i]) {
                //mark all its muptiple false
                for (int multiple = i * i; multiple < n; multiple += i) {
                    prime[multiple] = false;
                }
            }
        }

        for (boolean i:prime) {
            if (i)
                cnt++;
        }
        return cnt;
    }

   

    // TLE TC:O(NlogN) SC;O(1)20/66 passed
    public int countPrimes1(int n) {

        if (n <= 2)
            return 0;
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                cnt++;
            }
        }
        return cnt;
    }
     private boolean isPrime(int no) {
        for (int i = 2; i * i <= no; i++) {
            if (no % i == 0)
                return false;
        }
        return true;
    }
}