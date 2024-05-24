package rooms;

import text_adventure.Player;

public abstract class Room {
	public Player player;
	// Tracks the state of the room. When the player performs certain actions, the
	// room will increment to its next state
	int state = 0;
	public Room nextRoom;

	public abstract void run(); // Called when first entering the room

	public abstract void printRoom(); // Prints descriptive text of the room

	public abstract void tryAction(String action);

}
