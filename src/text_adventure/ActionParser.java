package text_adventure;

// Takes the player's action and parses it
public class ActionParser {
	public static String parseAction(String action) {
		String[] actions = action.split(" "); // Split player's input into tokens

		switch (action) {
		case "inspect":
		case "inspect room":
		case "look around":
			return "inspect";

		}

		// Checks first token
		switch (actions[0]) {
		case "check":
		case "open":
			// Checks second token
			switch (actions[1]) {
			case "inventory":
			case "backpack":
			case "bag":
			case "inv":
				return "inv";
			}

		case "inventory":
		case "backpack":
		case "bag":
		case "inv":
			return "inv";

		default:
			return action;
		}
	}
}
