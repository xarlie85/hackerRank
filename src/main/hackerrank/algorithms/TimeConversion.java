package basics.hackerrank.algorithms;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TimeConversion {

	static String timeConversion(String s) {
		String[] splitted = s.split(":");
		Integer prevHour = Integer.parseInt(splitted[0]);
		String newHour = prevHour.toString();

		if (s.contains("PM")) {
			if (prevHour != 12) {
				newHour = Integer.valueOf(prevHour + 12).toString();
			}
			splitted[splitted.length - 1] = splitted[splitted.length - 1].replace("PM", "");
		} else {
			prevHour = prevHour % 12;
			if (prevHour < 10) {
				newHour = "0" + Integer.valueOf(prevHour).toString();
			} else {
				newHour = Integer.valueOf(prevHour).toString();
			}
			splitted[splitted.length - 1] = splitted[splitted.length - 1].replace("AM", "");
		}

		StringBuilder sb = new StringBuilder(newHour);
		for (int i = 1; i < splitted.length; i++) {
			sb.append(":" + splitted[i]);
		}

		return sb.toString();
	}

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		IntStream.iterate(12, x -> x + 1).limit(23).mapToObj(z -> Integer.valueOf(z % 12).toString() + ":00:00AM")
				.peek(u -> System.out.print(u + "\t")).map(TimeConversion::timeConversion).forEach(y -> {
					System.out.println(y);
				});

		IntStream.iterate(1, x -> x + 1).limit(12).mapToObj(z -> Integer.valueOf(z).toString() + ":00:00PM").peek(u -> System.out.print(u + "\t"))
				.map(TimeConversion::timeConversion).forEach(y -> {
					System.out.println(y + "\t");
				});

	}
}
