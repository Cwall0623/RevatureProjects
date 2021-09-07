package com.recipebook.models;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
/*
 * This class is now a java Bean.This is a design pattern that indicates that a class has:
 * Constructor
 *Getters and Setters
 *HashCode method
 *equals method
 *ToString method
 *and, technically, should implement the serializable interface (not required)
 */

//We have made this class abstract, in doing so, we are now allowed to have abstract methods
//within this class.

//Also note that we can no longer an instance of the ingredient class as its abstract.
//Abstract classes do not have to have abstract methods - they simply can.




public  abstract class Ingredient implements Comparable<Ingredient>{
	
	// I placed this here so that this can technically be a JAva bean
	public Ingredient() {
		super();
	}
	/**
	 * the name of ingredient.
	 */
	protected String name;
	/**
	 * A description of the ingredient itself. It describes what the ingredient looks like
	 * Region,origin
	 */
	protected String description;
	
	/**
	 * The tastes that we associate with this ingredient
	 */
	protected Set<String> tastes;
	public  Ingredient(String name){
		//our custom no args constructor. we will use it to initialize our fields to some default values.
		//with a parameter, its not a no arg constructor now. We broke that rule and added a parameter.
		this.name = name;
		//Note that we have been using string literals the entire time, there are string constructors, (this.description = new String();)
		this.description = "N/a";
		this.tastes = new HashSet<>();
		
	}
	
	//this method can never be overriden in any classes due to final
	public final void provideEnergy() {
		System.out.println("Providing energy to keep you going");
		
	}
	
	public Ingredient(String name, String description, Set<String>tastes) {
		this.name = name;
		this.description = description;
		this.tastes = tastes;
	}
		//we need getters and setters
		// way of reading and writing to our fields, though an indirect way of doing so
	
	
	// THis is a basic method signature.
	//A method signature can also include non-access modifiers
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}		
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<String> getTastes() {
		return tastes;
	}
	public void setTastes(Set<String> tastes) {
		this.tastes = tastes;
	}
	@Override
	public String toString() {
		return "Ingredient [name=" + name + ", description=" + description + ", tastes=" + tastes + "]";
	}
	
	public void repairMuscles() {
		System.out.println("Not all ingredients repair muscles.");
	}
	
	public abstract void provideSustenance();
	
	// The toString method is inherited form the object class.
	//The toString method is used to provide a pretty string representation of our object.
	
	/*
	 * The hashCode method is inherited from the object class.
	 * AJva uses hashCode method to generate a random "hash" that is used to locate objects faster.
	 * Java sorts objects by hash code
	 */
	@Override
	public int hashCode() {
		return Objects.hash(description, name, tastes);
	}
	/*
	 * The equals method is inherited from the Object class. It is used to measure object equality by object 
	 * properites rather than memory address
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingredient other = (Ingredient) obj;
		return Objects.equals(description, other.description) && Objects.equals(name, other.name)
				&& Objects.equals(tastes, other.tastes);
	}
	
	// The @Override annotation is sued to provide some compile-time safety.
	//We are overriding the objects classes toString method,providing our implementation
	//here in the child class. If we are not properly overriding a method, the @OVerride
	//annotation will cause a compilation error (which is what we want)
	
	// We are overriding ther compareTo method from the Comparable interface. We use this method
	// to specify how to compare two instances of this class.
	// Ingredients should be ordered alphabetically, by using the "name" field
	
	@Override
	public int compareTo(Ingredient other){
		return this.name.compareTo(other.name);
	}
	
}

//The comparator interface is also used to compare instances of a type. That said,
//the method comparing the two instances is defined externally (outside of the class)

class IngredientComparator implements Comparator<Ingredient>{

	@Override
	public int compare(Ingredient o1, Ingredient o2) {
		return o1.name.compareTo(o2.name);
	}
	
}



