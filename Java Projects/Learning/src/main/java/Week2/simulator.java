package Week2;

public class simulator {
	public static void main(String[] args) {
		
		Store store = new Store();
		
		store.init();
		customer player = new customer();
		player.setCurrentLocation(store.getFirstAisle());
		
		}
		public void changePlayerLocation(customer player) {
			
			aisle targetLocation = player.getCurrentLocation().moveForward();
			
			player.setCurrentLocation(targetLocation);
		}


}
