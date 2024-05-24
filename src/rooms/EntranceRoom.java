package rooms;

import text_adventure.ActionParser;

public class EntranceRoom extends Room {

	@Override
	public void run() {
		if (state == 0)
			nextState();
	}

	private void nextState() {
		state++;

		switch (state) {
		case (1):
			printScenario1();
			break;

		}
	}

	public void printScenario1() {
		String text = """
				You arrive at the entrance of the wizard's tower
				The door leading outside has 3 keyholes: one red, one blue, and one yellow
				""";
		System.out.print(text);
	}

	@Override
	public void printRoom() {
		switch (state) {
		case 1:
			printRoom1();
			break;

		}
	}

	public void printRoom1() {
		String text = """
				You are at the entrance of the tower
				The door leading outside has 3 keyholes: one red, one blue, and one yellow
				""";
		System.out.print(text);
	}

	public void printEnterFoyer() {
		String text = """
				You leave the entrance and enter the foyer
				==========================================
				""";
		System.out.print(text);
	}

	@Override
	public void tryAction(String action) {
		String parsedAction = ActionParser.parseAction(player, action);

		switch (parsedAction) {
		case "help":
			ActionParser.printHelp();
			break;

		case "inspect room":
			printRoom();
			break;

		case "inv":
			player.inventory.print();
			break;

		case "combine":
			break;

		case "leave":
			printEnterFoyer();
			nextRoom = new FoyerRoom();
			break;

		case "open door":
		case "check door":
			// TODO
			break;

		default:
			System.out.println("Nothing happens");
		}

	}

}
