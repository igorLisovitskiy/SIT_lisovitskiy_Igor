package com.lisovitskiy.hw8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ConvertRoman {

	private static NavigableMap<Integer, String> basicRomanNumbers = new TreeMap<Integer, String>(
			Collections.reverseOrder());
	static {
		basicRomanNumbers.put(1, "I");
		basicRomanNumbers.put(5, "V");
		basicRomanNumbers.put(10, "X");
		basicRomanNumbers.put(50, "L");
		basicRomanNumbers.put(100, "C");
		basicRomanNumbers.put(500, "D");
		basicRomanNumbers.put(1000, "M");
	}

	private static NavigableMap<Integer, String> decimalToRoman = new TreeMap<Integer, String>(
			Collections.reverseOrder());

	public static String decimal2Roman(int x) {
		String foundRoman = "";
		if (x == 0) {
			return "";
		}
		foundRoman = basicRomanNumbers.entrySet().stream().filter(map -> map.getKey() == x).map(map -> map.getValue())
				.collect(Collectors.joining());
		if (foundRoman.length() > 0) {
			return foundRoman;
		}
		String compiledRomanNumber = "";
		String subtactiveNotation = "";
		String usualNotation = "";

		int searchNumber = x;
		int initialNumber = 0;
		int tensMultiplier = 1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		// fill out the list
		while (searchNumber > 0) {
			initialNumber = (searchNumber % 10) * tensMultiplier;
			if (initialNumber > 0) {
				list.add(initialNumber);
			}
			searchNumber = searchNumber / 10;
			tensMultiplier *= 10;
		}
		// parse the collection for numbers
		for (int it = list.size() - 1; it >= 0; it--) {
			initialNumber = list.get(it);

			for (Integer key : basicRomanNumbers.keySet()) {
				String temp = "";
				if (initialNumber / key > 0) {
					// if true the number contains such Roman number
					int val = key + initialNumber;
					boolean isRomanBasicNumber = basicRomanNumbers.keySet().contains(val);

					if (initialNumber - key <= 0 && initialNumber != 1) { // strange

						temp += basicRomanNumbers.entrySet().stream().filter(map -> map.getKey() == key)
								.map(map -> map.getValue()).collect(Collectors.joining());
						if (list.size() > 0) {
							list.remove(list.indexOf(key));
							decimalToRoman.put(key, temp);
						}

					} else if (key < val && isRomanBasicNumber) {
						// if true the key goes before the val which is the subtractive part of a Roman numeral
						temp += basicRomanNumbers.entrySet().stream().filter(map -> map.getKey() == key)
								.map(map -> map.getValue()).collect(Collectors.joining()) +

								basicRomanNumbers.entrySet().stream().filter(map -> map.getKey() == val)
										.map(map -> map.getValue()).collect(Collectors.joining());
						// deleting the number which was found as subtractive notation of a Roman numeral
						if (list.size() > 0) {
							list.remove(list.indexOf(initialNumber));
							decimalToRoman.put(val - key, temp);

						}
					}
					subtactiveNotation += new StringBuilder(temp).toString();
				}
			}
		}

		int i;
		int found = 0;
		int foundKey = 0;
		for (int it = list.size() - 1; it >= 0; it--) {
			initialNumber = list.get(it);
			for (Integer key : basicRomanNumbers.keySet()) {
				if ((initialNumber / key) > 0) {
					found = (initialNumber / key);
					for (i = 0; i < found; i++) {
						usualNotation += basicRomanNumbers.entrySet().stream().filter(map -> map.getKey() == key)
								.map(map -> map.getValue()).collect(Collectors.joining());
						initialNumber -= key;
					}
					foundKey = key;
				}
			}
		}
		decimalToRoman.put(foundKey * found, usualNotation);
		compiledRomanNumber = decimalToRoman.entrySet().stream().map((entry) -> entry.getValue())
				.collect(Collectors.joining());
		decimalToRoman.clear();
		return compiledRomanNumber;
	}

	public static Integer roman2Decimal(String s) {
		char[] chars = s.toCharArray();
		int decimal = 0;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < chars.length; i++) {
			String roman = Character.toString(chars[i]);
			list.add(basicRomanNumbers.entrySet().stream().filter(map -> map.getValue().equals(roman))
					.map(Map.Entry::getKey).collect(Collectors.toList()).get(0));
		}

		for (int i = list.size() - 1; i > 0; i--) {
			int current = list.get(i);
			int previous = list.get(i - 1);
			if (current <= previous) {
				list.set(i, (current));
			} else if (current >= previous) {
				list.set(i, (current));
				list.set(i - 1, -(previous));
			}
		}
		decimal = list.stream().mapToInt(Integer::intValue).sum();
		return decimal;
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 1000; i++) {
			System.out.printf("%d ====> %s%n", roman2Decimal(decimal2Roman(i)), decimal2Roman(i));
		}

	}
}
