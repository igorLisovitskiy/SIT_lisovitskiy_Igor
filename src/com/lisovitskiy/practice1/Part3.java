package com.lisovitskiy.practice1;

import java.util.Scanner;

public class Part3 {
	public void drawWallpapers() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter  the number of stripes for your future wallpaper: ");
		int numberOfStripes = sc.nextInt();
		System.out.println("And now, please enter the width of the pattern for your future wallpaper: ");
		int width = sc.nextInt();
		System.out.println("One last thing, please enter the height: ");
		int height = sc.nextInt();
		String plusPattern = "+";
		String asteriskPattern = "*";
		StringBuilder plusStripe = new StringBuilder();
		StringBuilder asteriskStripe = new StringBuilder();
		for (int j = 0; j < width; j++) {
			plusStripe.append(plusPattern);
			asteriskStripe.append(asteriskPattern);
		}
		for (int show = 0; show < height; show++) {
			for (int i = 0; i < numberOfStripes / 2; i++) {
				System.out.print(plusStripe);
				System.out.print(asteriskStripe);
			}
			System.out.println();
		}
		System.out.println("Thanks, enjoy your beautiful walpaper!");
	}

	public static void main(String[] args) {
		Part3 pt3 = new Part3();
		pt3.drawWallpapers();
	}

}
