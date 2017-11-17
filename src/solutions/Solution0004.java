package solutions;

/*
 * 
 * PROJECT EULER - SOLUTION 0004
 * -----------------------------
 * A palindromic number reads the same both ways. The largest palindrome made from 
 * the product of two 2-digit numbers is 9009 = 91 × 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * -----------------------------
 * ANSWER: 6857
 * 
 */
public class Solution0004 {

	public static void main(String[] args) {
		int maxPalindrome = -1;

		for(int a = 100; a <= 999; a++) {
			for(int b = 100; b <= 999; b++) {
				int number = a * b;
				
				if(isPalindrome(number)) {
					if(number > maxPalindrome) {
						maxPalindrome = number;
					}
				}
			}
		}
		
		System.out.printf("Largest Palindrome possible with product of 2 3-digit number: %d\n", maxPalindrome);
	}
	
	private static boolean isPalindrome(int number) {
		return isPalindrome(Integer.toString(number).toCharArray());
	}
	
	private static boolean isPalindrome(char[] number) {
		for(int i = 0; i < number.length/2; i++) {
			if(number[i] != number[number.length-1-i])
				return false;
		}
		
		return true;
	}
	
	

}
