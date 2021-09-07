package com.recipe.repository;

import java.util.ArrayList;
import java.util.List;

import com.recipebook.models.Ingredient;
import com.recipebook.models.Protein;

//A class can implement as many interfaces as it wants to. Remeber that classes 
//can only extend one class directly. 

public class IngredientRepositoryImplimentation implements IngredientRepository {

	@Override
	public Ingredient getIngredient() {
		return new Protein("Salami");
	}

	@Override
	public List<Ingredient> getAllIngredients() {
		List<Ingredient> ingredients = new ArrayList<>();
		ingredients.add(new Protein("Seitan"));
		ingredients.add(new Protein("Pepperoni"));
		ingredients.add(new Protein("Tofu"));
		ingredients.add(new Protein("Beef"));
		
		return ingredients;
	}

	
}
