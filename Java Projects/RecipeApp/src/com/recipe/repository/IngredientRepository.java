package com.recipe.repository;

import java.util.List;

import com.recipebook.models.Ingredient;

/*
 * The point of having a repository is to use it
 * as a way of accessing data and passing it to other
 * parts of your application.
 * 
 * It is actually quite typical to have an interface that specifies what
 * actions your repository should allow for. For Instance, should your repository
 * allow for the retrieval of records,the creation of new ingredients(In this case). Other types 
 * of basic CRUD (Create, REad, Update, Delete).
 * 
 * Remember that interfaces are implicitly "abstract". When we implements an interface, it must implement all of the methods defined 
 * on the interface(If such methods do not have an implementation).
 */
public interface IngredientRepository {

		
	public static final int a_num = 8;
	
	
	//although we dont need fields for this interface, you can have fields as long 
	//as they are public static and final
	
	/*
	 *	In java 8, methods on interfaces can actually have implementations if you use either the
	 *default or static keyword. 
	 */
	
	default void defaultImplementation() {
		
		System.out.println("This is a default implementation.");
	}
	
	/*
	 *The assumption about methods on an interfac is that they are public and abstract by default 
	 */
	
	/**
	 * All implemetning classes should implement a method that allows for the retrieval of a single
	 * ingredient
	 * @return
	 */
			
	
	public abstract Ingredient getIngredient();	
	
	
	
	/**
	 * All implementing classes should implement a method that allows for the retrieval of every single
	 * ingredient in our database ingredients.
	 * @return
	 */
	List<Ingredient> getAllIngredients();	
	
}
