package rooms;

import text_adventure.ActionParser;

public class StudyRoom extends Room {

	boolean hasYellowKey = true;

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
				As you are about to enter the wizard's private study, its door slams shut and begins speaking
				"Halt! If you want to enter this study, you must solve my riddle!"
				"What has a head and a tail, but no body?"
				"If you check your pockets, you may have plenty!"
				""";
		System.out.print(text);
	}

	// TODO
	public void printScenario2() {
		String text = """
				"Correct!"
				The door opens and you enter the study
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

	// TODO
	public void printRoom2() {
		String text = """
				print room 2
				""";
		System.out.print(text);
	}

	public void printEnterFoyer() {
		String text = """
				You leave the study and enter the foyer
				=========================================
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
			printRoom();
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
