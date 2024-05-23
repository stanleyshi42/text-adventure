package textAdventure;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import Rooms.DungeonRoom;
import Rooms.Room;

public class TextAdventureGame {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	Player player;

	Room DungeonRoom = new DungeonRoom();

	public TextAdventureGame() {

	}

	private void gameLoop() {
		while (true) {
			try {

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void play() {
		while (true) {
			try {
				System.out.println("Welcome to Super Text Adventure!");
				System.out.println("Enter name:");
				String input = reader.readLine();
				this.player = new Player(input);
				gameLoop();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
