package TestCase;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Puzzle.Move;
import Puzzle.PuzzleState;
import Puzzle.Solver.Node;

class NodeTest {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testPrevMoveBA() {
		ArrayList<String> TlandA = new ArrayList<String>(Arrays.asList("tiger", "grass"));
		ArrayList<String> TlandB = new ArrayList<String>(Arrays.asList("farmer", "sheep"));
		PuzzleState tps = new PuzzleState(TlandA,TlandB,0);
		Node node = new Node(tps);
		Move m = new Move("tiger", "grass", 1,0);
		node.setPrevMove(m);
		String exp = "Move [tiger, grass] from LandB to LandA\n"
				+ "Land A: [tiger, grass](boat)\n"
				+ "Land B: [farmer, sheep]";
		String result = node.toString();
		String msg = "Testing case with previous move from landB to landA";
		assertEquals(exp,result,msg);
	}

	@Test
	void testNoPrevMove() {
		ArrayList<String> TlandA = new ArrayList<String>(Arrays.asList("tiger", "grass"));
		ArrayList<String> TlandB = new ArrayList<String>(Arrays.asList("farmer", "sheep"));
		PuzzleState tps = new PuzzleState(TlandA,TlandB,1);
		Node node = new Node(tps);
		String exp = "\nLand A: [tiger, grass]\n"
				+ "Land B: [farmer, sheep](boat)";
		String result = node.toString();
		String msg = "Testing case with no previous move";
		assertEquals(exp,result,msg);
	}
	@Test
	void testPrevMoveAB() {
		ArrayList<String> TlandA = new ArrayList<String>(Arrays.asList("tiger", "grass"));
		ArrayList<String> TlandB = new ArrayList<String>(Arrays.asList("farmer", "sheep"));
		PuzzleState tps = new PuzzleState(TlandA,TlandB,1);
		Node node = new Node(tps);
		Move m = new Move("farmer", "sheep", 0,1);
		node.setPrevMove(m);
		String exp = "Move [farmer, sheep] from LandA to LandB\n"
				+ "Land A: [tiger, grass]\n"
				+ "Land B: [farmer, sheep](boat)";
		String result = node.toString();
		String msg = "Testing case with previous move from landA to landB";
		assertEquals(exp,result,msg);
	}
}

