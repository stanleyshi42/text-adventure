package rooms;

import text_adventure.ActionParser;
import text_adventure.Player;

public class DungeonRoom extends Room {

	public DungeonRoom() {

	}

	public DungeonRoom(Player player) {
		this.player = player;
	}

	@Override
	public void run() {
		// The first time we run this room, go to the next state
		if (state == 0)
			nextState();
	}

	// When the player makes progress, increment state and print the new scenario
	private void nextState() {
		state++;

		switch (state) {
		case (1):
			printScenario1();
			break;
		case (2):
			printScenario2();
			break;
		case (3):
			printScenario3();
			break;
		case (4):
			printScenario4();
			break;
		}
	}

	public void printScenario1() {
		System.out.println(". . . . .");
		System.out.println("You awaken to find yourself in the cell of a dimly lit dungeon");
		System.out.println("The last thing you remember is approaching a wizard's tower");
		System.out.println("Did the wizard imprison you? In any case, you don't plan on staying here forever");
		System.out.println("All you have is your trusty backpack, although its been emptied of its contents");
		System.out.println("What will you do?");
	}

	public void printScenario2() {
		System.out.println("You give the door a good kick, but it doesn't budge. Maybe one more will do it");
	}

	public void printScenario3() {
		System.out.println("With your second kick, the door flies open!");
		System.out.println("You exit your cell into a long dungeon hallway lined with cells");
		System.out.println("At the end of the hall is a stairway leading up");
	}

	public void printScenario4() {
		System.out.println("You approach the stairway and start ascending its steps...");
		try {
			for (int i = 0; i < 0; i++) {
				Thread.sleep(1000);
				System.out.print(".");
			}
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println();
		System.out.println("After what feels like an eternity, you finally reach the top of the stairway");

		// Create the next room to enter
		nextRoom = new MainHallRoom();
		state++;
	}

	public void printScenario5() {
		System.out.println("This is the dungeon you awakened in. There doesn't appear to be anything of use here");
	}

	public void printRoom1() {
		System.out.println(
				"You're in a tiny cell in a dark dungeon. All you can see is the ancient, rusty cell door in front of you. You could probably force it open with a good kick");
	}

	public void printRoom3() {
		System.out.println("You're in a long dungeon hallway. There are stairs leading up at the end of the hall");
	}

	@Override
	public void parseAction(String action) {
		String parsedAction = ActionParser.parseAction(action);

		switch (parsedAction) {
		case "inspect room":
			switch (state) {
			case 1:
			case 2:
				printRoom1();
				break;
			case 3:
				printRoom3();
				break;
			}

			break;

		case "inv":
			player.inventory.print();
			break;

		case "kick door":
			switch (state) {
			case 1:
				nextState();
				break;
			case 2:
				nextState();
				break;
			}
			break;

		case "leave":
			switch (state) {
			case 3:
				nextState();
				break;
			case 5:
				printScenario4();
				break;
			}
			break;

		default:
			System.out.println("Nothing happens");
		}

	}

}
