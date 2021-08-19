package LEarning;

public class BreakAndContinue {
	public static void main(String[] args) {
		
		for (int i =0; i < 10; i++) {
			
			System.out.println(i);
			if (i == 5) {
				System.out.println("I is 5, Lets stop Here!");
			break;
			}
		}
		System.out.println("LABELS");
		System.out.println("Continue with Label:");
		alphabet : for (char letter = 'A'; letter < 'E'; letter++) {
		numeric : for(int number = 0; number < 4; number++) {
				if (number == 2) {
					continue;
				}
				System.out.println(letter + " : " + number);
			
				}
		}

	//A label is an arbitrarily named identifier that can be placed on loops
	
		
		
	
	}
	
}
