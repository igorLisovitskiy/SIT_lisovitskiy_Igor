package com.lisovitskiy.hw8;

public class TimeToAngleDegrees {
	//This method calculates the angle between hour and minute hands
	public static int toDegrees(String time) {
		int resultingAngle = 0;
		if (time.length() == 5) {
			int hours = Integer.parseInt(time.split(":")[0]);
			int minutes = Integer.parseInt(time.split(":")[1]);
			double angleHours = (12 - hours) * 30;
			double angleMinutes = minutes * 6;
			resultingAngle = (int) Math.abs(angleHours + angleMinutes);
		} else {
			System.out.println("Incorrrect time format. Please try again in forman hh:mm");
		}

		return resultingAngle;
	}

	public static void main(String[] args) {
		System.out.println("The agle between clock hands at 20:12 is: " + toDegrees("20:12") + " degrees.");
		System.out.println("The agle between clock hands at 15:10 is: " + toDegrees("15:10") + " degrees.");
		System.out.println("The agle between clock hands at 18:00 is: " + toDegrees("18:00") + " degrees.");
		System.out.println("The agle between clock hands at 12:25 is: " + toDegrees("12:25") + " degrees.");
	}
}
