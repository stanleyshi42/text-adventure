package text_adventure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import rooms.DungeonRoom;
import rooms.MainHallRoom;

public class TextAdventureGame {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	Player player;

	// Instantiate all of the game's rooms

	DungeonRoom dungeon = new DungeonRoom();
	MainHallRoom mainHall = new MainHallRoom();

	private void gameLoop() {
		while (true) {
			try {
				player.currentRoom.run();
				String input = reader.readLine().toLowerCase();
				player.currentRoom.parseAction(input);

				if (player.currentRoom.nextRoom != null) {
					player.currentRoom = player.currentRoom.nextRoom;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void play() {
		while (true) {
			try {
				System.out.println("Welcome to Super Text Adventure!");
				System.out.println("Enter your character's name:");
				String input = reader.readLine();

				this.player = new Player(input);
				player.currentRoom = dungeon; // Place the player in the starting room
				dungeon.player = player;

				gameLoop();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
