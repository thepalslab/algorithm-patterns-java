package com.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumbersSieve {

    /**✅ 1. Approach: Sieve of Eratosthenes

     Instead of checking each number for primality one-by-one (slow for large n), this algorithm:

     Starts with the assumption that all numbers ≥ 2 are prime

     Iteratively marks multiples of each prime number as not prime

     Skips numbers already marked as not prime (they’re multiples of earlier primes)

     This reduces redundant checks significantly.

     🧠 2. Time and Space Complexity
     Metric	Value
     Time	O(n log log n)
     Space	O(n) (for boolean array)

     Efficient even for n = 10^6 or more.**/

    /**
     * Returns a list of all prime numbers less than 'n' using the Sieve of Eratosthenes.
     *
     * @param n The upper limit (exclusive) for checking prime numbers.
     * @return List of prime numbers below 'n'.
     */
    public static List<Integer> getPrimesBelow(int n) {
        List<Integer> primes = new ArrayList<>();

        // No primes below 2
        if (n <= 2) return primes;

        // Step 1: Assume all numbers are prime
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        // Step 2: Mark non-primes (multiples of known primes)
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // Mark all multiples of i as not prime
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Step 3: Collect all primes into a list
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) primes.add(i);
        }

        return primes;
    }

    public static void main(String[] args) {
        int number = 10;  // Change to any upper limit
        List<Integer> primes = getPrimesBelow(number);
        System.out.println("Prime numbers below " + number + ": " + primes);
    }

   /** ✅ Summary
    Feature	Value
    Works for small & large n	Yes (efficient)
    Can be modified to return n primes	Yes, with extra logic
    Easily parallelizable	Not in this form, but adaptable
    Best use case	Find all primes below a limit (e.g., ≤ 10⁶)

    Let me know if you want:

    A memory-efficient version (for constrained devices)

    A version returning the first k primes

    Integration with files or UI**/
}

