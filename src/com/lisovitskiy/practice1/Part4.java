package com.lisovitskiy.practice1;

import java.util.Arrays;

public class Part4 {
	public double[] createRandomArray(int size) {
		double[] randomArr = new double[size];
		for (int i = 0; i < size; i++) {
			randomArr[i] = Math.random();
		}
		System.out.println(Arrays.toString(randomArr));
		return randomArr;
	}

	public void createDoubledRandomArr(double[] arr) {
		double[] doubledArr = new double[arr.length * 2];
		System.arraycopy(arr, 0, doubledArr, 0, arr.length);

		for (int j = 0, i = arr.length; j < arr.length; j++, i++) {
			doubledArr[i] = arr[j] * 2;
		}
		System.out.println(Arrays.toString(doubledArr));
	}

	public static void main(String[] args) {
		Part4 pt4 = new Part4();
		double[] tenElementsArray = pt4.createRandomArray(10);
		pt4.createDoubledRandomArr(tenElementsArray);

	}

}
