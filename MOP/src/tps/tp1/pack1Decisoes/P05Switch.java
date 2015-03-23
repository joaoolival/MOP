package tps.tp1.pack1Decisoes;

import java.util.Scanner;

public class P05Switch {

	public static void main(String[] args) {
		Scanner keyboard = new java.util.Scanner(System.in);

		System.out.println("Insert one month number -> ");

		String monthName = null;
		String totallyPartly = null;
		String seasonName = null;
		boolean error = false;

		int month = keyboard.nextInt();
		switch (month) {
		case 1:
			monthName = "January";
			totallyPartly = "Totally";
			seasonName = "Winter";
			break;
		case 2:
			monthName = "February";
			totallyPartly = "Totally";
			seasonName = "Winter";
			break;
		case 3:
			monthName = "March";
			totallyPartly = "Partly";
			seasonName = "Winter";
			break;
		case 4:
			monthName = "April";
			totallyPartly = "Totally";
			seasonName = "Spring";
			break;
		case 5:
			monthName = "May";
			totallyPartly = "Totally";
			seasonName = "Spring";
			break;
		case 6:
			monthName = "June";
			totallyPartly = "Partly";
			seasonName = "Spring";
			break;
		case 7:
			monthName = "July";
			totallyPartly = "Totally";
			seasonName = "Summer";
			break;
		case 8:
			monthName = "August";
			totallyPartly = "Totally";
			seasonName = "Summer";
			break;
		case 9:
			monthName = "September";
			totallyPartly = "Partly";
			seasonName = "Summer";
			break;
		case 10:
			monthName = "October";
			totallyPartly = "Totally";
			seasonName = "Fall";
			break;
		case 11:
			monthName = "November";
			totallyPartly = "Totally";
			seasonName = "Fall";
			break;
		case 12:
			monthName = "December";
			totallyPartly = "Partly";
			seasonName = "Fall";
			break;
		default:
			monthName = "Please a number between 1 and 12";
			error = true;
			break;
		}

		if (error == false) {
			System.out.println("The month name is " + monthName + ", is "
					+ totallyPartly + " on " + seasonName);
			System.out.println();
		}

		keyboard.close();

	}

}
