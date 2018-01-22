package com.lisovitskiy.hw8;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CharsFrequency {
	public static void printMap(Map<Character, Integer> map) {
		map.forEach((key, value) -> {
			System.out.println(" Letter: " + (char) key + " Used: " + value);
		});
	}

	public static Map<Character, Integer> countChars(char[] arr) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (Character i : arr) {
			Integer count = map.get(i);
			map.put(i, count != null ? count + 1 : 1);
		}
		return map;
	}

	public static void showFrequency(String fileName) {
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
			String line = "";
			char[] chars = null;
			Map<Character, Integer> result = new HashMap<Character, Integer>();
			while ((line = reader.readLine()) != null) {
				chars = line.toCharArray();
				result.putAll(countChars(chars));
			}
			Map sortedMap = result.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(
					Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
			printMap(sortedMap);

		} catch (InvalidPathException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		showFrequency("test1.txt");
	}
}
