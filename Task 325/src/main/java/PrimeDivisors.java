import java.util.ArrayList;
import java.util.List;

/**
 * Calculates all prime divisors of a natural number
 */
public class PrimeDivisors {

    /**
     * Calculates all prime divisors of a natural number
     * @param n natural number for which calculation is required
     * @return Set of prime divisors
     * @throws IllegalArgumentException if n is less or equal one
     */
    static List<Integer> execute(int n) {
        if (n <= 1) {
            throw new IllegalArgumentException("n should be more than one");
        }

        // find all primes which could be divisors
        int[] primesAll = calculatePrimes(n/2);
        List<Integer> primeDivisors = new ArrayList<Integer>();
        for (int prime : primesAll) {
            if (n % prime == 0) {
                primeDivisors.add(prime);
            }
        }

        return primeDivisors;
    }

    // calculates primes that less than given number using Sieve of Eratosthenes
    private static int[] calculatePrimes(int n) {

        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        int countPrimes = 0;

        for (int p = 2; p <= n; p++) {
            if (isPrime[p]) {
                countPrimes++;

                for (int i = 2; p*i <= n; i++) {
                    isPrime[p * i] = false;
                }
            }
        }

        int[] result = new int[countPrimes];
        int i = 0;
        for (int p = 2; p <= n; p++) {
            if (isPrime[p]) {
                result[i++] = p;
            }
        }

        return result;

    }
}
