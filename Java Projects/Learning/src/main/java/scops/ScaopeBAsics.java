
	
/*Scopes indicate isolated levels in our program which dictate where and for how long we have access
 * tocertain variables.
 * 
 * Varaibles which are created within a particular scope are lost, the moment we leave the contextr of that scope.
 * 
 * There are 4 levels of scope:
 * Static/Class - variables which will exist throughout
 * the entire lifetime of our program.
 * 
 * Instance/Object- variables which exist so long as we have creatred an object
 * and that object is accessible through its reference variable pointing to that object.
 * 
 * Method -  Variables which are created within a method and are lost
 * once we exit the context/body of that method.
 * This includes a methods parameters
 * 
 * Block - variables which are created within flow control statement within a method.
 * 
 */
	package scops;

	public class ScaopeBAsics {

		public static String stcWord;
		public String objWord;
		
		public void method(String mtdWord) {
			mtdWord = "Changed within method";
		if (true) {
			String blockword = "Withing if statement";
			
			
		}
//		 System.out.println(blockword); out of scope 
		}
		public static void main(String[] args) {
			String mainMethodWord = "main method word";
			
		}
	
	}
