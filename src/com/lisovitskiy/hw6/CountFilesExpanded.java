package com.lisovitskiy.hw6;

import java.io.*;

public class CountFilesExpanded {

	private int countVisible(File file, int visibleFiles) {
		File[] folderFiles = file.listFiles();
		for (File f : folderFiles) {
			if (f.isFile() && !f.isHidden()) {
				visibleFiles++;
			}
		}
		if (file.getParent() == null) {
			return visibleFiles;
		}
		return countVisible(new File(file.getParent()), visibleFiles);
	}

	private int countHidden(File file, int hiddenFiles) {
		File[] folderFiles = file.listFiles();
		for (File f : folderFiles) {
			if (f.isFile() && f.isHidden()) {
				hiddenFiles++;
			}
		}
		if (file.getAbsolutePath() != null) {
			return hiddenFiles;
		}
		return countHidden(new File(file.getAbsolutePath()), hiddenFiles);
	}

	public int countVisibleFiles(File file) {
		return countVisible(file, 0);
	}

	public int countHiddenFiles(File file) {
		return countHidden(file, 0);
	}
	public int countAllFiles(File file) {
		return countHidden(file, 0) + countVisible(file, 0);
	}

	public static void main(String[] args) {
		File f = new File("D:\\ExcelTracking\\_Archive");
		CountFilesExpanded cfa = new CountFilesExpanded();
		System.out.println(cfa.countAllFiles(f));
	}
}
