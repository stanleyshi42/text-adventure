package rooms;

import text_adventure.Player;

public abstract class Room {
	public Player player;
	int state = 0;
	public Room nextRoom;

	public abstract void run();

	public abstract void tryAction(String action);

}
