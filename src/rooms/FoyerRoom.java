package rooms;

import text_adventure.ActionParser;
import text_adventure.Player;

public class FoyerRoom extends Room {

	public FoyerRoom() {

	}

	public FoyerRoom(Player player) {
		this.player = player;
	}

	@Override
	public void run() {
		// The first time we run this room, go to the next state
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
				You enter a large foyer with several doors and passages
				The ones that stand out to you are:
				A passage that leads to a library
				A staircase leading down into the basement
				The front door of the tower
				""";
		System.out.print(text);
	}

	public void printRoom1() {
		String text = """
				You're in the foyer of the tower
				The room is lit up by multiple torches along the walls
				""";
		System.out.print(text);
	}

	@Override
	public void parseAction(String action) {
		String parsedAction = ActionParser.parseAction(action);

		switch (parsedAction) {
		case "help":
			ActionParser.printHelp();
			break;

		case "inspect room":
			switch (state) {
			case 1:
				printRoom1();

			}

			break;

		case "inv":
			player.inventory.print();
			break;

		default:
			System.out.println("Nothing happens");
		}

	}

}
