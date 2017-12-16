package com.lisovitskiy.practice1;

import java.util.Arrays;

public class ArraysTest {
	public static void main(String[] args) {
		String[][] arr = new String[2][2];
		for (int a = 0; a < arr.length; a++) {
			for (int i = 0; i < arr[a].length; i++) {
				arr[a][i] = "A";
			}
			Arrays.fill(arr[a], "B");
		}
		System.out.println(Arrays.deepToString(arr));

		int[] array = { 1, 3, 5, 0 };
		for (int i = 0; i < array.length; i++) {
			int index = i;
			for (int j = 0; j < array.length; j++) {
			}
		}
	}

}
