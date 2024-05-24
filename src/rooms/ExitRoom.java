package rooms;

public class ExitRoom extends Room {

	@Override
	public void run() {
		System.out.println("You've escaped the wizard's tower!");
		System.out.println("Congratulations!");
		System.exit(0);
	}

	@Override
	public void printRoom() {
	}

	@Override
	public void tryAction(String action) {
	}

}
