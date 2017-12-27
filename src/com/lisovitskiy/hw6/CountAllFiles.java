package com.lisovitskiy.hw6;

import java.io.*;

public class CountAllFiles {
	private int files;
	public int listAllFilesFormDir(String directoryName){
        File directory = new File(directoryName);
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
                this.files++;
            } else if (file.isDirectory()){
            	listAllFilesFormDir(file.getAbsolutePath());
            }
        }
        return files;
    }

	public static void main(String[] args) {
		final String directoryWindows =System.getProperty("user.home") + "\\Downloads";
		CountAllFiles caf = new CountAllFiles();
		System.out.println("In " + directoryWindows + " you have " + caf.listAllFilesFormDir(directoryWindows) + " files!");
	}
}
