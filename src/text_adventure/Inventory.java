package text_adventure;

import java.util.ArrayList;

public class Inventory {
	public ArrayList<Item> inventory = new ArrayList<>();

	public void add(Item item) {
		inventory.add(item);
	}

	public boolean has(Item item) {
		return inventory.contains(item);
	}

	public void print() {
		System.out.println("You rummage through your backpack and find...");
		if (inventory.isEmpty())
			System.out.println("Nothing!");
		else
			for (Item i : inventory) {
				System.out.println(i);
			}
	}

}
