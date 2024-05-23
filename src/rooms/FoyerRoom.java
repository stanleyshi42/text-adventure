package rooms;

import text_adventure.ActionParser;
import text_adventure.Item;
import text_adventure.Player;

public class FoyerRoom extends Room {

	boolean torchItem = true;

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
				The front entrance of the tower
				""";
		System.out.print(text);
	}

	public void printRoom1() {
		String text = """
				You're in the foyer of the tower
				The room is lit up by multiple torches lining the walls
				From here, you can go to the library, basement, or front entrance
				""";
		System.out.print(text);
	}

	public void printBasementMove() {
		String text = """
				You walk down the staircase into the basement
				""";
		System.out.print(text);
	}

	@Override
	public void tryAction(String action) {
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

		case "take torch":
			if (!player.getInventory().contains(Item.TORCH)) {
				player.inventory.add(Item.TORCH);
				torchItem = false;
				System.out.println("You take a torch from the wall");
			} else {
				System.out.println("You already have a torch");
			}

			break;

		case "enter library":

			break;

		case "enter basement":
			printBasementMove();
			nextRoom = new BasementRoom();
			break;

		case "enter entrance":

			break;

		default:
			System.out.println("Nothing happens");
		}

	}

}
