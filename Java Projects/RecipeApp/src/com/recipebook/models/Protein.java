package com.recipebook.models;

import java.util.Set;

public class Protein extends Ingredient{
	public Protein() {
		
	}
	public Protein(String name) {
		// A call to the parent calss's constructor
		super(name);
	}
	public Protein(String name, String description, Set<String> tastes) {
		super(name, description, tastes);
		
		
	}
	@Override
	public void provideSustenance() {
		// TODO Auto-generated method stub
		System.out.println("provide protein as a macronutrient");
	}
	//@Override
	public void repairMuscles() {
		System.out.println("Really good at repairing muscles.");
	}

	//this is a protein specific method; it is not inherited form the ingredient class
	
	public void provideSatiety() {
		System.out.println("youll feel full");
	}

}
