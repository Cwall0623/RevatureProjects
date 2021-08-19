package LEarning;

public class Simulator {
	public static void main(String[] args) {
		DogObject Fido = new DogObject();
		Fido.bark();
		Fido.name= "Fido";
		Fido.breed = "Golden Retriever";
		Fido.age = 3;
		
		DogObject scooby = new DogObject();
		scooby.name = "Scooby";
		scooby.name ="Scooby";
		scooby.age = 7;
		scooby.breed = "great dane";
		scooby.feed("Dick");
		}
	}
