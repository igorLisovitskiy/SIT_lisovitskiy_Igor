package com.lisovitskiy.hw12;

import java.util.Arrays;

public class StringCalculator {

	public static int add(String input) {
		int result = 0;
		if (input.length() < 1) {
			return result;
		} else {
			String delimeter = "[\n" + Character.toString(input.charAt(0)) + "]";
			result = Arrays.stream(input.split(delimeter))
					.filter((s) -> s.matches("\\d{1,}"))
					.filter(n -> n.length() < 4)
					.mapToInt(Integer::parseInt)
					.sum();
		}
		return result;
	}
}
