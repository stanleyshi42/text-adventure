package rooms;

import text_adventure.ActionParser;

public class BasementRoom extends Room {

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
				You enter the basement, but it's too dark to see anything
				If only you had a light source...
				""";
		System.out.print(text);
	}

	public void printRoom1() {
		String text = """
				You try to look around, but it's too dark to see anything
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

		case "leave":
			
			break;

		}
	}
}
