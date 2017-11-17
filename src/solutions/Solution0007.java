package solutions;

/*
 * 
 * PROJECT EULER - SOLUTION 0007
 * -----------------------------
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,
 * we can see that the 6th prime is 13.
 * 
 * What is the 10 001st prime number?
 * 
 * -----------------------------
 * ANSWER: 104743
 * 
 */
public class Solution0007 {
	
	private static final int PRIME_SIZE = 1_000_000;
	private static boolean primes[];
	
	static {
		primes = new boolean[PRIME_SIZE];
		
		handlePrimes(PRIME_SIZE);
	}
	
	public static void main(String[] args) {
		int N = 10001;
		System.out.printf("%dth prime: %d\n", N, getNthPrime(N));
	}
	
	private static int getNthPrime(int N) {
		int prime = 2;
		
		for(int i = 2; i < primes.length && N != 0; i++) {
			if(primes[i]) {
				N--;
				prime = i;
			}
		}
		
		return prime;
	}
	
	private static void handlePrimes(int calculateLimit) {
		// prepare: 0 and 1 are not primes
		primes[0] = false;
		primes[1] = false;
		
		// the rest initial values are primes
		for(int i = 2; i < primes.length; i++) {
			primes[i] = true;
		}
		
		// Handle 2 for better performance
		for(int i = 4; i < primes.length; i+=2) {
			primes[i] = false;
		}
		
		for(int i = 3; i < Math.sqrt(calculateLimit); i+=2) {
			if(primes[i] != false) {
				for(int j = 2*i; j < primes.length; j+=i) {
					primes[j] = false;
				}
			}
		}
	}
	
}
