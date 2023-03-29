package TestCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Puzzle.UI.PlayerModeController;

class GameInfoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testPrintGameInfo() throws Exception {
		String path = "json/example_puzzle.json";
		PlayerModeController pms = new PlayerModeController(path);
		String result = pms.printGameInfo();
		String exp = "The puzzle name: 	Farmer-tiger-sheep-grass\n"
				+ "The game description: 		tiger eat sheep, but farmer can protect sheep. Sheep eat grass if farmer not around. Only farmer can drive the boat. Move all the character to another land to win\n"
				+ "The game roles: 		[farmer, tiger, sheep, grass]";
		assertEquals(exp,result);
	}
	
}
