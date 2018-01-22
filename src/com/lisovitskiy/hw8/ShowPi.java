package com.lisovitskiy.hw8;

import java.util.Formatter;

public class ShowPi {
	public static final double PI = Math.PI;

	public static void printPi(int lines) {
		for (int i = 1; i <= lines; i++) {
			System.out.printf("%." + i + "f%n", PI);
		}
	}

	public static void printFormatterPi(int lines) {
		for (int i = 1; i <= lines; i++) {
			try (Formatter fmt = new Formatter()) {
				fmt.format("%." + i + "f%n", PI);
				System.out.print(fmt);
			}
		}

	}

	public static void main(String[] args) {
		System.out.println("Method printf():");
		printPi(5);
		System.out.println("Formatter Object:");
		printFormatterPi(6);
	}
}
