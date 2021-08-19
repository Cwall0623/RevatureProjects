package Week2;

public class aisle {
	String aisleName;
	aisle next;
	aisle prev;
	aisle[] connections;
	product[] products;
	
	
	public aisle(String aisleName, aisle next, aisle prev, product...products) {
	this.aisleName = aisleName;
	this.next = next;
	this.prev = prev;
	this.products = products;
	
	}

	public aisle getConnectedAisle(String direction) {
	if(direction == "north")
		return connections[0];
	
	return this;
	
}
	public aisle moveForward () {
		return this.next;
		
	}
	public aisle moveBackward() {
		return this.prev;
	}
	public void setNext(aisle next) {
		this.next = next;
	}
	public void setPrev(aisle prev) {
		this.prev = next;
	}

}