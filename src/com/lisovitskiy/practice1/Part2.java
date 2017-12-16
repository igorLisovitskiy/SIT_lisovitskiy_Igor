package com.lisovitskiy.practice1;

public class Part2 {
	public static void main(String[] args) {
		Part2 pt2 = new Part2();
		pt2.showPrimesToNumber(100);
	}

	public void showPrimesToNumber(int end) {
		StringBuilder primeNumbers = new StringBuilder();
		for (int i = 1; i <= end; i++) {

			int counter = 0;
			for (int j = i; j >= 1; j--) {
				if (i % j == 0) {
					counter = counter + 1;
				}
			}
			if (counter == 2) {
				primeNumbers.append(i);
				primeNumbers.append(",");
			}
		}
		System.out.println("Prime numbers from 2 to " + end + " are:");
		System.out.println(primeNumbers.substring(0, primeNumbers.length() - 1));
	}

}