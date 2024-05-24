package text_adventure;

// Various items the player can find in the game
public enum Item {
	TORCH, CANDLE, LIT_CANDLE, SPELL_TOME, RED_KEY, BLUE_KEY, YELLOW_KEY;

	public static Item combine(Inventory inv, Item item1, Item item2) {
		if (item1 == TORCH && item2 == CANDLE)
			return LIT_CANDLE;
		if (item1 == CANDLE && item2 == TORCH)
			return LIT_CANDLE;

		return null;

	}
}
