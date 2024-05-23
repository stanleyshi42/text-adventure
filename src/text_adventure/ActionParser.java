package text_adventure;

// Takes the player's input and parses it
public class ActionParser {
	public static String parseAction(String action) {
		String[] actions = action.split(" "); // Split player's input into tokens

		switch (action) {
		case "help":
			System.out.println("Common actions you can make include:");
			System.out.println("inspect room");
			System.out.println("check bag");
			return "";
		}

		switch (action) {
		case "inspect":
		case "inspect room":
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
		// case "kick":
		case "kick door":
			return "kick door";
		}

		// If action didn't match anything, return it
		return action;

	}
}
