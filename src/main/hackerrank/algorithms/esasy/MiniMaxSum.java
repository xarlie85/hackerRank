package basics.hackerrank.algorithms.esasy;

import java.util.*;

public class MiniMaxSum {

	// Complete the miniMaxSum function below.
	static void miniMaxSum(int[] arr) {
		long max = 0, min = 0;
		int[] sArr = Arrays.stream(arr).sorted().toArray();
		System.out.println(sArr);
		for (int i = 0; i < (arr.length - 1); i++) {
			min += sArr[i];
			max += sArr[arr.length - 1 - i];
		}
		System.out.println(min + " " + max);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = new int[5];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < 5; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		miniMaxSum(arr);

		scanner.close();
	}
}
