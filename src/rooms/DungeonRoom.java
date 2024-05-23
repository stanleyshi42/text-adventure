package rooms;

import text_adventure.ActionParser;
import text_adventure.Player;

public class DungeonRoom extends Room {
	Player player;

	public DungeonRoom(Player player) {
		this.player = player;
	}

	@Override
	public void run() {
		switch (state) {
		case (0):
			printScenario1();
			break;

		}

	}

	public void printScenario1() {
		System.out.println(". . . . .");
		System.out.println("You awaken to find yourself in the cell of a dimly lit dungeon");
		System.out.println("The last thing you remember is approaching a wizard's tower");
		System.out.println("Did the wizard imprison you? In any case, you don't plan on staying here forever");
		System.out.println("All you have is your trusty backpack, though emptied of its contents");
		System.out.println("What will you do?");
		state++;

	}

	public void printRoom1() {
		System.out.println(
				"You're in a tiny cell in a dark dungeon. All you can see is the ancient, rusty cell door in front of you. You could probably force it open with a good kick");
	}

	@Override
	public void parseAction(String action) {
		String parsedAction = ActionParser.parseAction(action);

		switch (parsedAction) {
		case "inspect":
			switch (state) {
			case 1:
				printRoom1();
				break;
			}
			break;

		case "inv":
			player.inventory.print();
			break;

		default:
			System.out.println("Nothing happens");
			break;
		}

	}

}
