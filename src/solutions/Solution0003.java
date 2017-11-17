package solutions;

/*
 * 
 * PROJECT EULER - SOLUTION 0003
 * -----------------------------
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * -----------------------------
 * ANSWER: 6857
 * 
 */
public class Solution0003 {
	
	private static final int PRIME_SIZE = (int)Math.sqrt(600851475143L)+1;
	private static boolean primes[];
	
	static {
		primes = new boolean[PRIME_SIZE];
		
		handlePrimes(PRIME_SIZE);
	}

	public static void main(String[] args) {
		long number = 600851475143L;
		
		System.out.printf("Max Prime Factor of %d = %d\n",number, getMaxPrime(number));
	}
	
	private static long getMaxPrime(long number) {
		// Validate the number
		if(number < 2) {
			if(number == 1) {
				return 1;
			} else {
				return -1;
			}
		}
		
		// init maxPrimeFactor
		int maxPrimeFactor = 1;
		
		if(number % 2 == 0) {
			maxPrimeFactor = 2;
			number /= 2;
		}
		
		int prime = 2;
		
		while(number != 1) {
			prime = getNextPrime(prime);
			
			if( (number % prime == 0)) {
				if(prime > maxPrimeFactor) {
					maxPrimeFactor = prime;
				}
				number /= prime;
			}
		}
		
		return maxPrimeFactor;
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
		
//		System.out.println("\tCalculating primes up to: " + calculateLimit);
		for(int i = 3; i < calculateLimit; i+=2) {
			if(primes[i] != false) {
				for(int j = 2*i; j < primes.length; j+=i) {
					primes[j] = false;
				}
			}
		}
		
	}
	
	private static int getNextPrime(int prime) {
		int index = prime+1;
		
		while(!primes[index]) {
			index++;
		}
		
		return index++;
	}
	
}
