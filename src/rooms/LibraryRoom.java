package rooms;

import text_adventure.ActionParser;

public class LibraryRoom extends Room {

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
				Just as you try to enter the library, its door slams shut and starts talking
				"If you want to enter my library, you must solve my riddle!"
				"What has a head and a tail, but no body?"
				"If you check your pockets, you may have plenty!"
				""";
		System.out.print(text);
	}

	public void printScenario2() {
		String text = """
				"Correct!"
				The door opens and you enter the library
				""";
		System.out.print(text);
	}

	public void printRoom1() {
		String text = """
				You stand at the entrance to the library
				The talking book won't let you in until you solve its riddle
				""";
		System.out.print(text);
	}

	// TODO
	public void printRoom2() {
		String text = """

				""";
		System.out.print(text);
	}

	public void printEnterFoyer() {
		String text = """
				You leave the library and enter the foyer
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

		case "coin":
		case "coins":
		case "a coin":
			switch (state) {
			case 1:
				nextState();
				break;
			}

			break;

		case "leave":
			printEnterFoyer();
			nextRoom = new FoyerRoom();
			break;

		default:
			System.out.println("Nothing happens");
		}

	}
}
