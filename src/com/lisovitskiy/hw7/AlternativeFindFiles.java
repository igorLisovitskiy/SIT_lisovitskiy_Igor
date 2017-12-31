package com.lisovitskiy.hw7;

import java.io.*;
import java.util.*;

/*
 * Finds all files in a directory
 */

public class AlternativeFindFiles implements FilenameFilter {
	String extension;

	public AlternativeFindFiles(String extension) {
		this.extension = "." + extension;
	}
	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(extension);
	}
	private static List<String> findFiles(File dir, String extension) throws IOException {
		List<String> selected = new ArrayList<String>();
		FilenameFilter ff = new FindFiles(extension);
		String[] fileNames = dir.list(ff);
		Arrays.stream(fileNames).forEach(f -> selected.add(f));
		selected.forEach(System.out::println);
		return selected;
	}

	public static void main(String[] args) throws IOException {
		File dir = new File("C:" + File.separator + "Users" + File.separator + "Lis" + File.separator
				+ "eclipse-workspace" + File.separator + "SIT_lisovitskiy_Igor" + File.separator  + "src" + File.separator + "com" + File.separator + "lisovitskiy" + File.separator + "hw6");
		String extension = "java";
		findFiles(dir, extension);

	}
}
