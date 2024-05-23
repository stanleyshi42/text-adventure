package rooms;

public abstract class Room {
	int state = 0;

	public abstract void run();

	public abstract void parseAction(String action);

}
