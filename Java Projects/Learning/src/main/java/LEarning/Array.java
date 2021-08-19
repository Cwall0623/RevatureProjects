package LEarning;

public class Array {
	public static void main(String[] args) {
		/* Below shoes the first method od creating arrays.
		*
		*/
		int[] numArray = new int[5];		
		
		String[] strArray = new String [5];
	
		/* the second method we can use to create an array. Still using the new key word
		 * we can declare a new array object but here, we can populate the array with values.
		*/
		int [] numArrayTwo = new int[] { 1,2,3,4,5};
		
		// we can create anonymous arrays and assign them to an
		//array reference variable, when creating the reference variable in that same line
		
		
		int[] numArrayThree =  new int [] {99,88,77,66,55,44,33,22,11};
		numArrayThree[0] = 5;
		System.out.println(numArrayThree[0]);
		System.out.println(numArrayThree[1]);
		System.out.println(numArrayThree[2]);
		System.out.println(numArrayThree[3]);
		System.out.println(numArrayThree[0]);
		System.out.println(numArrayThree.length);
		
		// Object o = new Object();
		// Arrays use an index, which is the numerical 
		//position of elemnts (data inside an araay) within an array that is created.
		//Indexing for most programming languages and entities which are indexed start at 0
		//Length is a property of Arrays that tell us how many elements an array can hold
		
		
	}
}
