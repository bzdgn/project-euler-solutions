package solutions;

/*
 * 
 * PROJECT EULER - SOLUTION 0001
 * -----------------------------
 * 
 * GIVEN: If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 * -----------------------------
 * ANSWER: 233168
 * 
 */
public class Solution0001 {

	public static void main(String[] args) {
		System.out.println("Sum of multiples (3,5) below 10   = " + sumOfMultiples3Or5(10));
		System.out.println("Sum of multiples (3,5) below 1000 = " + sumOfMultiples3Or5(1000));
	}
	
	private static long sumOfMultiples3Or5(int limit) {
		long sum = 0;
		
		for(int i = 0; i < limit; i++) {
			if(i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		
		return sum;
	}

}
