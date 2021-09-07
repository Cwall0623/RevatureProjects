package com.recipebook;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import com.recipe.repository.IngredientRepositoryImplimentation;
import com.recipebook.models.Carbohydrate;
import com.recipebook.models.Ingredient;
import com.recipebook.models.Protein;
import com.recipebook.models.Recipe;


/*
 * You can only have one public class per file.
 */
public class Driver {
	public static void main(String[] args) {
		//Our ingredients, now taken from the ingredient repository we created.
		
		IngredientRepositoryImplimentation iri = new IngredientRepositoryImplimentation();
		List<Ingredient> ingredients = iri.getAllIngredients();
		System.out.println(ingredients);
		
		
		
		
		//This is called covariance. Covariance is a term is when we use a super type
		// as a reference while the instance is a child class.
		Ingredient fish = new Protein("fish");
		System.out.println(fish);
		
		
		
	
		
		//our recipes
		
		Recipe garlicBread = new Recipe();
		// Instruction for creating a garlic bread as a list
		
		List<String> instructions = new LinkedList<>();
		instructions.add("Go to the store and buy frozen garlic bread");
		instructions.add("open the bag when you get home.");
		instructions.add("add extra garlic to the bread");
		instructions.add("add to oven");
		instructions.add("take it out of the oven");
		instructions.add("c o n s u m e");
		
		//Looping through a list
		for(int i = 0; i < instructions.size(); i++) {
			System.out.println(instructions.get(i));	
			
		}
		
		System.out.println(instructions.get(4));
		
		//Enhanced for Loop
		for(String step : instructions) {
			System.out.println(step);
		}
		
		
		
		// Generics enforce compile time safety. BY using them, we have guaranteed,
		// that every element that is added to this set must be of type string.
		//When using Generics, please not that primitives are not supported
		//If you wish to use a primitive type
		//use the wrapper class representation for it instead.
		
		// int -> Integer
		// char -> Character
		//boolean -> Boolean
		//byte -> Byte
		//double -> Double
		//long -> Long
		//float -> Float
		//short -> Short
		Set<String> tastes = new HashSet<>();
		tastes.add("savory");
		tastes.add("unamai");
		tastes.add("bold");
		tastes.add("pungent");
		
		//Note that
		
		/*
		 * LEts make some more ingredients:
		 */
	
		//NOte that we have to iterate over a set to access the elements:
		
		//Traditional for loop
		for(int i = 0; i < tastes.size(); i++) {
			//but sets do not support access to elements by index...
		}
		
		//Enhanced forloop/for-each loop
		for(String taste : tastes) {
			System.out.println(taste);
		}
		
		//Iterator approach
		
		Iterator<String> it = tastes.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		// we need to revisit this example because we cant add ingredients unless they are sorted.
		
		System.out.println("QUEUE OUTPUT");
		
		Queue<Ingredient> queuedIngredients = new PriorityQueue<>();
		queuedIngredients.offer(ingredients.get(0));
		queuedIngredients.offer(ingredients.get(1));
		System.out.println(queuedIngredients);
		
		//NOte that we can alos use a Deque, which is a double ended queue. This means that we can use it as a Queue or a Stack.
		// AS such, we can use offer() and poll() to use it as a stack, but we can also use the methods such as
		// pop() to remove elements from the back of the queue and push() to add elements to the back of the queue.
		
		Deque<Ingredient> dequedIngredients = new ArrayDeque<>();

		
		
		
		
		
		
		
		
		
		// java is adding a object type integer (autoboxing)
		//its making it into an object
		Set<Integer> mynums = new HashSet<>();
		mynums.add(3);
		
		Integer aNUm = 4;
		
		int secondNum = 8;
		
		int result = aNUm + secondNum; //auto-unboxing, because youre adding a prim type to a object
				
		
		Ingredient ingredient1 = new Protein("Chicken", "can never have enough of this", tastes);
		
		//Not require to know instanceof keywords, it can be useful to see what type the object is
		if(ingredient1 instanceof Carbohydrate) {
			Carbohydrate carb = (Carbohydrate) ingredient1;
		}
			
		
		
	//cooking carbs
		
	Carbohydrate spaghetti = new Carbohydrate();
	Carbohydrate rice = new Carbohydrate();
	Carbohydrate cake = new Carbohydrate();
	
	cake.printcarbsCooked();
	rice.printcarbsCooked();
	spaghetti.printcarbsCooked();
	
	Carbohydrate.beDelicious();
	
	// Proof of concept for the String Pool
	String myIneffiecientName = new String("Cjay");//memory inefficient, it creates a new object in the String Pool
	String myName = "Cjay";
	String mom = "Kimberly";
	String myNameAgain = "Cjay";
	
	System.out.println(myName == myIneffiecientName);
	
	//String are immutable.
	String myFullName = myName.concat(" Wall");
	
	System.out.println(myFullName);
	
	//If you want to use something that "feels" like a mutable String, you can use either String Builder or StringBuffer.
	
	StringBuilder sBuilder = new StringBuilder("a starting String");
	System.out.println(sBuilder);
	sBuilder.append(" That now has more content");
	System.out.println(sBuilder);
	
	System.out.println(Collections.min(ingredients));
	Collections.sort(ingredients);
	
	
	
	}
	
}
