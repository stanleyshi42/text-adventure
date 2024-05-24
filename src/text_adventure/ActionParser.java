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

		switch (actions[0]) {
		case "move":
		case "go":
			if (actions.length > 1)
				switch (actions[1]) {
				case "upstairs":
				case "up stairs":
				case "downstairs":
				case "down stairs":
					return "take stairs";
				}
			break;
		case "take stairs":
			return "take stairs";

		}

		switch (actions[0]) {
		case "enter":
		case "move":
		case "go":
		case "check":
			if (actions.length > 1)
				switch (actions[1]) {
				case "basement":
					return "enter basement";
				case "library":
					return "enter library";
				}
			break;

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

		// If action didn't match anything, return it
		return action;
	}

	public static void printHelp() {
		String text = """
				A voice in your head tells you...
				Some common actions you can input include:
				check room
				check bag
				enter [room]
				leave
				take [item]
				use [item]
				""";
		System.out.print(text);
	}
}
