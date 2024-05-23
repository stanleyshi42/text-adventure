package text_adventure;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import rooms.DungeonRoom;

public class TextAdventureGame {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	Player player;

	DungeonRoom DungeonRoom;

	public TextAdventureGame() {

	}

	private void gameLoop() {
		while (true) {
			try {
				player.currentRoom.run();
				String input = reader.readLine().toLowerCase();
				player.currentRoom.parseAction(input);
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
				player.currentRoom = new DungeonRoom(player); // Place the player in the first room

				gameLoop();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
