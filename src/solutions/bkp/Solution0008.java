package solutions.bkp;

/*
 * 
 * PROJECT EULER - SOLUTION 0008
 * -----------------------------
 * The four adjacent digits in the 1000-digit number that have the
 * greatest product are 9 × 9 × 8 × 9 = 5832.
 * 
 * 73167176531330624919225119674426574742355349194934
 * 96983520312774506326239578318016984801869478851843
 * 85861560789112949495459501737958331952853208805511
 * 12540698747158523863050715693290963295227443043557
 * 66896648950445244523161731856403098711121722383113
 * 62229893423380308135336276614282806444486645238749
 * 30358907296290491560440772390713810515859307960866
 * 70172427121883998797908792274921901699720888093776
 * 65727333001053367881220235421809751254540594752243
 * 52584907711670556013604839586446706324415722155397
 * 53697817977846174064955149290862569321978468622482
 * 83972241375657056057490261407972968652414535100474
 * 82166370484403199890008895243450658541227588666881
 * 16427171479924442928230863465674813919123162824586
 * 17866458359124566529476545682848912883142607690042
 * 24219022671055626321111109370544217506941658960408
 * 07198403850962455444362981230987879927244284909188
 * 84580156166097919133875499200524063689912560717606
 * 05886116467109405077541002256983155200055935729725
 * 71636269561882670428252483600823257530420752963450
 * 
 * Find the thirteen adjacent digits in the 1000-digit number that
 * have the greatest product. What is the value of this product?
 * 
 * -----------------------------
 * ANSWER: XXX
 * 
 */
public class Solution0008 {
	
	private final static int FRAME_W = 4;
	private final static int FRAME_H = 4;
	
	private static final String[] MATRIX_STRING_ARRAY = {
			"73167176531330624919225119674426574742355349194934",
			"96983520312774506326239578318016984801869478851843",
			"85861560789112949495459501737958331952853208805511",
			"12540698747158523863050715693290963295227443043557",
			"66896648950445244523161731856403098711121722383113",
			"62229893423380308135336276614282806444486645238749",
			"30358907296290491560440772390713810515859307960866",
			"70172427121883998797908792274921901699720888093776",
			"65727333001053367881220235421809751254540594752243",
			"52584907711670556013604839586446706324415722155397",
			"53697817977846174064955149290862569321978468622482",
			"83972241375657056057490261407972968652414535100474",
			"82166370484403199890008895243450658541227588666881",
			"16427171479924442928230863465674813919123162824586",
			"17866458359124566529476545682848912883142607690042",
			"24219022671055626321111109370544217506941658960408",
			"07198403850962455444362981230987879927244284909188",
			"84580156166097919133875499200524063689912560717606",
			"05886116467109405077541002256983155200055935729725",
			"71636269561882670428252483600823257530420752963450"
		};

	public static void main(String[] args) {
		int[][] matrix = transformMatrix(MATRIX_STRING_ARRAY);
		
		printMatrix(matrix);
		
		System.out.println("Horizontal Max: " + getMaxHorizontal(matrix));
		System.out.println("Vertical Max  : " + getMaxVertical(matrix));
	}
	
	private static long getMaxVertical(int[][] matrix) {
		long verticalMax = 0;
		for(int j = 0; j < matrix[0].length; j++) {
			long tempColumnMax = getColumnMax(matrix, j);
			if(tempColumnMax > verticalMax) {
				verticalMax = tempColumnMax;
			}
		}
		
		return verticalMax;
	}
	
	private static long getColumnMax(int[][] matrix, int columnNum) {
		long columnMaxProd = 0;
		for(int j = 0; j < matrix.length + 1 - FRAME_H; j++) {
			long tempProd = 1;
			for(int i = j; i < j + FRAME_H; i++) {
				tempProd *= matrix[j][columnNum];
			}
			if(tempProd > columnMaxProd) {
				columnMaxProd = tempProd;
			}
		}
		
		return columnMaxProd;
	}
	
	private static long getMaxHorizontal(int[][] matrix) {
		long horizontalMax = 0;
		for(int i = 0; i < matrix.length; i++) {
			long tempRowMax = getRowMax(matrix, i);
			if(tempRowMax > horizontalMax) {
				horizontalMax = tempRowMax;
			}
		}
		
		return horizontalMax;
	}
	
	private static long getRowMax(int[][] matrix, int rowNum) {
		long rowMaxProd = 0;
		for(int i = 0; i < matrix[rowNum].length + 1 - FRAME_W; i++) {
			long tempProd = 1;
			for(int j = i; j < i + FRAME_W; j++) {
				tempProd *= matrix[rowNum][j];
			}
			if(tempProd > rowMaxProd) {
				rowMaxProd = tempProd;
			}
		}
		
		return rowMaxProd;
	}
	
	private static void printMatrix(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	private static int[][] transformMatrix(String[] matrixArray) {
		int[][] matrixIntArray = new int[matrixArray.length][matrixArray[0].length()];
		
		for(int i = 0; i < matrixArray.length; i++) {
			char[] charArray = matrixArray[i].toCharArray();
			for(int j = 0; j < charArray.length; j++) {
				matrixIntArray[i][j] = charArray[j] - '0';
			}
		}
		
		return matrixIntArray;
	}

}
