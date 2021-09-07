package com.recipebook.models;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.recipebook.exceptions.ImproperNameException;

public class Recipe {
	/*
	 * The name of our recipe
	 */
	private String name;
	
	/*
	 * The iunstructions to follow to complete the recipe
	 */
	private List<String> instructions;
	
	/* The list of ingredients in this ingredients, we are deciding to use a Map because
	 * we need a way to map ingredients to the quanities.
	 * 
	 * our key is the ingredient and our value is the underlying amount of the ingredient to use.
	 * 
	 * Returning To this map of ingredients, maps are different from collection implentations.
	 * 
	 * 1. maps are not in the collection hierarchy. map is its own interface separate from the collection interface.
	 * Maps are not iterable.
	 * 
	 * 2. Maps take two generics: one for the "key" and one for the "value".
	 * In order to acess an underlying value, we must use the key.
	 */
	private Map<Ingredient, String> ingredients = new HashMap<>();
	
	 public static void main(String[] args) {
		
	
	Carbohydrate sugar = new Carbohydrate("Sugar");
	Carbohydrate brownSugar = new Carbohydrate("Brown Sugar");
	Carbohydrate blueberries = new Carbohydrate("Blueberries");
	
		
		Recipe beignet = new Recipe();
		
		Map<Ingredient, String> ingredients = beignet.getIngredients();
		ingredients.put(sugar, "1/2 cup");
		ingredients.put(brownSugar, "3/4 cup");
		ingredients.put(blueberries, "1 cup");
		
		
		System.out.println(ingredients);
	
		System.out.println(ingredients.get(blueberries));
	
		Map<Ingredient, String> tableIngredients = new Hashtable<>();
		tableIngredients.put(sugar, "30 cups");
		System.out.println(tableIngredients);
	
		for (Ingredient i : ingredients.keySet()) {
			System.out.println(ingredients.get(i));
		}
	 }
	

	
	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws ImproperNameException{
		//lets use improper name exception to throw that exception when the caller attempts to set the name to empty
		
		if(name.length() < 1) {
			throw new ImproperNameException();
		}
		this.name = name;
	}

	public List<String> getInstructions() {
		return instructions;
	}

	public void setInstructions(List<String> instructions) {
		this.instructions = instructions;
	}

	public Map<Ingredient, String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Map<Ingredient, String> ingredients) {
		this.ingredients = ingredients;
	}

	public Recipe(String name, List<String> instructions, Map<Ingredient, String> ingredients) {
		super();
		this.name = name;
		this.instructions = instructions;
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Recipe [name=" + name + ", instructions=" + instructions + ", ingredients=" + ingredients + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ingredients, instructions, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recipe other = (Recipe) obj;
		return Objects.equals(ingredients, other.ingredients) && Objects.equals(instructions, other.instructions)
				&& Objects.equals(name, other.name);
	}
	
	
}
