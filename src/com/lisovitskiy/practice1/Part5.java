package com.lisovitskiy.practice1;

import java.util.Scanner;

public class Part5 {
	public int[][] createMatrix() {
		System.out.println("Please enter disirable size for your matrix: ");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[][] matrix = new int[size][size];
		int a = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matrix[i][j] = a;
				a++;
			}
		}
		return matrix;
	}

	public static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			for (int i : row) {
				System.out.print(i);
				System.out.print("\t");
			}
			System.out.println();
		}
	}

	public static int[][] rotateMatrixToRight90Degrees(int[][] matrix) {
		int layers = matrix.length / 2;
		for (int first = 0, last = matrix.length - first - 1; first < layers; last--, first++) {
			for(int elem = first; elem < last; elem++){
				int offset = elem - first;
				int top = matrix[first][elem];
				int right_side = matrix[elem][last];
				int bottom = matrix[last][last - offset];
				int left_side = matrix[last - offset][first];
				matrix[first][elem] = left_side;
				matrix[elem][last] = top;
				matrix[last][last-offset] = right_side;
				matrix[last-offset][first] = bottom;
			}
		}
		return matrix;
	}
	
	public static int[][] rotateMatrixToDegree(int degrees, int[][] matrix) {
		switch(degrees){
		case 90:
			rotateMatrixToRight90Degrees(matrix);
			break;
		case 180:
			rotateMatrixToRight90Degrees(matrix);
			rotateMatrixToRight90Degrees(matrix);
			break;
		case 270:
			rotateMatrixToRight90Degrees(matrix);
			rotateMatrixToRight90Degrees(matrix);
			rotateMatrixToRight90Degrees(matrix);
			break;
		default: System.out.println("Sorry, can't rotate your matrix. Please enter one of the following degree: 90, 180 or 270 and try again!");
				 System.out.println("And this was the matrix you tried to rotate:");
			break;
		}
		return matrix;
	}
	public static void main(String[] args) {
		Part5 pt5 = new Part5();
		int[][] matrix = pt5.createMatrix();
		printMatrix(matrix);
		System.out.println();
		printMatrix(rotateMatrixToDegree(90, matrix));
	}

}
