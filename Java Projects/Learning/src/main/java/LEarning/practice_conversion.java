package LEarning;

import java.util.Scanner;

public class practice_conversion {
public static void main(String[] args) {
	// Declare Scanner
	Scanner sc = new Scanner(System.in);
	//Decalre the int
	int menuSelection = 0 ;
	//make the while loop a condition not equal to the stoppage value
	while (menuSelection !=2) {
		// Show the menu on the console
		System.out.println("Enter A calculation \n 1. inches to feet \n 2. Quit");
		// Input loop with scanner so the user can input a value
		menuSelection = sc.nextInt();
		// Now declar switch with what input is needed
		switch(menuSelection) {
		
		case 1:
			System.out.println("Enter Amount of inches");
			//Put nextDouble/String/Int for expectation of input
			double inches = sc.nextDouble();
			double feet = inches / 12;
			// Put system.out.print(result) to display results
			System.out.println(feet + " feet");
			break;
		case 2:
			break;
		default:
			System.out.println("Wrong input Try Again");
				
			}
		}	
	}
}