package trainer.data;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ChampionsTest {
	
	Champions test;
	
	@Before
	public void setup() {
		test = new Champions();
	}
	
	@Test
	public void testAllChampions() {
		assertEquals("Total GameModes", 156, test.getAllChampions().size());
	}
}
