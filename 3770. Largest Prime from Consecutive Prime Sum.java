import java.util.*;

class Solution {
    public int largestPrime(int n) {
        // Step 1: Sieve of Eratosthenes to mark all primes up to n
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Step 2: Store all primes in a list
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) primes.add(i);
        }

        // Step 3: Generate consecutive prime sums starting from 2
        int sum = 0;
        int largest = 0;
        for (int p : primes) {
            sum += p;
            if (sum > n) break;
            if (isPrime[sum]) {
                largest = sum;
            }
        }

        return largest; // return 0 if no sum found (largest = 0)
    }
}
