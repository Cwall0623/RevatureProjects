package fixtures;


public class Room extends Fixture{
	
	Room[] exits;
	Fixture[] fixtures;
	
	
	
	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
		this.exits = new Room[4]; 

	}
	
	public Room[] getExists() {
		return this.exits;
	}
	
	public void setExit(Room room, int direction) {
		this.exits[direction] = room;
	}
	
	public Room getExit(String direction) {
		if (direction == "north") {
			return exits[0];
		}
		else if (direction == "east") {
			return exits[1];
		}
		else if (direction == "south") {
			return exits[2];
		}
		else if (direction == "west") {
			return exits[3];
		} else {
			return null;
		}
	}
	
	
}
