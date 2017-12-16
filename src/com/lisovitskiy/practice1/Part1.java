package com.lisovitskiy.practice1;

import java.util.*;

public class Part1 {
	public void drawFigure() {
		System.out.println("Hi! I can draw a Figure for you! Just enter the height: ");
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		String aFigurePart = "*";

		for (int i = 0; i < height; i++) {
			sb.append(aFigurePart);
			System.out.println(sb);
		}
		for (int j = 0; j < height; j++) {
			sb.delete(0, 1);
			System.out.println(sb);
		}
	}

	public static void main(String[] args) {
		Part1 p1 = new Part1();
		p1.drawFigure();
	}
}
