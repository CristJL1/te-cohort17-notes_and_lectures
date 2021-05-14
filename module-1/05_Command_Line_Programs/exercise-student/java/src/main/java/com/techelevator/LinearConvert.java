package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		String inputDistance = "";

		String distanceType = "" ;

		System.out.println("Please enter a distance: ");

		inputDistance = keyboard.nextLine();

		System.out.println("Is your distance in (M)eters or (F)eet?: ");

		distanceType = keyboard.nextLine();

		if (distanceType.equals("F") || distanceType.equals("f") || distanceType.equals("Feet") || distanceType.equals("feet")) {
			double outputDistanceM = Double.parseDouble(inputDistance) * 0.3048;
			System.out.println(inputDistance + " feet is " + outputDistanceM + " meters");
		}
		else if (distanceType.equals("M") || distanceType.equals("m") || distanceType.equals("Meters") || distanceType.equals("meters")) {
			double outputDistanceF = Double.parseDouble(inputDistance) * 3.2808399;
			System.out.println(inputDistance + " meters is " + outputDistanceF + " feet");
		}
		else {
			System.out.println("User ID10T Error: Unusable Distance Type");
		}




	}

}
