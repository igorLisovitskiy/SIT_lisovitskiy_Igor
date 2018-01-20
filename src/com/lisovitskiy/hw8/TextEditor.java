package com.lisovitskiy.hw8;

import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class TextEditor {
	public static void edit(String fileName) {
		Scanner  scanner = new Scanner(System.in);
		Charset charset = Charset.forName("UTF-8");

		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName), charset, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
			
			while(scanner.hasNext()) {
				if(scanner.next().equals("exit")){
					break;
				}else{
					writer.write(scanner.next());
				}
			
			}

		} catch (InvalidPathException e) {
			System.out.println("Incorrect path: " + e);
		} catch (IOException e) {
			System.out.println("Incorrect input: " + e);
		}

	}

	public static void main(String[] args) throws IOException {
		// String path = System.getProperty("user.home") + File.separatorChar +
		// "Documents";
		edit("test.txt");
	}
}
