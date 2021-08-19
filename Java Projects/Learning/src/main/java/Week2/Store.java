package Week2;

public class Store {
	aisle[] aisles;
	aisle firstAisle;

public void init() {
	aisle breadAisle = new aisle("Bread Aisle", null,null);
	aisles[0] = breadAisle;
	aisle chipsAisle = new aisle("chips" , null, null);
	aisles[1] = chipsAisle;
	breadAisle.setNext(chipsAisle);
	chipsAisle.setPrev(breadAisle);
	firstAisle = breadAisle;
	
}
	public aisle getFirstAisle() {
		return firstAisle;
	}

}
