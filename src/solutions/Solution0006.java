package solutions;

/*
 * 
 * PROJECT EULER - SOLUTION 0006
 * -----------------------------
 * The sum of the squares of the first ten natural numbers is,
 * 
 * 12 + 22 + ... + 102 = 385
 * The square of the sum of the first ten natural numbers is,
 * 
 * (1 + 2 + ... + 10)2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural
 * numbers and the square of the sum is 3025 − 385 = 2640.
 * 
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 * 
 * -----------------------------
 * ANSWER: 25164150
 * 
 */
public class Solution0006 {
	
	private static final int LIMIT = 100;
	
	public static void main(String[] args) {
		System.out.printf
		(
			"The difference between Sum Of Squares and Square of Sums of the natural numers [0, %d] = %d\n",
			LIMIT, diffOfSumOfSquaresAndSquareOfSums(LIMIT)
		);
	}
	
	private static long sumOfSquares(int limit) {
		long sum = 0;
		for(int i = 1; i <= limit; i++) {
			sum += i*i;
		}
		
		return sum;
	}
	
	private static long squareOfSums(int limit) {
		long sum = 0;
		for(int i = 1; i <= limit; i++) {
			sum += i;
		}
		
		return sum*sum;
	}
	
	private static long diffOfSumOfSquaresAndSquareOfSums(int limit) {
		return squareOfSums(limit) - sumOfSquares(limit);
	}

}
