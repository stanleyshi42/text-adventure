package rooms;

import text_adventure.ActionParser;
import text_adventure.Item;

public class BasementRoom extends Room {

	boolean hasRedKey = true;

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
		case (3):
			printScenario3();
			break;
		case (4):
			printScenario4();
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
				The basement is quite small and just contains a pedestal holding an unlit candle sitting in a candle holder
				""";
		System.out.print(text);
	}

	public void printScenario3() {
		String text = """
				You light the candle and the pedestal disappears in a puff of smoke
				A new pedestal takes its place. It holds an empty candle holder
				""";
		System.out.print(text);
	}

	public void printScenario4() {
		String text = """
				You place your lit candle in the candle holder
				From the candle's flame, a red key emerges and flies into your backpack!
				With that, the pedestal disappears in a puff of smoke
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
		case 3:
			printRoom3();
			break;
		case 4:
			printRoom4();
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
				With your torch, you're able to see the basement clearly now
				The room contains a pedestal holding an unlit candle in a candle holder
				""";
		System.out.print(text);
	}

	public void printRoom3() {
		String text = """
				With your torch, you're able to see the basement clearly now
				The room contains a pedestal holding an empty candle holder
				""";
		System.out.print(text);
	}

	public void printRoom4() {
		String text = """
				With your torch, you're able to see the basement clearly now
				It looks like there's nothing left to do here
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
		String parsedAction = ActionParser.parseAction(player, action);
		System.out.println(state);

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

		case "use torch":
			if (player.inventory.has(Item.TORCH) && state == 1)
				nextState();
			else if (player.inventory.has(Item.TORCH) && state == 2)
				nextState();
			else
				System.out.println("Nothing happens");
			break;

		case "plaece lit candle":
		case "use lit candle":
			if (player.inventory.has(Item.LIT_CANDLE) && state == 3)
				nextState();
			else
				System.out.println("Nothing happens");
			break;

		case "plaece candle":
		case "use candle":
			if (player.inventory.has(Item.CANDLE) && state == 3) {
				System.out.println("You place your candle in the candle holder, but nothing happens");
				System.out.println("You take the candle back");
			} else
				System.out.println("Nothing happens");
			break;

		case "take candle":
			System.out.println("You try taking the candle, but it doesn't budge");
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
