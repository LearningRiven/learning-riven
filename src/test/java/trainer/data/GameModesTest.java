package trainer.data;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GameModesTest {

	GameModes test;
	
	@Before
	public void setup() {
		test = new GameModes();
	}
	
	@Test
	public void testAllGameModes() {
		assertEquals("Total GameModes", 4, test.getAllGameModes().size());
	}
}
