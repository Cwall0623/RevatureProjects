package com.recipebook.lambdas;

import java.util.Collections;
import java.util.List;

import com.recipe.repository.IngredientRepositoryImplimentation;
import com.recipebook.models.Ingredient;

//Allow for more functional programming. they provide a more concise way of writing functions.
//Functional is a different programming paradigm to say Object Oriented Programming

public class Lambdas {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		System.out.println(calculator.add(4, 2));

		CalculatorInterface add = (int num1, int num2) -> num1 + num2;
		CalculatorInterface subtract = (num1, num2) -> num1 - num2;
		CalculatorInterface multiply = (num1, num2) -> num1 * num2;

		System.out.println(Lambdas.doSomeTypeOfMath(60, 60, add));

		List<Ingredient> ingredients = new IngredientRepositoryImplimentation().getAllIngredients();
		System.out.println("NON SORTED INGREDIENTS");
		System.out.println(ingredients);

		System.out.println("SORTED INGREDIENTS");
		Collections.sort(ingredients);
		System.out.println(ingredients);

		//Lets not sort in alphabetical order, lets use comparator. I do not want to create a new class just for a new sort.
		
		Collections.sort(ingredients, (o1, o2) -> {return -1 * o1.getName().compareToIgnoreCase(o2.getName());});
		
		System.out.println(ingredients);
	
	/*
	 * For you reference,some useful, builtin functional interfaces include:
	 * 
	 * Comparator
	 * Supplier
	 * Consumer
	 * BiConsumer
	 * Predicate
	 * Bipredicate
	 */
	
	
	
	
	
	
	
	
	
	
	
	}

	public static int doSomeTypeOfMath(int num1, int num2, CalculatorInterface calculator) {
		return calculator.mathOperation(num1, num2);

	}

}
