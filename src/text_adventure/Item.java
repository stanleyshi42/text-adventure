package text_adventure;

// Various items the player can find in the game
public enum Item {
	TORCH, CANDLE, LIT_CANDLE, SPELL_TOME, RED_KEY, BLUE_KEY, YELLOW_KEY;

	// Given two items, try to combine them
	public static Item combine(Player player, String item1, String item2) {
		item1 = item1.trim().toLowerCase();
		item2 = item2.trim().toLowerCase();

		switch (item1) {
		case "torch":
			switch (item2) {
			case "candle":
				if (player.inventory.has(TORCH) && player.inventory.has(CANDLE)) {
					player.getInventory().add(LIT_CANDLE);
					player.getInventory().remove(CANDLE);
					return LIT_CANDLE;
				}
				break;

			default:
				break;
			}
		case "candle":
			switch (item2) {
			case "torch":
				if (player.inventory.has(TORCH) && player.inventory.has(CANDLE)) {
					player.getInventory().add(LIT_CANDLE);
					player.getInventory().remove(CANDLE);
					return LIT_CANDLE;
				}
				break;

			default:
				break;
			}
		default:
			break;
		}

		return null;
	}
}
