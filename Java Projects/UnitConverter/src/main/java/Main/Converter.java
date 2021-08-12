package Main;

import java.util.Scanner;

public class Converter {
	public static void main(String[] args) {
		boolean pauseMenuSelection = false;
		Scanner sc = new Scanner(System.in);
		int menuSelection = 0;
		while(menuSelection != 4) {
			if (pauseMenuSelection == true) {
			System.out.println("Want do another calculation? \n 1. For Dollars to Yen \n 2. For Fahrenheit to Celcius \n 3. For Miles to Kilometers \n 4. Quit");
			}
			else
			System.out.println("Please Select an option \n 1. Dollars to Yen \n 2. Fahrenheit to Celcius \n 3. Miles to Kilometers \n 4. Quit");
			
			menuSelection = sc.nextInt();
			
			
			switch(menuSelection) {
			case 1: 
				System.out.println("Enter Dollar Amount");
				double dollars = sc.nextDouble();
				double yen = dollars * 110.36;
				System.out.println(yen + " Japanese Yen");
				pauseMenuSelection = true;
				
				break;
			case 2:
				System.out.println("Enter Temperature In Fahrenheit");
				double fahrenheit = sc.nextDouble();
				double celcius = (fahrenheit - 32) * 5/9;
				System.out.println(celcius + " celcius");
				pauseMenuSelection = true;
				break;
			case 3:
				System.out.println("Enter Distance In Miles");
				double miles = sc.nextDouble();
				double kilometers = miles * 1.60934;
				System.out.println(kilometers + " kilometers");
				pauseMenuSelection = true;
				break;
			case 4:
				break;
			default:
				System.out.println("Invalid Input, Please Try Again");
			}	
			
		}
		
	}
}
