package com.lisovitskiy.hw8;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.stream.Stream;

public class TextEditor {
	public static void edit(String fileName) {
		Scanner scanner = new Scanner(System.in);
		Charset charset = Charset.forName("UTF-8");

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

		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName), charset, StandardOpenOption.CREATE,
				StandardOpenOption.WRITE, StandardOpenOption.APPEND)) {
			while (scanner.hasNext()) {
				String str = scanner.nextLine();
				if (str.toLowerCase().equals("exit")) {
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

		String text = "Bird, forest, snow";
		ByteArrayInputStream exit = new ByteArrayInputStream("exit".getBytes());
		ByteArrayInputStream in = new ByteArrayInputStream(text.getBytes());
		System.out.println(text);
		System.setIn(in);
		edit("test.txt");
		System.setIn(exit);
		System.setIn(System.in);
	}
}
