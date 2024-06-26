package text_adventure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import rooms.BasementRoom;
import rooms.DungeonRoom;
import rooms.EntranceRoom;
import rooms.WinRoom;
import rooms.StudyRoom;
import rooms.FoyerRoom;
import rooms.Room;

public class TextAdventureGame {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	Player player;

	// Instantiate all of the game's rooms
	public DungeonRoom dungeon = new DungeonRoom();
	public FoyerRoom mainHall = new FoyerRoom();
	public StudyRoom library = new StudyRoom();
	public BasementRoom basement = new BasementRoom();
	public EntranceRoom entrance = new EntranceRoom();
	public WinRoom exit = new WinRoom();

	private void gameLoop() {
		while (true) {
			try {
				player.currentRoom.run();
				String input = reader.readLine();
				player.currentRoom.tryAction(input);

				// When the next room is selected, move to that room and print descriptive text
				if (player.currentRoom.nextRoom != null) {
					Room nextRoom = player.currentRoom.nextRoom;
					player.currentRoom.nextRoom = null;

					if (nextRoom instanceof DungeonRoom) {
						player.currentRoom = dungeon;
						player.currentRoom.printRoom();
					} else if (nextRoom instanceof FoyerRoom) {
						player.currentRoom = mainHall;
						player.currentRoom.printRoom();
					} else if (nextRoom instanceof StudyRoom) {
						player.currentRoom = library;
						player.currentRoom.printRoom();
					} else if (nextRoom instanceof BasementRoom) {
						player.currentRoom = basement;
						player.currentRoom.printRoom();
					} else if (nextRoom instanceof EntranceRoom) {
						player.currentRoom = entrance;
						player.currentRoom.printRoom();
					} else if (nextRoom instanceof WinRoom) {
						player.currentRoom = exit;
						player.currentRoom.printRoom();
					}

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Initialize various values for the game
	public void play() {
		while (true) {
			try {
				System.out.println("Welcome to Super Text Adventure!");
				System.out.println("Enter your character's name:");
				String input = reader.readLine();

				this.player = new Player(input);
				player.currentRoom = dungeon; // Place the player in the starting room

				dungeon.player = player;
				mainHall.player = player;
				library.player = player;
				basement.player = player;
				entrance.player = player;
				exit.player = player;

				gameLoop();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
