package rooms;

import text_adventure.ActionParser;
import text_adventure.Item;

public class StudyRoom extends Room {

	boolean hasYellowKey = true;
	boolean hasCandle = true;

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
		case (2):
			printScenario2();
			break;

		}

	}

	public void printScenario1() {
		String text = """
				Just as you are about to enter the wizard's private study, its door slams shut and begins speaking

				"Halt! If you want to enter this study, you must solve my riddle!"
				"What has a head and a tail, but no body?"
				"If you check your pockets, you may have plenty!"
				""";
		System.out.print(text);
	}

	public void printScenario2() {
		String text = """
				"Correct!"
				The talking door opens and you enter the study. Despite being a wizard's study, it's quite plain
				The only things of note are a desk, a chest, and a bookcase
				""";
		System.out.print(text);
	}

	public void printRoom() {
		switch (state) {
		case 1:
			printRoom1();
			break;
		case 2:
			printRoom2();
			break;

		}
	}

	public void printRoom1() {
		String text = """
				You stand at the entrance to the study
				The talking door won't let you in until you solve its riddle
				"What has a head and a tail, but no body?"
				"If you check your pockets, you may have plenty!"
				""";
		System.out.print(text);
	}

	public void printRoom2() {
		String text = """
				You are in the wizard's private study
				The only things of note are a desk, a chest, and a bookcase
				""";
		System.out.print(text);
	}

	public void printEnterFoyer() {
		String text = """
				You leave the study and enter the foyer
				=======================================
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

		case "coin":
		case "coins":
		case "a coin":
			switch (state) {
			case 1:
				nextState();
				break;
			}

			break;

		case "check desk":
			if (this.hasYellowKey) {
				player.inventory.add(Item.YELLOW_KEY);
				this.hasYellowKey = false;
				System.out.println("You rummage through the desk and find a yellow key!");
				System.out.println("You take the key and put it in your backpack");
			} else {
				System.out.println("You rummage through the desk, but find nothing of value");
			}

			break;

		case "open chest":
		case "check chest":
			if (this.hasCandle) {
				player.inventory.add(Item.CANDLE);
				this.hasCandle = false;
				System.out.println("You open the chest, which contains a candle!");
				System.out.println("You put the candle in your backpack");
			} else {
				System.out.println("You check the chest again, but it's empty");
			}
			break;

		case "check bookshelf":
		case "check bookcase":
			String text = """
					You approach the bookcase and reach for a random book
					The moment your finger touches it, a teleportation spell is cast on you!
					The next thing you know, you find yourself back in the dungeon
					==============================================================
					""";
			System.out.print(text);
			this.nextRoom = new DungeonRoom();
			break;

		default:
			System.out.println("Nothing happens");
		}

	}
}
