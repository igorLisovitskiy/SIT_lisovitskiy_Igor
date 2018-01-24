package com.lisovitskiy.hw8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ConvertRoman {

	private static NavigableMap<Integer, String> map = new TreeMap<Integer, String>(Collections.reverseOrder());
	static {
		map.put(1, "I");
		map.put(5, "V");
		map.put(10, "X");
		map.put(50, "L");
		map.put(100, "C");
		map.put(500, "D");
		map.put(1000, "M");
	}

	public static String decimal2Roman(int x) {
		String foundRoman = "";
		if(x == 0){
			return "";
		}
		foundRoman = map.entrySet().stream().filter(map -> map.getKey() == x).map(map -> map.getValue())
				.collect(Collectors.joining());
		if (foundRoman.length() > 0) {
			return foundRoman;
		}

		String romanNumber = "";
		String subtactiveNotation = "";
		String usualNotation = "";

		int initialNumber = x;
		int number = 0;
		int a = 1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (initialNumber > 0) {
			number = (initialNumber % 10) * a;
			if (number > 0) {
				list.add(number);
			}
			initialNumber = initialNumber / 10;
			a *= 10;
		}

		outer: for (int it = list.size() - 1; it >= 0; it--) {
			number = list.get(it);
			for (Integer key : map.keySet()) {
				String temp = "";
				if (number / key > 0) {
					int val = number + key;
					boolean isRomanBaseNumber = map.keySet().contains(val);
					if (key < val && isRomanBaseNumber) {
						temp += map.entrySet().stream().filter(map -> map.getKey() == val).map(map -> map.getValue())
								.collect(Collectors.joining());
					}
					if (temp.length() > 0 && isRomanBaseNumber) {

						temp += map.entrySet().stream().filter(map -> map.getKey() == key).map(map -> map.getValue())
								.collect(Collectors.joining());
						subtactiveNotation += new StringBuilder(temp).reverse().toString();
						continue outer;
					}

				}
			}
			for (Integer key : map.keySet()) {
				int found;
				if ((found = number / key) > 0) {

					for (int i = 0; i < found; i++) {
						usualNotation += map.entrySet().stream().filter(map -> map.getKey() == key)
								.map(map -> map.getValue()).collect(Collectors.joining());
						number -= key;
					}
				}
			}
		}
		romanNumber = subtactiveNotation + usualNotation;
		return romanNumber;
	}

	public static Integer roman2Decimal(String s) {
		char[] chars = s.toCharArray();
		int decimal = 0;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < chars.length; i++) {
			String roman = Character.toString(chars[i]);
			list.add(map.entrySet().stream().filter(map -> map.getValue().equals(roman)).map(Map.Entry::getKey)
					.collect(Collectors.toList()).get(0));
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

		 for (int i = 0; i <= 100; i++) {
			 System.out.printf("%d ====> %s%n", roman2Decimal(decimal2Roman(i)), decimal2Roman(i));
		}
	}
}
