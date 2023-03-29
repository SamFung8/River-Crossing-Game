package TestCase;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Puzzle.Move;
import Puzzle.Puzzle;
import Puzzle.Logic.Response;
import Puzzle.Logic.RuleSet;

class IsValidMoveTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testIsValidMove1() throws JSONException {
		Puzzle p = new Puzzle("json/violate_cc.json");
		RuleSet ruleSet = new RuleSet(p);
		Response res = ruleSet.isValidMove(p.getInitialState(), new Move("tiger", "sheep", 0,1));
		String result = res.toString();
		String exp = "Response [bol=false, str=Conflict rule violated (tiger, sheep), Reason: Tiger ate sheep]";
		String msg = "Testing violating conflict rule without other conflict exception";
		assertEquals(exp,result,msg);
	}
	
	@Test
	void testIsValidMove2() throws JSONException {
		Puzzle p = new Puzzle("json/accept_cc.json");
		RuleSet ruleSet = new RuleSet(p);
		Response res = ruleSet.isValidMove(p.getInitialState(), new Move("tiger", "sheep", 0,1));
		String result = res.toString();
		String exp = "Response [bol=true, str=]";
		String msg = "Testing violating conflict rule but with other conflict exception";
		assertEquals(exp,result,msg);
	}
	@Test
	void testIsValidMove3() throws JSONException {
		Puzzle p = new Puzzle("json/violate_ec.json");
		RuleSet ruleSet = new RuleSet(p);
		Response res = ruleSet.isValidMove(p.getInitialState(), new Move("farmer", "grass", 0,1));
		String result = res.toString();
		String exp = "Response [bol=false, str=Coexist rule violated (farmer, sheep), Reason: farmer must with sheep]";
		String msg = "Testing violating coexist rule without other conflict exception";
		assertEquals(exp,result,msg);
	}
	@Test
	void testIsValidMove4() throws JSONException {
		Puzzle p = new Puzzle("json/accept_ec.json");
		RuleSet ruleSet = new RuleSet(p);
		Response res = ruleSet.isValidMove(p.getInitialState(), new Move("farmer", "grass", 0,1));
		String result = res.toString();
		String exp = "Response [bol=true, str=]";
		String msg = "Testing violating coexist rule but with other conflict exception";
		assertEquals(exp,result,msg);
	}
	@Test
	void testIsValidMove5() throws JSONException {
		System.out.println("5");
		Puzzle p = new Puzzle("json/violate_ce.json");
		RuleSet ruleSet = new RuleSet(p);
		Response res = ruleSet.isValidMove(p.getInitialState(), new Move("tiger", "sheep", 0,1));
		String result = res.toString();
		String exp = "Response [bol=false, str=Conflict rule violated (tiger, sheep), Reason: Tiger ate sheep]";
		String msg = "Testing violating conflict rule without other coexist exception";
		assertEquals(exp,result,msg);
	}
	@Test
	void testIsValidMove6() throws JSONException {
		Puzzle p = new Puzzle("json/accept_ce.json");
		RuleSet ruleSet = new RuleSet(p);
		Response res = ruleSet.isValidMove(p.getInitialState(), new Move("tiger", "sheep", 0,1));
		String result = res.toString();
		String exp = "Response [bol=true, str=]";
		String msg = "Testing violating conflict rule but with other coexist exception";
		assertEquals(exp,result,msg);
	}
	@Test
	void testIsValidMove7() throws JSONException {
		Puzzle p = new Puzzle("json/violate_ee.json");
		RuleSet ruleSet = new RuleSet(p);
		Response res = ruleSet.isValidMove(p.getInitialState(), new Move("farmer", "grass", 0,1));
		String result = res.toString();
		String exp = "Response [bol=false, str=Coexist rule violated (farmer, sheep), Reason: farmer must with sheep]";
		String msg = "Testing violating coexist rule without other coexist exception";
		assertEquals(exp,result,msg);
	}
	@Test
	void testIsValidMove8() throws JSONException {
		Puzzle p = new Puzzle("json/accept_ee.json");
		RuleSet ruleSet = new RuleSet(p);
		Response res = ruleSet.isValidMove(p.getInitialState(), new Move("farmer", "grass", 0,1));
		String result = res.toString();
		String exp = "Response [bol=true, str=]";
		String msg = "Testing violating coexist rule but with other coexist exception";
		assertEquals(exp,result,msg);
	}
	@Test
	void testIsValidMove9() throws JSONException {
		Puzzle p = new Puzzle("json/no_traveler.json");
		RuleSet ruleSet = new RuleSet(p);
		Response res = ruleSet.isValidMove(p.getInitialState(), new Move("farmer", "sheep", 0,1));
		String result = res.toString();
		String exp = "Response [bol=false, str=No valid traveler]";
		String msg = "Testing no traveler case";
		assertEquals(exp,result,msg);
	}
	@Test
	void testIsValidMove10() throws JSONException {
		Puzzle p = new Puzzle("json/no_violation.json");
		RuleSet ruleSet = new RuleSet(p);
		Response res = ruleSet.isValidMove(p.getInitialState(), new Move("farmer", "sheep", 0,1));
		String result = res.toString();
		String exp = "Response [bol=true, str=]";
		String msg = "Testing no violation";
		assertEquals(exp,result,msg);
	}


}
