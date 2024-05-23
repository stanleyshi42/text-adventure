package text_adventure;

import rooms.Room;

public class Player {
	public String name;
	public Inventory inventory = new Inventory();
	public Room currentRoom;

	public Player() {
		this("Player");
	}

	public Player(String name) {
		this.name = name;
	}

}
