package rooms;

import text_adventure.Player;

public abstract class Room {
	public Player player;
	int state = 0;
	public Room nextRoom;

	public abstract void run(); // Called when first entering a room

	public abstract void printRoom(); // Prints descriptive text of the room

	public abstract void tryAction(String action);

}
