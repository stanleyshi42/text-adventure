package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import text_adventure.ActionParser;
import text_adventure.Player;

public class ActionParserTest {
	Player player = new Player();

	@Test
	public void testParseAction() {
		assertEquals("inv", ActionParser.parseAction(player, "check inv"));
		assertEquals("inv", ActionParser.parseAction(player, "check inv asdf"));
		assertEquals("inv", ActionParser.parseAction(player, "bag"));
		assertEquals("inspect room", ActionParser.parseAction(player, "inspect"));
		assertEquals("asdf", ActionParser.parseAction(player, "asdf"));
	}
}
