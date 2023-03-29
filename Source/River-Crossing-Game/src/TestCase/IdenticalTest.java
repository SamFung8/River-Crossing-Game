package TestCase;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Puzzle.PuzzleState;

class IdenticalTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testIsIdentical1() {
		//Initialization
		//target state
		ArrayList<String> TlandA = new ArrayList<String>(Arrays.asList("tiger", "grass"));
		ArrayList<String> TlandB = new ArrayList<String>(Arrays.asList("farmer", "sheep"));
		PuzzleState tps = new PuzzleState(TlandA,TlandB,1);
		//current state
		ArrayList<String> ClandA = new ArrayList<String>(Arrays.asList("tiger", "grass"));
		ArrayList<String> ClandB = new ArrayList<String>(Arrays.asList("farmer", "sheep"));
		PuzzleState cps = new PuzzleState(ClandA,ClandB,1);
		
		//Test begin
		boolean result = tps.isIdentical(cps);
		String msg = "Testing an identical puzzleState";
		assertEquals(true,result,msg);
	}
	
	@Test
	void testIsEmpty() {
		//Initialization
		//target state
		ArrayList<String> TlandA = new ArrayList<String>(Arrays.asList());
		ArrayList<String> TlandB = new ArrayList<String>(Arrays.asList());
		PuzzleState tps = new PuzzleState(TlandA,TlandB,1);
		//current state
		ArrayList<String> ClandA = new ArrayList<String>(Arrays.asList());
		ArrayList<String> ClandB = new ArrayList<String>(Arrays.asList());
		PuzzleState cps = new PuzzleState(ClandA,ClandB,1);
		
		//Test begin
		boolean result = tps.isIdentical(cps);
		String msg = "Testing an empty puzzleState";
		assertEquals(true,result,msg);
	}
	
	@Test
	void testNotIdenticalLengthB() {
		//Initialization
		//target state
		ArrayList<String> TlandA = new ArrayList<String>(Arrays.asList("tiger", "grass"));
		ArrayList<String> TlandB = new ArrayList<String>(Arrays.asList("farmer", "sheep"));
		PuzzleState tps = new PuzzleState(TlandA,TlandB,1);
		//current state
		ArrayList<String> ClandA = new ArrayList<String>(Arrays.asList("tiger", "grass"));
		ArrayList<String> ClandB = new ArrayList<String>(Arrays.asList("farmer", "sheep", " "));
		PuzzleState cps = new PuzzleState(ClandA,ClandB,1);
		
		//Test begin
		boolean result = tps.isIdentical(cps);
		String msg = "Testing a puzzleState with different length (Target landB != Current landB)";
		assertEquals(false,result,msg);
	}
	
	@Test
	void testNotIdenticalLengthA() {
		//Initialization
		//target state
		ArrayList<String> TlandA = new ArrayList<String>(Arrays.asList("tiger", "grass"));
		ArrayList<String> TlandB = new ArrayList<String>(Arrays.asList("farmer", "sheep"));
		PuzzleState tps = new PuzzleState(TlandA,TlandB,1);
		//current state
		ArrayList<String> ClandA = new ArrayList<String>(Arrays.asList("tiger", "grass","cow"));
		ArrayList<String> ClandB = new ArrayList<String>(Arrays.asList("farmer", "sheep"));
		PuzzleState cps = new PuzzleState(ClandA,ClandB,1);
		
		//Test begin
		boolean result = tps.isIdentical(cps);
		String msg = "Testing a puzzleState with different length (Target landA != Current landA)";
		assertEquals(false,result,msg);
	}
	
	@Test
	void testNotIdenticalAB() {
		//Initialization
		//target state
		ArrayList<String> TlandA = new ArrayList<String>(Arrays.asList("tiger", "grass"));
		ArrayList<String> TlandB = new ArrayList<String>(Arrays.asList("farmer", "sheep"));
		PuzzleState tps = new PuzzleState(TlandA,TlandB,1);
		//current state
		ArrayList<String> ClandA = new ArrayList<String>(Arrays.asList("farmer", "sheep"));
		ArrayList<String> ClandB = new ArrayList<String>(Arrays.asList("tiger", "grass"));
		PuzzleState cps = new PuzzleState(ClandA,ClandB,1);
		
		//Test begin
		boolean result = tps.isIdentical(cps);
		String msg = "Testing a different puzzleState where TlandA != ClandA and TlandB != ClandB";
		assertEquals(false,result,msg);
	}
	
	@Test
	void testNotIdenticalB() {
		//Initialization
		//target state
		ArrayList<String> TlandA = new ArrayList<String>(Arrays.asList("tiger", "grass"));
		ArrayList<String> TlandB = new ArrayList<String>(Arrays.asList("farmer", "sheep"));
		PuzzleState tps = new PuzzleState(TlandA,TlandB,1);
		//current state
		ArrayList<String> ClandA = new ArrayList<String>(Arrays.asList("grass", "tiger"));
		ArrayList<String> ClandB = new ArrayList<String>(Arrays.asList("sheep", "hunter"));
		PuzzleState cps = new PuzzleState(ClandA,ClandB,1);
		
		//Test begin
		boolean result = tps.isIdentical(cps);
		String msg = "Testing a different puzzleState where landB != ClandB";
		assertEquals(false,result,msg);
	}
	
	@Test
	void testNotIdenticalA() {
		//Initialization
		//target state
		ArrayList<String> TlandA = new ArrayList<String>(Arrays.asList("tiger", "lion"));
		ArrayList<String> TlandB = new ArrayList<String>(Arrays.asList("sheep", "hunter"));
		PuzzleState tps = new PuzzleState(TlandA,TlandB,1);
		//current state
		ArrayList<String> ClandA = new ArrayList<String>(Arrays.asList("grass", "tiger"));
		ArrayList<String> ClandB = new ArrayList<String>(Arrays.asList("sheep", "hunter"));
		PuzzleState cps = new PuzzleState(ClandA,ClandB,1);
		
		//Test begin
		boolean result = tps.isIdentical(cps);
		String msg = "Testing a different puzzleState where landA != ClandA";
		assertEquals(false,result,msg);
	}

}
