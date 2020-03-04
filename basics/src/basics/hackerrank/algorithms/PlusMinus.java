package basics.hackerrank.algorithms;

import java.util.*;

public class PlusMinus {

	public enum values {
		POSITIVE(1), NEGATIVE(-1), ZERO(0);

		private int val;

		private values(int val) {
			this.val = val;
		}

		public int getVal() {
			return val;
		}

	}

	// Complete the plusMinus function below.
	static void plusMinus(Integer[] arr) {
		System.out.println(arr.length);
		Map<values, Long> dist = new EnumMap<>(values.class);
//		dist = Arrays.stream(arr)
//				.collect(Collectors.groupingBy(x -> x > 0 ? values.POSITIVE : (x < 0 ? values.NEGATIVE : values.ZERO), Collectors.counting()));
		dist.put(values.POSITIVE, 0L);
		dist.put(values.NEGATIVE, 0L);
		dist.put(values.ZERO, 0L);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0)
				dist.put(values.POSITIVE, dist.get(values.POSITIVE) + 1);
			else if (arr[i] < 0)
				dist.put(values.NEGATIVE, dist.get(values.NEGATIVE) + 1);
			else
				dist.put(values.ZERO, dist.get(values.ZERO) + 1);
		}

		if (dist.get(values.POSITIVE) != null)
			System.out.print(String.format("%.7g%n", ((double) dist.get(values.POSITIVE) / arr.length)));
		if (dist.get(values.NEGATIVE) != null)
			System.out.print(String.format("%.7g%n", ((double) dist.get(values.NEGATIVE) / arr.length)));
		if (dist.get(values.ZERO) != null)
			System.out.print(String.format("%.7g%n", ((double) dist.get(values.ZERO) / arr.length)));

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		Integer[] arr = new Integer[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		plusMinus(arr);

		scanner.close();
	}

}
