package TestCase;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Puzzle.Move;
import Puzzle.Puzzle;
import Puzzle.Logic.RuleSet;

class isTravelableTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testNotTravelable() throws JSONException {
		String path = "json/example_puzzle.json";
		Puzzle p = new Puzzle(path);
		RuleSet rs = new RuleSet(p);
		Move m = new Move("sheep",null,0,1);
		boolean result = rs.isTravelable(m);
		boolean exp = false;
		String msg = "Testing a role is not travelable";
		assertEquals(exp,result,msg);
	}
	
	@Test
	void testIsTravelable2() throws JSONException {
		String path = "json/example_puzzle.json";
		Puzzle p = new Puzzle(path);
		RuleSet rs = new RuleSet(p);
		Move m = new Move("farmer",null,0,1);
		boolean result = rs.isTravelable(m);
		boolean exp = true;
		String msg = "Testing a role is travelable";
		assertEquals(exp,result,msg);
		assertEquals(exp,result);
	}
	@Test
	void testEmptyTravelable() throws JSONException {
		String path = "json/example_puzzle.json";
		Puzzle p = new Puzzle(path);
		RuleSet rs = new RuleSet(p);
		Move m = new Move(null,null,0,1);
		boolean result = rs.isTravelable(m);
		boolean exp = false;
		String msg = "Testing no role is travelable";
		assertEquals(exp,result,msg);
		assertEquals(exp,result);
	}
	

}
