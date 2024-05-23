package rooms;

public abstract class Room {
	int state = 1;

	public abstract void run();

	public abstract void parseAction(String action);

}
