package TestCase;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Puzzle.Puzzle;
import Puzzle.PuzzleState;
import Puzzle.Logic.RuleSet;

class RuleSetTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testIsWin() throws JSONException {
		String path = "json/example_puzzle.json";
		Puzzle p = new Puzzle(path);
		RuleSet r = new RuleSet(p);
		ArrayList<String> TlandA = new ArrayList<String>(Arrays.asList());
		ArrayList<String> TlandB = new ArrayList<String>(Arrays.asList("farmer", "sheep","tiger", "grass"));
		PuzzleState tps = new PuzzleState(TlandA,TlandB,1);
		boolean result = r.isWin(tps);
		boolean exp = true;
		String msg = "Testing a win case";
		assertEquals(exp,result,msg);
	}
	
	@Test
	void testNotWin2() throws JSONException {
		String path = "json/example_puzzle.json";
		Puzzle p = new Puzzle(path);
		RuleSet r = new RuleSet(p);
		ArrayList<String> TlandA = new ArrayList<String>(Arrays.asList("grass"));
		ArrayList<String> TlandB = new ArrayList<String>(Arrays.asList("farmer", "sheep","tiger"));
		PuzzleState tps = new PuzzleState(TlandA,TlandB,1);
		boolean result = r.isWin(tps);
		boolean exp = false;
		String msg = "Testing a not win case";
		assertEquals(exp,result,msg);
	}

}
