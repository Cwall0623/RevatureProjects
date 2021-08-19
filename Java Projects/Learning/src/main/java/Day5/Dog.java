package Day5;

public class Dog {
	public String name;
	public String breed;
	public int age;
	public double weight;
	public boolean vaccination;
	public void bark() {
		System.out.println("woof");
		
	}
	/*
	 * Constructors are special methods, that are called as the first action
	 * when creating a new object. COnstructors have a few noticiable diffrerences between 
	 * normal methods. 1- the constructors name must match the name of the class exaclty
	 * 2 - constructors do not return any information
	 * 
	 *
	 */
	
				
	public Dog() {
		
	}
	// Syntax for a 'defualt' constructor
	 public Dog (String name, int weight) {
		 this.name = name;
		this.weight = weight;		 
		 breed = "no Breed";
		 age = 0;
	 }
	// Syntax for a paramterized constructor
	public Dog(String name, String breed, int age, double weight, boolean vaccination) {
		System.out.println("poplating fields on dog");
		this.name = name;
		this.breed = breed;
		this.age = age;
		this.weight = weight;
		this.vaccination = vaccination;
		
	}
	
	public void populateFields(String name, String breed, int age, double weight) {
		this.name = name;
		this.breed = breed;
		this.age = age;
		this.weight = weight;
	
	}

}
