package com.recipebook.exceptions;

import com.recipebook.models.Recipe;

public class ImproperNameException extends Exception{

	public static void main(String[] args) {
		try { 
			throw new ImproperNameException();
		}catch(ImproperNameException e) {
			e.printStackTrace();
	
		}
	
	
	
	Recipe bananaBread = new Recipe();
	try {
	bananaBread.setName("");
	}catch(ImproperNameException e ) {
		e.printStackTrace();
		System.out.println("PLease enter a valid recipe");
	}
	}

	
}
