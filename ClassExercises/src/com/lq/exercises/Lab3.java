/**
 * 
 */
package com.lq.exercises;

/**
 * 
 */
public class Lab3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		String[] monthNames = {"January", "Feburary", "March", "April", "May",
				"July", "June", "August", "September", "October", 
				"November", "December"};
		
		System.out.println("start of output for exercise 1: standard loop");
		for(int i=0; i<7; i++) {
			System.out.println(daysOfWeek[i]);
		}
		
		System.out.println("\nstart of output for exercise 1: reverse loop");
		for(int j=6; j>=0; j--) {
			System.out.println(daysOfWeek[j]);
		}
		
		System.out.println("\nstart of output for exercise 2");
		int count = 1;
		while(count++ < 20) {
			if(count%2 == 1) {
				continue;
				}
			System.out.print(count + " ");
		}
		
		System.out.println("\nstart of output for exercise 3");
		for(int x=1; x<=100; x++) {
			if( (x>=50) && (x<=60) ) {
				continue;
			}
			System.out.print(x + " ");
		}
		
		System.out.println("\nstart of output for exercise 4");
		int monthCount = 1;
		while (monthCount <= 12) {
			switch (monthCount) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				System.out.println("There are 31 days in " + monthNames[monthCount-1]);
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				System.out.println("There are 30 days in " + monthNames[monthCount-1]);
				break;
			case 2:
				System.out.println("There are 28 days in " + monthNames[monthCount-1]);
				break;
			default:
				System.out.println("Error, invalid month number");
			}
			monthCount++;
		}
		
		System.out.println("\nStart of output for Challenge Exercise");
		int left_off = 4;
		boolean printing = false;
		int dayCount = 1;
		System.out.println("Sun Mon Tue Wed Thu Fri Sat");
		for ( int y = 0; y < 6; y++ ) {
			for ( int x = 0; x < 7; x++ ) {
				if ( printing == false ) {
					System.out.print("     ");
					if ( x == left_off ) {
						printing = true;
					}
				} else if ( dayCount < 10 ) {
					System.out.print(dayCount + "    ");
					dayCount++;
				} else {
					System.out.print(dayCount + "   ");
					dayCount++;
					if ( dayCount > 31 ) {
						break;
					}
				}
			}
			System.out.println();
		}
	}
}
