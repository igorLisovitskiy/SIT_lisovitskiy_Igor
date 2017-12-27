package com.lisovitskiy.hw6;

import java.io.*;

public class CountFiles {

	public String countAllFiles(File file) {
		return count(file, 0, 0);
	}

	public String countVisibleFiles(File file) {
		return count(file, 0, 0);
	}

	private String count(File file, int visibleFiles, int hiddenFiles) {
		File[] files = file.listFiles();
		for (File f : files) {
			if (f.isFile()) {
				visibleFiles++;
				if (f.isHidden()) {
					hiddenFiles++;
				}
			}
		}
		if (file.getParent() == null) {
			return "Top Directory: '" + file.getAbsolutePath() + "'\nFiles: " + visibleFiles + "\nHidden files: "
					+ hiddenFiles;
		}
		return count(new File(file.getParent()), visibleFiles, hiddenFiles);
	}

	public static void main(String[] args) {
//		File f = new File("D:\\ExcelTracking\\_Archive\\ExcelTracking 1.05");
//		CountFiles cf = new CountFiles();
//		System.out.println(cf.countAllFiles(f));
	}
}
