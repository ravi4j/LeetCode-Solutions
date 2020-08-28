/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.july2020;

public class P014_Angle_Between_Hands_of_a_Clock {
	public static void main(String[] args) {
		P014_Angle_Between_Hands_of_a_Clock solution = new P014_Angle_Between_Hands_of_a_Clock();
		int hour = 12;
		int minutes = 30;
		double result = solution.angleClock(hour, minutes); // 165
		System.out.println(result);

		hour = 3;
		minutes = 30;
		result = solution.angleClock(hour, minutes); // 75
		System.out.println(result);

		hour = 3;
		minutes = 15;
		result = solution.angleClock(hour, minutes); // 7.5
		System.out.println(result);

		hour = 4;
		minutes = 50;
		result = solution.angleClock(hour, minutes); // 155
		System.out.println(result);

		hour = 12;
		minutes = 0;
		result = solution.angleClock(hour, minutes); // 155
		System.out.println(result);
	}

	public double angleClock(int hour, int minutes) {
		double hourAngle = ((hour * 60 + minutes) / 2.0) % 360.0;
		double minAngle = minutes * 6;
		double angle = Math.abs(minAngle - hourAngle);
		return Math.min(angle, 360 - angle);
	}
}
