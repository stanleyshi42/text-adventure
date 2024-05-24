package rooms;

import text_adventure.ActionParser;
import text_adventure.Item;
import text_adventure.Player;

public class DungeonRoom extends Room {

	boolean hasBlueKey = true;

	public DungeonRoom() {

	}

	public DungeonRoom(Player player) {
		this.player = player;
	}

	@Override
	public void run() {
		// The first time we run this room, go to the state 1
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
		case (5):
			printScenario5();
			break;
		}
	}

	public void printScenario1() {
		String text = """
				. . . . .
				You awaken to find yourself in the cell of a dimly lit dungeon
				The last thing you remember is approaching a wizard's tower
				Did the wizard imprison you? In any case, you don't plan on staying here forever
				All you have is your trusty backpack, although its been emptied of its contents
				What will you do?
				""";
		System.out.print(text);
	}

	public void printScenario2() {
		System.out.println("You give the door a good kick, but it doesn't budge. Maybe one more will do it");
	}

	public void printScenario3() {
		String text = """
				With your second kick, the door flies open!
				You exit your cell into a long dungeon hallway lined with cells
				At the end of the hall is a stairway leading up
				""";
		System.out.print(text);
	}

	public void printScenario4() {
		String text = """
				You use your torch to light up the room
				Now that you can see better, you notice something shiny on the ground
				""";
		System.out.print(text);
	}

	public void printScenario5() {
		String text = """
				You inspect the shiny object on the ground and see that it is a blue key
				You put the key in your backpack
				""";
		System.out.print(text);
	}

	// Print descriptive room text based on the state of the room
	public void printRoom() {
		switch (state) {
		case 1:
		case 2:
			printRoom1();
			break;
		case 3:
			printRoom3();
			break;
		case 4:
			printRoom4();
			break;
		case 5:
			printRoom5();
			break;
		}
	}

	public void printRoom1() {
		String text = """
				You're trapped in the tiny cell of a dark dungeon
				All you can see is the ancient, rusty cell door in front of you. You could probably force it open with a good kick
				""";
		System.out.print(text);

	}

	public void printRoom3() {
		String text = """
				You're in a long, dimly lit dungeon hallway. There are stairs leading up at the end of the hall
				""";
		System.out.print(text);
	}

	public void printRoom4() {
		String text = """
				You're in a long dungeon hallway. There are stairs leading up at the end of the hall
				With your torch, you are able to see better and you notice something shiny on the ground
				""";
		System.out.print(text);
	}

	public void printRoom5() {
		String text = """
				You're in a long dungeon hallway. There are stairs leading up at the end of the hall
				It looks like there's nothing left to do here
				""";
		System.out.print(text);
	}

	public void printFoyerMove() {
		System.out.println("You approach the stairway and start ascending its steps...");
		try {
			for (int i = 0; i < 0; i++) { // TODO increase wait time
				Thread.sleep(500);
				System.out.print(".");
			}
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println();
		System.out.println("After what feels like an eternity, you finally reach the top of the stairway!");
		System.out.println("=============================================================================");

		// Select the next room to move to
		nextRoom = new FoyerRoom();
	}

	@Override
	// Perform player's action depending on the state of the room
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

		case "kick door":
			// Check if we are in a state where the door can be kicked down
			switch (state) {
			case 1:
				nextState();
				break;
			case 2:
				nextState();
				break;
			default:
				System.out.println("Nothing happens");
			}

			break;

		case "take stairs":
		case "leave":
			// Check if we are in a state where we are able leave the room
			if (state >= 3)
				printFoyerMove();
			else
				System.out.println("Nothing happens");
			break;

		case "use torch":
			if (player.inventory.has(Item.TORCH) && state == 3)
				nextState();
			else
				System.out.println("Nothing happens");
			break;

		case "check ground":
			switch (state) {
			case 4:
				player.inventory.add(Item.BLUE_KEY);
				hasBlueKey = false;
				nextState();
				break;
			default:
				System.out.println("Nothing happens");
			}
			break;

		default:
			System.out.println("Nothing happens");
		}

	}

}
