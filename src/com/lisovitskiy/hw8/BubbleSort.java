package com.lisovitskiy.hw8;

import java.util.Arrays;

public class BubbleSort {
	public static int[] bubleSort(int[] array) {

		for (int i = array.length - 1; i >= 0; i--) {
			for (int j = 1; j <= i; j++) {
				if (array[j] <= array[j - 1]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
		return array;
	}

	public static void main(String[] args) {
		int[] arrToSort = { 16, 15, 14 };
		bubleSort(arrToSort);
		System.out.println(Arrays.toString(bubleSort(arrToSort)));
	}

}
