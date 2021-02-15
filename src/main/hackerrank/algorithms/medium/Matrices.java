package basics.hackerrank.algorithms.medium;

import java.io.IOException;
import java.util.*;

public class Matrices {

	// Complete the flippingMatrix function below.
	static int flippingMatrix(int[][] matrix, boolean flipNeeded) {
		printMatrix(matrix);
		
		do {
			flipNeeded = false;
			int n = matrix[0].length;
			boolean[] rowsToFlip = new boolean[n];
			boolean[] colsToFlip = new boolean[n];
			
			for (int i = 0; i < n/2; i++) {
				if ( needsFlip(matrix[i]) ) {
					rowsToFlip[i] = true;
					flipNeeded = true;
				}
			}
			
			flipMatrixRows(matrix, rowsToFlip);
			System.out.println("Matrix rows fliped: ");
			printMatrix(matrix);
			
			for (int j = 0; j < n; j++) {
				int[] col = new int[n];
				for (int i = 0; i < n; i++) {
					col[i] = matrix[i][j];
				}
				if ( needsFlip(col) ) {
					colsToFlip[j] = true;
					flipNeeded = true;
				} 
			}
		
			flipMatrixCols(matrix, colsToFlip);
			System.out.println("Matrix cols fliped: ");
			printMatrix(matrix);
			
		} while(flipNeeded);
		
		System.out.println("Final result: ");
		printMatrix(matrix);
		
		return sumSubMatrix(matrix);
	}
	
	private static void printMatrix(int[][] matrix) {
		int length = matrix[0].length;
		for (int i = 0; i < length; i++) {
			Arrays.stream(matrix[i]).peek(n->System.out.print(" ")).forEach(System.out::print);
			System.out.println();
		}
	}

	private static void flipMatrixRows(int[][] matrix, boolean[] rows) {
		int len = rows.length;
		
		for ( int k = 0; k < len ; k++) {
			if ( rows[k] == true) {
				int[] newRow = new int[len];
				for (int j = 0 ; j < len; j++) {
					newRow[j] = matrix[k][len- 1 - j];
				}
				for (int j = 0; j < len; j++ ) {
					matrix[k][j] = newRow[j];
				}
			}
		}
	}

	private static void flipMatrixCols(int[][] matrix, boolean[] cols) {
		int len = cols.length;
		
		for ( int k = 0; k < len ; k++) {
			if ( cols[k] == true) {
				int[] newCol = new int[len];
				for (int j = 0 ; j < len - 1; j++) {
					newCol[j] = matrix[len- 1 - j][k];
				}
				for (int j = 0; j < len; j++ ) {
					matrix[j][k] = newCol[j];
				}
			}
		}
	}
	private static int sumSubMatrix(int[][] matrix) {
		int rowLength = matrix[0].length;
		int sum = 0;
		for (int j = 0; j < rowLength/2; j++) {
			for (int k = 0; k < rowLength/2; k++) {
				sum += matrix[j][k];
			}
		}
		System.out.println("Sum: [" + sum + "]");
		return sum;
	}

	static boolean needsFlip(int[] v) {
		int sumIn = 0; 
		int sumOut = 0;
		for (int j = 0; j < v.length/2; j++) {
			sumIn += v[j];
			sumOut += v[v.length - 1 - j];
		}
		if (sumIn < sumOut) {
			System.out.println("sumIn: [" + sumIn + "] sumOut:[" + sumOut + "] => flip:[" + true + "]");
			return true;
		}
		
		System.out.println("sumIn: [" + sumIn + "] sumOut:[" + sumOut + "] => flip:[" + false + "]");
		return false;
	}
	
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[][] matrix = new int[2 * n][2 * n];

			for (int i = 0; i < 2 * n; i++) {
				String[] matrixRowItems = scanner.nextLine().split(" ");
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				for (int j = 0; j < 2 * n; j++) {
					int matrixItem = Integer.parseInt(matrixRowItems[j]);
					matrix[i][j] = matrixItem;
				}
			}

			int result = flippingMatrix(matrix, false);

		}

		scanner.close();
	}
}
