package text_adventure;

// Takes the player's input and parses it
public class ActionParser {
	public static String parseAction(String action) {
		action = action.trim();
		String[] actions = action.split(" "); // Split player's input into tokens

		switch (action) {
		case "hint":
		case "commands":
		case "instructions":
		case "help":
			return "help";
		}

		switch (action) {
		case "inspect":
		case "inspect room":
		case "check room":
		case "look around":
			return "inspect room";
		}

		// Checks first token
		switch (actions[0]) {
		case "check":
		case "open":
			// Checks second token
			if (actions.length > 1)
				switch (actions[1]) {
				case "inventory":
				case "backpack":
				case "bag":
				case "inv":
					return "inv";
				}
			break;

		case "inventory":
		case "backpack":
		case "bag":
		case "inv":
			return "inv";
		}

		switch (action) {
		case "kick":
			System.out.println("Kick what?");
			return "";
		case "kick door":
			return "kick door";
		}

		switch (action) {
		case "leave":
		case "leave room":
			return "leave";
		}

		switch (action) {
		case "move upstairs":
		case "move up stairs":
		case "go upstairs":
		case "go up stairs":
		case "move downstairs":
		case "move down stairs":
		case "go downstairs":
		case "go down stairs":
		case "take stairs":
			return "take stairs";
		}

		switch (action) {
		case "go to basement":
		case "go basement":
		case "enter basement":
		case "enter the basement":
		case "basement":
			return "enter basement";
		}

		// If action didn't match anything, return it
		return action;
	}

	public static void printHelp() {
		String text = """
				A voice in your head tells you...
				Some common actions you can input include:
				check room
				check bag
				leave room
				take [item]
				use [item]
				""";
		System.out.print(text);
	}
}
