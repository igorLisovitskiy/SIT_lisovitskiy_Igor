package com.lisovitskiy.hw7;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import static java.nio.file.FileVisitResult.*;

/*
 * Finds all files for the set depth from a starting directory
 */

public class FindFiles implements FilenameFilter {
	String extension;

	public FindFiles(String extension) {
		this.extension = "." + extension;
	}

	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(extension);
	}

	private static List<String> findFiles(File dir, String extension, int depth) throws IOException {
		List<String> selected = new ArrayList<String>();
		Files.walkFileTree(dir.toPath(), EnumSet.noneOf(FileVisitOption.class), depth, new DefaultFileVisitor(extension, selected));
		return selected;
	}

	public static void main(String[] args) throws IOException {
		File dir = new File("C:" + File.separator + "Users" + File.separator + "Lis" + File.separator
				+ "eclipse-workspace" + File.separator + "SIT_lisovitskiy_Igor" + File.separator);
		String extension = "java";
		System.out.println(findFiles(dir, extension, 5));

	}
}

class DefaultFileVisitor extends SimpleFileVisitor<Path> {
	private String extension;
	private List<String> selected;

	public DefaultFileVisitor(String extension, List<String> selected) {
		this.extension = extension;
		this.selected = selected;
	}

	@Override
	public FileVisitResult visitFile(Path path, BasicFileAttributes attr) throws IOException {
		if (path.getFileName().toString().endsWith(extension))
			selected.add(path.getFileName().toString());
		return CONTINUE;
	}
}
