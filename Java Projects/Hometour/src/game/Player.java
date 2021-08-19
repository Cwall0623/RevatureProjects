package game;
import fixtures.Room;

public class Player {	
	Room currentRoom;
		
	public Room getCurrentRoom() {
		return this.currentRoom;
	}
	
	public void setCurrentLocation(Room location) {
		currentRoom = location;
	}
}