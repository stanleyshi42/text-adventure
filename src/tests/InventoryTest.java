package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import text_adventure.Inventory;
import text_adventure.Item;

public class InventoryTest {
	Inventory inventory = new Inventory();

	@Test
	public void testAdd() {
		ArrayList<Item> testInventory = new ArrayList<Item>();
		testInventory.add(Item.TORCH);

		inventory.add(Item.TORCH);

		assertEquals(testInventory, inventory.inventory);
	}

}
