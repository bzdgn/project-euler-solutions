package solutions;

/*
 * 
 * PROJECT EULER - SOLUTION 0005
 * -----------------------------
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10
 * without any remainder.
 * 
 * What is the smallest positive number that is evenly divisible by all of the numbers
 * from 1 to 20?
 * 
 * -----------------------------
 * ANSWER: 232792560
 * 
 */
public class Solution0005 {
	
	private static boolean[] primes;
	private static int[][] primeCounts;
	private static final int MAX_NUMBER = 20;
	
	static {
		primes = new boolean[MAX_NUMBER];
		handlePrimes(MAX_NUMBER);
		primeCounts = new int[countPrimes()][2];
		
		for(int i = 0, j = 0; i < MAX_NUMBER; i++) {
			if(primes[i]) {
				primeCounts[j][0] = i;
				primeCounts[j][1] = 0;
				j++;
			}
		}
	}
	
	public static void main(String[] args) {
		int numberArray[] = new int[MAX_NUMBER];
		
		for(int i = 0, j = 1; i < numberArray.length; i++) {
			numberArray[i] = j++;
		}
		
		handleSmallestNumber(numberArray);
		
		System.out.printf("Minimum Number Divisibile Evenly By [0-%d]: %d\n", MAX_NUMBER, calculateMinimumDivisibleNumber());
	}
	
	private static long calculateMinimumDivisibleNumber() {
		long number = 1;
		
		for(int i = 0; i < primeCounts.length; i++) {
			number *= Math.pow(primeCounts[i][0], primeCounts[i][1]);
		}
		
		return number;
	}
	
	private static void handleSmallestNumber(int[] numberArray) {
		while(!isNumberArrayFinished(numberArray)) {
			for(int p = 0; p < primeCounts.length; p++) {
				boolean isUsed = false;
				for(int i = 0; i < numberArray.length; i++) {
					if( (numberArray[i] != 1) && (numberArray[i] % primeCounts[p][0] == 0) ) {
						if(!isUsed) {
							primeCounts[p][1]++;
							isUsed = true;
						}
						numberArray[i]/=primeCounts[p][0];						
					}
				}
			}
		}
	}
	
	private static boolean isNumberArrayFinished(int[] numberArray) {
		for(int i = 0; i < numberArray.length; i++) {
			if(numberArray[i] != 1) {
				return false;
			}
		}
		
		return true;
	}
	
	private static int countPrimes() {
		int count = 0;
		
		for(int i = 0; i < primes.length; i++) {
			if(primes[i]) {
				count++;
			}
		}
		
		return count;
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
		
		for(int i = 3; i < calculateLimit; i+=2) {
			if(primes[i] != false) {
				for(int j = 2*i; j < primes.length; j+=i) {
					primes[j] = false;
				}
			}
		}
		
	}

}
