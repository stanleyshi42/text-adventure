package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import text_adventure.ActionParser;

public class ActionParserTest {
	@Test
	public void testParseAction() {
		assertEquals("inv", ActionParser.parseAction("check inv"));
		assertEquals("inv", ActionParser.parseAction("check inv asdf"));
		assertEquals("inv", ActionParser.parseAction("bag"));
		assertEquals("inspect room", ActionParser.parseAction("inspect"));
		assertEquals("asdf", ActionParser.parseAction("asdf"));
	}
}
