package rooms;

import text_adventure.ActionParser;
import text_adventure.Item;
import text_adventure.Player;

public class FoyerRoom extends Room {

	boolean hasTorch = true;

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

				The staircase leading back into the dungeon
				A passage leading to the wizard's private study
				A staircase leading down into the basement
				The entrance of the tower
				""";
		System.out.print(text);
	}

	public void printRoom() {
		switch (state) {
		case 1:
			printRoom1();
			break;

		}
	}

	public void printRoom1() {
		String text = """
				You are in the foyer of the tower
				The room is illuminated up by multiple torches lining the walls
				From here, you can go to the dungeon, study, basement, or the tower's entrance
				""";
		System.out.print(text);
	}

	public void printDungeonMove() {
		String text = """
				You descend down into the dungeon
				=================================
				""";
		System.out.print(text);
	}

	public void printStudyMove() {
		String text = """
				You head down the passage towards the wizard's study
				====================================================
				""";
		System.out.print(text);
	}

	public void printBasementMove() {
		String text = """
				You take the staircase into the basement
				========================================
				""";
		System.out.print(text);
	}

	public void printEntranceMove() {
		String text = """
				You walk to the entrance of the tower
				=====================================
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

		case "take torch":
			if (this.hasTorch) {
				player.inventory.add(Item.TORCH);
				this.hasTorch = false;
				System.out.println("You take a torch from the wall");
			} else {
				System.out.println("You already have a torch");
			}

			break;

		case "enter dungeon":
			printDungeonMove();
			nextRoom = new DungeonRoom();
			break;

		case "enter study":
			printStudyMove();
			nextRoom = new StudyRoom();
			break;

		case "enter basement":
			printBasementMove();
			nextRoom = new BasementRoom();
			break;

		case "enter entrance":
			printEntranceMove();
			nextRoom = new EntranceRoom();
			break;

		default:
			System.out.println("Nothing happens");
		}

	}
}
