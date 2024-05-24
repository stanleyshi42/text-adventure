package rooms;

import text_adventure.ActionParser;
import text_adventure.Item;

public class BasementRoom extends Room {

	boolean hasBlueKey = true;
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
				You enter the basement, but it's too dark to see anything
				If only you had a light source...
				""";
		System.out.print(text);
	}

	public void printScenario2() {
		String text = """
				You use your torch to light up the room, allowing you to see your surroundings
				The basement is quite small and only contains a dusty desk and a chest
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
				You're in the basement, but it's too dark to see anything
				If only you had a light source...
				""";
		System.out.print(text);
	}

	public void printRoom2() {
		String text = """
				With your torch, you're able to see the room now
				The room contains a desk and a chest
				""";
		System.out.print(text);
	}

	public void printEnterFoyer() {
		String text = """
				You leave the basement and enter the foyer
				==========================================
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

		case "check desk":
			if (this.hasBlueKey) {
				player.inventory.add(Item.BLUE_KEY);
				this.hasBlueKey = false;
				System.out.println("You rummage through the desk and find a blue key!");
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
				System.out.println("You open the chest, which contains a candle");
				System.out.println("You put the candle in your backpack");
			} else {
				System.out.println("You open the chest again, but it's empty");
			}
			break;

		case "inv":
			player.inventory.print();
			break;

		case "use torch":
			if (player.inventory.has(Item.TORCH))
				nextState();
			else
				System.out.println("Nothing happens");
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
