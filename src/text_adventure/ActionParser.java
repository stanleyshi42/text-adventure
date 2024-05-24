package text_adventure;

// Takes the player's input and parses it
public class ActionParser {
	public static String parseAction(Player player, String action) {
		action = action.trim().toLowerCase();
		String[] actions = action.split(" "); // Split player's input into tokens

		// General actions
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
		case "check":
		case "inspect":
			if (actions.length > 1)
				switch (actions[1]) {
				case "ground":
					return "check ground";
				case "floor":
					return "check ground";
				}
		}

		switch (actions[0]) {
		case "enter":
		case "move":
		case "go":
		case "check":
			if (actions.length > 1)
				switch (actions[1]) {
				case "dungeon":
					return "enter dungeon";
				case "foyer":
					return "enter foyer";
				case "study":
					return "enter study";
				case "basement":
					return "enter basement";
				case "entrance":
					return "enter entrance";
				}
		}

		switch (action) {
		case "leave":
		case "leave room":
			return "leave";
		}

		switch (action) {
		case "check progress":
		case "progress":
			return "check progress";
		}

		// Logic for combining two items
		switch (actions[0]) {
		case "combine":
			if (actions.length > 2) {
				if (Item.combine(player, actions[1], actions[2]) != null) {
					System.out.println("You light the candle with your torch");

				}
			}
			return "combine";

		}

		// More specific actions
		switch (action) {
		case "kick":
			System.out.println("Kick what?");
			return "";
		case "kick door":
			return "kick door";
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

				You can try combining items with:
				combine [item] [item]

				If you ever want to do something, try:
				[verb] [object]
				""";
		System.out.print(text);
	}
}
