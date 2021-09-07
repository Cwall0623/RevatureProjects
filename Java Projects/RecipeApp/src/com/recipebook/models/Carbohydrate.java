package com.recipebook.models;

import java.util.ArrayList;
import java.util.List;


public final class Carbohydrate extends Ingredient{

	
	private static int carbsCooked;
	
	private final int deliciousness = 8;
	
	//Final makes it so you cant change what the reference is. It mmust alwasy point to the same object in memory. 
	//You cant use assignment operator again. With this array list, you can alter it by adding and taking away 
	//in the list but the reference will never change. 
	private final List<String> sugars = new ArrayList<>();
	
	public void addSugars(String sugar) {
		this.sugars.add(sugar);
	}
	
	
	
	
	
	public Carbohydrate() {
		
		carbsCooked++;
	}
	
	public Carbohydrate(String name) {
		this.name = name;
	}
	
	
	public void printcarbsCooked() {
		System.out.println(carbsCooked);
	}
	
	@Override
	public void provideSustenance() {
		// TODO Auto-generated method stub
		System.out.println("IM your bodys energy");
		
		}
// this is a staoc method. I do not need an instance of my class to call this method.
	public static void beDelicious() {
		
		System.out.println("I am superior in flavor");
	}
	
}

//This does not compile because carbohydrate is a final class. 
//
//class DeliciousCakes extends Carbohydrate{
	
