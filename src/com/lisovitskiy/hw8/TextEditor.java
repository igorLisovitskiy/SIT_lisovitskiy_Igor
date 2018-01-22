package com.lisovitskiy.hw8;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TextEditor {
	private static Scanner scanner = new Scanner(System.in);
	private static Charset charset = Charset.forName("UTF-8");

	public static void showStatistics(String fileName) {
		int numberOfWords = 0;
		int numberOfSymbols = 0;

		Pattern vowelPattern = Pattern.compile("[AEIOUYaeiouy]");

		try (InputStream input = Files.newInputStream(Paths.get(fileName), StandardOpenOption.READ);
			BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
			String line = "";

			int vowelsFound = 0;
			int lineNumber = 0;
			Matcher matcher;
			while ((line = reader.readLine()) != null) {
				int vowelsPerLine = 0;
				lineNumber++;
				numberOfWords += line.split("\\s+").length;
				numberOfSymbols += line.length();
				matcher = vowelPattern.matcher(line);
				while (matcher.find()) {
					vowelsPerLine++;
				}
				vowelsFound = vowelsFound > vowelsPerLine ? vowelsFound : vowelsPerLine;
			}
			System.out.println("Number of symbols: " + numberOfSymbols);
			System.out.println("Most vowels has line #" + lineNumber + ", vowels found: " + vowelsFound);
			System.out.println("Number of words: " + numberOfWords);

		} catch (InvalidPathException invalidPath) {
			System.out.println("Incorrect path: " + invalidPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void showFile(String fileName) {
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach(System.out::println);
		} catch (InvalidPathException invalidPath) {
			System.out.println("Incorrect path: " + invalidPath);
		} catch (NoSuchFileException e) {
			try {
				Files.createFile(Paths.get(fileName));
			} catch (InvalidPathException invalidPath) {
				System.out.println("Incorrect path: " + e);
			} catch (IOException io) {
				io.printStackTrace();
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public static void edit(String fileName) {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName), charset, StandardOpenOption.CREATE,
				StandardOpenOption.WRITE, StandardOpenOption.APPEND)) {
			while (scanner.hasNext()) {
				String str = scanner.nextLine();
				if (str.toLowerCase().equals("exit")) {
					showFile(fileName);
					showStatistics(fileName);
					break;
				}
				writer.write(str);
				writer.newLine();
				writer.flush();
			}

		} catch (InvalidPathException e) {
			System.out.println("Incorrect path: " + e);
		} catch (IOException e) {
			System.out.println("Incorrect input: " + e);
		}

	}

	public static void main(String[] args) throws IOException {
		String text = "Bird, forest, snow.\\n Where is the coffee?";

		ByteArrayInputStream exit = new ByteArrayInputStream("exit".getBytes());
		ByteArrayInputStream in = new ByteArrayInputStream(text.getBytes());
		edit("test.txt");
		System.setIn(in);
		System.setIn(System.in);
		System.setIn(exit);
		System.setIn(System.in);
	}
}
