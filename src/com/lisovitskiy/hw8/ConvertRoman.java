package com.lisovitskiy.hw8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ConvertRoman {

	private static Map<Integer, String> map = new TreeMap<Integer, String>(Collections.reverseOrder());
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
		String romanNumber = "";
		int number = x;
		for (Integer key : map.keySet()) {
			int found;
			if ((found = number / key) > 0 && number != key - 1) {
				for (int i = 0; i < found; i++) {
					romanNumber += map.entrySet().stream().filter(map -> map.getKey() == key).map(map -> map.getValue())
							.collect(Collectors.joining());
					number -= key;
				}
			}
		}
		return new StringBuilder(romanNumber).toString();// StringBuilder(romanNumber).reverse().toString();
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
		// System.out.println(decimal2Roman(6));
		System.out.println(decimal2Roman(3) + " 3");
		System.out.println(decimal2Roman(4) + " 4");
		System.out.println(decimal2Roman(9) + " 9");
		System.out.println(decimal2Roman(90) + " 90");
		System.out.println(decimal2Roman(11) + " 11");
		// String[] romans = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
		// "IX", "V", "IV", "I" };
		// for(String r:romans){
		// System.out.printf("%s: %d%n", r, roman2Decimal(r));
		// }
	}
}
