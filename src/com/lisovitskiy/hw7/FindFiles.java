package com.lisovitskiy.hw7;

import java.io.*;
import java.nio.*;
import java.nio.file.*;

public class FindFiles {

	private static void findFiles(String path, String extension) {
		try {
			
			Files.walk(Paths.get(path)).filter(Files::isRegularFile)
					.filter(f -> f.getFileName().toString().endsWith(extension)).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void showJavaFiles(String path, String extension, int searchDepth) {
		for (int i = 0; i < searchDepth; i++) {
			findFiles(path, extension);
		}
	}

	public static void main(String[] args) {
		String startingDir = "C:\\Users\\Lis\\eclipse-workspace\\SIT_lisovitskiy_Igor\\";
		String extension = "java";
		showJavaFiles(startingDir, extension, 1);

	}

}
