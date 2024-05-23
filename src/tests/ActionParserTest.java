package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import text_adventure.ActionParser;

public class ActionParserTest {
	@Test
	public void parseActionTest() {
		assertEquals("inv", ActionParser.parseAction("check inv"));
		assertEquals("inv", ActionParser.parseAction("check inv asdf"));
		assertEquals("inv", ActionParser.parseAction("bag"));
		assertEquals("inspect room", ActionParser.parseAction("inspect"));
		assertEquals("asdf", ActionParser.parseAction("asdf"));
	}
}
