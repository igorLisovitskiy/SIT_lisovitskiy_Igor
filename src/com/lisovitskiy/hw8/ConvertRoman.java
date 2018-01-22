package com.lisovitskiy.hw8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConvertRoman {

	private static Map<Integer, String> map = new HashMap<Integer, String>();
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
		String romanNumber = map.entrySet().stream().filter(map -> map.getKey() == x).map(map -> map.getValue())
.collect(Collectors.joining());
		
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

	//	list.stream().forEach(e -> (e.compareTo(list.listIterator().next())>0 ?  decimal += e : decimal -= e);
			      

		
		
		System.out.println(decimal);

		
		//System.out.println(map.entrySet().stream().filter(map -> map.getValue() == s).map(Map.Entry::getKey).toString());

		    
		return null;
	}
	
	public static void main(String[] args) {
		//System.out.println(decimal2Roman(5));
		System.out.println(roman2Decimal("XC"));
		
	}

}
