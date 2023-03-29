package TestCase;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Puzzle.Puzzle;
import Puzzle.UI.GameFlow;
import Puzzle.UI.GameFlowFactory;
import Puzzle.UI.PlayerMode;
import Puzzle.UI.SolverMode;

class GameFlowFactoryTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testSolverMode() throws JSONException {
		String path = "json/example_puzzle.json";
		GameFlowFactory gff = new GameFlowFactory();
		GameFlow g = gff.getGameFlow("1", path);
		g.run();
		boolean exp = true;
		boolean result = g instanceof SolverMode;
		String msg = "Testing Solver mode";
		assertEquals(exp,result,msg);
}
	//Since the player mode require player input and command so It is difficult to perform a player mode test
	//We will skip here
//	@Test
//	void testPlayerMode() {
//		String path = "json/example_puzzle";
//		GameFlowFactory gff = new GameFlowFactory();
//		gff.getGameFlow("2", path);
//		boolean exp = false;
//		boolean result = gff.isSolverMode;
//		String msg = "Testing player mode";
//		assertEquals(exp,result,msg);
//}
}
