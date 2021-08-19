package game;
import fixtures.Room;
import java.util.Scanner;


public class Main extends RoomManager{
	
	public static void main(String[] args) {
		// main game loop
		
		// create player
		Player player = new Player();
		
		// initialize rooms
		RoomManager rm = new RoomManager();
		rm.init();
		
		// set player's starting room
		player.setCurrentLocation(rm.startingRoom);
		
		while (true) {
			// print current room & description
			Main.printRoom(player);
			
			// print exits and direction
			Room[] adjRooms = player.currentRoom.getExists();
			for (int i = 0; i <= 3; i++) {
				if (adjRooms[i] != null) {
					String dir = "null";
					switch(i) {
						case 0:
							dir = "North";
							break;
						case 1:
							dir = "East";
							break;
						case 2:
							dir = "South";
							break;
						case 3:
							dir = "West";
							break;
						default:
							break;
					}
					
					System.out.println(dir + ": " + adjRooms[i]);
				}
			}
			
			// accept user input
			Main.parse(Main.collectInput(), player);
		}
	}
				
	private static void printRoom(Player player) {
		System.out.println();
		System.out.println(player.getCurrentRoom().getName());
		System.out.println(player.getCurrentRoom().getLongDescription());
	}
	
	private static String[] collectInput() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return input.split(" ");
		
	}
	
	private static void parse(String[] command, Player player) {
		switch (command[0]) {
			// moves player direction
			case "go":
				switch (command[1]) {
					case "north": Main.changePlayerLocation(player, 0);
					break;
					case "east": Main.changePlayerLocation(player, 1);
					break;
					case "south": Main.changePlayerLocation(player, 2);
					break;
					case "west": Main.changePlayerLocation(player, 3);
					break;
					default: System.out.println("Error");
					break;
				}
			break;
			
			case "read":
				switch (command[1]) {
					case "book": System.out.println("You pick up the book and it reads \n C-Jay Is the Most Handsome Guy in the world \n Written By C-Jay Wall .\n");
					break;
					default: System.out.println("Error: wrong item");
					break;
				}
			break;
			
			case "check":
				switch (command[1]) {
				case "fridge": System.out.println("Your fridge is full!\n");
				break;
				default: System.out.println("Error: wrong item");
				break;
			}
			break;
			
			case "flush":
				switch (command[1]) {
				case "toilet": System.out.println("You watch the toilet water spin..\n");
				break;
				default: System.out.println("Error: wrong item");
				break;
			}
			break;
			
			case "quit":
				System.out.println("Thanks for playing!");
				System.exit(0);
				break;
			
			default: System.out.println("Error: wrong command");
			break;
		}
	}
	
	public static void changePlayerLocation(Player player, int direction) {
		// get available exits
		Room[] exits = player.getCurrentRoom().getExists();
		
		// switch players room to specified direction
		// (0:north, 1:east, 2:south, 3:west)
		player.setCurrentLocation(exits[direction]);
	}
	
	
}