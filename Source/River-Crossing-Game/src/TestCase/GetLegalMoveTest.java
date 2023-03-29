package TestCase;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Puzzle.Move;
import Puzzle.Puzzle;
import Puzzle.PuzzleState;
import Puzzle.Solver.Node;
import Puzzle.Solver.Solver;

class GetLegalMoveTest {
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void OneLegalMoveABTest() throws JSONException{
		String path = "json/example_puzzle.json";
		Puzzle p = new Puzzle(path);
		ArrayList<String> TlandA = new ArrayList<String>(Arrays.asList("tiger", "grass", "farmer", "sheep"));
		ArrayList<String> TlandB = new ArrayList<String>(Arrays.asList());
		PuzzleState tps = new PuzzleState(TlandA,TlandB,0);
		Node node = new Node(tps);
		Solver s = new Solver();
		ArrayList <Move> result_moves = s.getLegalMoves(p, node);
		Move moves = new Move("farmer", "sheep", 0, 1);
		ArrayList <Move> exp_moves = new ArrayList<Move>(Arrays.asList(moves));
		boolean result = true;
		boolean exp = true;
		for (Move move1 : exp_moves) {
			result = false;
			for(Move move2 : result_moves) {
				if(move1.isIdentical(move2)) {
					result = true;
				}
			}
		}
		String msg = "Test only one legal move from landA to landB";
		assertEquals(exp,result,msg);
		}
	@Test
	void OneLegalMoveBATest() throws JSONException{
		String path = "json/example_puzzle.json";
		Puzzle p = new Puzzle(path);
		ArrayList<String> TlandA = new ArrayList<String>(Arrays.asList());
		ArrayList<String> TlandB = new ArrayList<String>(Arrays.asList("tiger", "grass", "farmer", "sheep"));
		PuzzleState tps = new PuzzleState(TlandA,TlandB,1);
		Node node = new Node(tps);
		Solver s = new Solver();
		ArrayList <Move> result_moves = s.getLegalMoves(p, node);
		Move moves = new Move("farmer", "sheep", 1, 0);
		ArrayList <Move> exp_moves = new ArrayList<Move>(Arrays.asList(moves));
		boolean result = false;
		boolean exp = true;
		for (Move move1 : exp_moves) {
			result = false;
			for(Move move2 : result_moves) {
				if(move1.isIdentical(move2)) {
					result = true;
				}
			}
		}
		String msg = "Test only one legal move from landB to landA";
		assertEquals(exp,result,msg);
		}
	@Test
	void TwoLegalMoveABTest() throws JSONException{
		String path = "json/example_puzzle.json";
		Puzzle p = new Puzzle(path);
		ArrayList<String> TlandA = new ArrayList<String>(Arrays.asList("grass", "farmer", "sheep"));
		ArrayList<String> TlandB = new ArrayList<String>(Arrays.asList("tiger"));
		PuzzleState tps = new PuzzleState(TlandA,TlandB,0);
		Node node = new Node(tps);
		Solver s = new Solver();
		ArrayList <Move> result_moves = s.getLegalMoves(p, node);
		Move moves1 = new Move("farmer", "sheep", 0, 1);
		Move moves2 = new Move("farmer", "grass", 0, 1);
		ArrayList <Move> exp_moves = new ArrayList<Move>(Arrays.asList(moves1,moves2));
		boolean result = false;
		boolean exp = true;
		for (Move move1 : exp_moves) {
			result = false;
			for(Move move2 : result_moves) {
				if(move1.isIdentical(move2)) {
					result = true;
				}
			}
		}
		String msg = "Test two legal move from landA to landB";
		assertEquals(exp,result,msg);
		}
	@Test
	void TwoLegalMoveBATest() throws JSONException{
		String path = "json/example_puzzle.json";
		Puzzle p = new Puzzle(path);
		ArrayList<String> TlandA = new ArrayList<String>(Arrays.asList("tiger"));
		ArrayList<String> TlandB = new ArrayList<String>(Arrays.asList("grass", "farmer", "sheep"));
		PuzzleState tps = new PuzzleState(TlandA,TlandB,1);
		Node node = new Node(tps);
		Solver s = new Solver();
		ArrayList <Move> result_moves = s.getLegalMoves(p, node);
		Move moves1 = new Move("farmer", "sheep", 1, 0);
		Move moves2 = new Move("farmer", "grass", 1, 0);
		ArrayList <Move> exp_moves = new ArrayList<Move>(Arrays.asList(moves1,moves2));
		boolean result = false;
		boolean exp = true;
		for (Move move1 : exp_moves) {
			result = false;
			for(Move move2 : result_moves) {
				if(move1.isIdentical(move2)) {
					result = true;
				}
			}
		}
		String msg = "Test two legal move from landB to landA";
		assertEquals(exp,result,msg);
		}
	@Test
	void MoreLegalMoveABTest() throws JSONException{
		String path = "json/example_puzzle.json";
		Puzzle p = new Puzzle(path);
		ArrayList<String> TlandA = new ArrayList<String>(Arrays.asList("grass", "tiger","farmer"));
		ArrayList<String> TlandB = new ArrayList<String>(Arrays.asList("sheep"));
		PuzzleState tps = new PuzzleState(TlandA,TlandB,0);
		Node node = new Node(tps);
		Solver s = new Solver();
		ArrayList <Move> result_moves = s.getLegalMoves(p, node);
		Move moves1 = new Move("farmer", "tiger", 0, 1);
		Move moves2 = new Move("farmer", "grass", 0, 1);
		Move moves3 = new Move("farmer",null, 0, 1);
		ArrayList <Move> exp_moves = new ArrayList<Move>(Arrays.asList(moves1,moves2,moves3));
		boolean result = false;
		boolean exp = true;
		for (Move move1 : exp_moves) {
			result = false;
			for(Move move2 : result_moves) {
				if(move1.isIdentical(move2)) {
					result = true;
				}
			}
		}
		String msg = "Test >2 legal move from landA to landB";

		assertEquals(exp,result,msg);
		}
	@Test
	void MoreLegalMoveBATest() throws JSONException{
		String path = "json/example_puzzle.json";
		Puzzle p = new Puzzle(path);
		ArrayList<String> TlandA = new ArrayList<String>(Arrays.asList("sheep"));
		ArrayList<String> TlandB = new ArrayList<String>(Arrays.asList("grass", "tiger","farmer"));
		PuzzleState tps = new PuzzleState(TlandA,TlandB,1);
		Node node = new Node(tps);
		Solver s = new Solver();
		ArrayList <Move> result_moves = s.getLegalMoves(p, node);
		Move moves1 = new Move("farmer", "tiger", 1, 0);
		Move moves2 = new Move("farmer", "grass", 1, 0);
		Move moves3 = new Move("farmer",null, 1, 0);
		ArrayList <Move> exp_moves = new ArrayList<Move>(Arrays.asList(moves1,moves2,moves3));
		boolean result = false;
		boolean exp = true;
		for (Move move1 : exp_moves) {
			result = false;
			for(Move move2 : result_moves) {
				if(move1.isIdentical(move2)) {
					result = true;
				}
			}
		}
		String msg = "Test >2 legal move from landB to landA";
		assertEquals(exp,result,msg);
		}
	@Test
	void NoLegalMoveABTest() throws JSONException{
		String path = "json/no_traveler.json";
		Puzzle p = new Puzzle(path);
		ArrayList<String> TlandA = new ArrayList<String>(Arrays.asList("tiger"));
		ArrayList<String> TlandB = new ArrayList<String>(Arrays.asList("sheep"));
		PuzzleState tps = new PuzzleState(TlandA,TlandB,0);
		Node node = new Node(tps);
		Solver s = new Solver();
		ArrayList <Move> result_moves = s.getLegalMoves(p, node);
		ArrayList <Move> exp_moves = new ArrayList<Move>(Arrays.asList());
		boolean result = true;
		boolean exp = true;
		for (Move move1 : exp_moves) {
			result = false;
			for(Move move2 : result_moves) {
				if(move1.isIdentical(move2)) {
					result = true;
				}
			}
		}
		String msg = "Test no legal move from landA to landB";
		assertEquals(exp,result,msg);
		}
	@Test
	void NoLegalMoveBATest() throws JSONException{
		String path = "json/no_traveler.json";
		Puzzle p = new Puzzle(path);
		ArrayList<String> TlandA = new ArrayList<String>(Arrays.asList("tiger"));
		ArrayList<String> TlandB = new ArrayList<String>(Arrays.asList("sheep"));
		PuzzleState tps = new PuzzleState(TlandA,TlandB,1);
		Node node = new Node(tps);
		Solver s = new Solver();
		ArrayList <Move> result_moves = s.getLegalMoves(p, node);
		ArrayList <Move> exp_moves = new ArrayList<Move>(Arrays.asList());
		boolean result = true;
		boolean exp = true;
		for (Move move1 : exp_moves) {
			result = false;
			for(Move move2 : result_moves) {
				if(move1.isIdentical(move2)) {
					result = true;
				}
			}
		}
		String msg = "Test no legal move from landB to landA";
		assertEquals(exp,result,msg);
		}

}
