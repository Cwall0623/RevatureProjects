package game;
import fixtures.Room;

public class RoomManager  {
	
	Room startingRoom;
	Room[] rooms = new Room[3];
	
	
	public void init() {
		// create rooms
	    Room livingRoom = new Room("The Living Room", "big living room", "A large living room with black leather couches. You see a book sitting on a table.\n");
	    Room bathroom = new Room("The Bathroom", "a small, dark bathroom", "White tile bathroom with floral design. Uh oh, Somebody forgot to flush the toilet..\n");
	    Room kitchen = new Room("The Kitchen", "a beautiful kitchen", "Big Kitchen with dark brown oak cabinets. There is a stainless steel Samsung Smart fridge\n");
	    
	    // add rooms to room array
	    this.rooms[0] = livingRoom;
	    this.rooms[1] = bathroom;
	    this.rooms[2] = kitchen;
	    
	    // link rooms and their exits
	    livingRoom.setExit(kitchen, 0);
	    kitchen.setExit(bathroom, 1);
	    kitchen.setExit(livingRoom, 2);
	    bathroom.setExit(kitchen, 3);
	    
	    this.startingRoom = kitchen;
	}
}
