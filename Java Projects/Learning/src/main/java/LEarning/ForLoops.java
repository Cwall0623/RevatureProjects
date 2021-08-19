package LEarning;

public class ForLoops {
	public static void main(String[] args) {
		
		//For loops are the most common looping structure to use wheen
		//you want to perform actions utilizing some types of data structure
		
		//For Loop Syntax:
		// for(initilization; condition; modification) {}
		
		// Initialization : A statement that will execute one time BEfore our for loop runs
		// condition: A boolean statement that will determine
		//whether or not we will repeat execution of our loop. 
		//This is evaluated at the start of each looping cycle.
		
		//Modification : A Statement tha will execute at the end of each of our looping cycles.
		//Typically this statement will change a vairable that is created
		// during the initialization step
	
	
			for(int x = 0; x <10; x = x + 1) {
				System.out.println(x);
			}
			
			int[] numbers = new int[] {55,66,33,77,88};
			System.out.println("NOrmal for loop");
			for (int i = 0; i < numbers.length; i++) {
				
				System.out.println(numbers[i]);
			
			}
			
			//Enhanced for loop uses a slightly different syntax
			//Instead of an initialization,condition and modification
			//we instead decalre a variable whose datatype matches the collection.
			System.out.println("enhanced For loop");
			for (int n : numbers) {
				System.out.println(n);
			}
			
			
	
	}
}
