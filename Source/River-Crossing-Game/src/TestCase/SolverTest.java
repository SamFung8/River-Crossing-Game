package TestCase;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Puzzle.Move;
import Puzzle.Puzzle;
import Puzzle.PuzzleState;
import Puzzle.Solver.Node;
import Puzzle.Solver.Solution;
import Puzzle.Solver.Solver;

class SolverTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testEasyVersion() throws IOException, JSONException {
	String path = "json/example_puzzle.json";
	Puzzle p = new Puzzle(path);
	Solver s = new Solver();
	Solution sol = s.solve(p);
			String exp ="\nInitial State:\n"
					+ "Land A: [farmer, tiger, sheep, grass](boat)\n"
					+ "Land B: []\n"
					+ "\n"
					+ "Step 1\n"
					+ "Move [farmer, sheep] from LandA to LandB\n"
					+ "Land A: [tiger, grass]\n"
					+ "Land B: [farmer, sheep](boat)\n"
					+ "\n"
					+ "Step 2\n"
					+ "Move [farmer] from LandB to LandA\n"
					+ "Land A: [tiger, grass, farmer](boat)\n"
					+ "Land B: [sheep]\n"
					+ "\n"
					+ "Step 3\n"
					+ "Move [farmer, tiger] from LandA to LandB\n"
					+ "Land A: [grass]\n"
					+ "Land B: [sheep, farmer, tiger](boat)\n"
					+ "\n"
					+ "Step 4\n"
					+ "Move [farmer, sheep] from LandB to LandA\n"
					+ "Land A: [grass, farmer, sheep](boat)\n"
					+ "Land B: [tiger]\n"
					+ "\n"
					+ "Step 5\n"
					+ "Move [farmer, grass] from LandA to LandB\n"
					+ "Land A: [sheep]\n"
					+ "Land B: [tiger, farmer, grass](boat)\n"
					+ "\n"
					+ "Step 6\n"
					+ "Move [farmer] from LandB to LandA\n"
					+ "Land A: [sheep, farmer](boat)\n"
					+ "Land B: [tiger, grass]\n"
					+ "\n"
					+ "Step 7\n"
					+ "Move [farmer, sheep] from LandA to LandB\n"
					+ "Land A: []\n"
					+ "Land B: [tiger, grass, farmer, sheep](boat)\n";
	String result = sol.toString();
	String msg = "Testing a easy successful case";
	assertEquals(exp,result,msg);
	}
	
	@Test
	void testNormalVersion() throws IOException, JSONException {
	String path = "json/family.json";
	Puzzle p = new Puzzle(path);
	Solver s = new Solver();
	Solution sol = s.solve(p);
			String exp ="\n"
					+ "Initial State:\n"
					+ "Land A: [father, daughter, mother, son, police, criminal](boat)\n"
					+ "Land B: []\n"
					+ "\n"
					+ "Step 1\n"
					+ "Move [mother, daughter] from LandA to LandB\n"
					+ "Land A: [father, son, police, criminal]\n"
					+ "Land B: [mother, daughter](boat)\n"
					+ "\n"
					+ "Step 2\n"
					+ "Move [mother] from LandB to LandA\n"
					+ "Land A: [father, son, police, criminal, mother](boat)\n"
					+ "Land B: [daughter]\n"
					+ "\n"
					+ "Step 3\n"
					+ "Move [mother, father] from LandA to LandB\n"
					+ "Land A: [son, police, criminal]\n"
					+ "Land B: [daughter, mother, father](boat)\n"
					+ "\n"
					+ "Step 4\n"
					+ "Move [father] from LandB to LandA\n"
					+ "Land A: [son, police, criminal, father](boat)\n"
					+ "Land B: [daughter, mother]\n"
					+ "\n"
					+ "Step 5\n"
					+ "Move [police, criminal] from LandA to LandB\n"
					+ "Land A: [son, father]\n"
					+ "Land B: [daughter, mother, police, criminal](boat)\n"
					+ "\n"
					+ "Step 6\n"
					+ "Move [mother] from LandB to LandA\n"
					+ "Land A: [son, father, mother](boat)\n"
					+ "Land B: [daughter, police, criminal]\n"
					+ "\n"
					+ "Step 7\n"
					+ "Move [mother, father] from LandA to LandB\n"
					+ "Land A: [son]\n"
					+ "Land B: [daughter, police, criminal, mother, father](boat)\n"
					+ "\n"
					+ "Step 8\n"
					+ "Move [father] from LandB to LandA\n"
					+ "Land A: [son, father](boat)\n"
					+ "Land B: [daughter, police, criminal, mother]\n"
					+ "\n"
					+ "Step 9\n"
					+ "Move [father, son] from LandA to LandB\n"
					+ "Land A: []\n"
					+ "Land B: [daughter, police, criminal, mother, father, son](boat)\n";
	String result = sol.toString();
	String msg = "Testing a normal successful case";
	assertEquals(exp,result,msg);
	}
	
	@Test
	void testHardVersion() throws IOException, JSONException {
	String path = "json/hard.json";
	Puzzle p = new Puzzle(path);
	Solver s = new Solver();
	Solution sol = s.solve(p);
			String exp ="\n"
					+ "Initial State:\n"
					+ "Land A: [farmer, tiger, sheep, grass, cow, shepherd, hunter](boat)\n"
					+ "Land B: []\n"
					+ "\n"
					+ "Step 1\n"
					+ "Move [hunter, sheep] from LandA to LandB\n"
					+ "Land A: [farmer, tiger, grass, cow, shepherd]\n"
					+ "Land B: [hunter, sheep](boat)\n"
					+ "\n"
					+ "Step 2\n"
					+ "Move [hunter] from LandB to LandA\n"
					+ "Land A: [farmer, tiger, grass, cow, shepherd, hunter](boat)\n"
					+ "Land B: [sheep]\n"
					+ "\n"
					+ "Step 3\n"
					+ "Move [hunter, cow] from LandA to LandB\n"
					+ "Land A: [farmer, tiger, grass, shepherd]\n"
					+ "Land B: [sheep, hunter, cow](boat)\n"
					+ "\n"
					+ "Step 4\n"
					+ "Move [hunter] from LandB to LandA\n"
					+ "Land A: [farmer, tiger, grass, shepherd, hunter](boat)\n"
					+ "Land B: [sheep, cow]\n"
					+ "\n"
					+ "Step 5\n"
					+ "Move [farmer, hunter] from LandA to LandB\n"
					+ "Land A: [tiger, grass, shepherd]\n"
					+ "Land B: [sheep, cow, farmer, hunter](boat)\n"
					+ "\n"
					+ "Step 6\n"
					+ "Move [farmer] from LandB to LandA\n"
					+ "Land A: [tiger, grass, shepherd, farmer](boat)\n"
					+ "Land B: [sheep, cow, hunter]\n"
					+ "\n"
					+ "Step 7\n"
					+ "Move [farmer, shepherd] from LandA to LandB\n"
					+ "Land A: [tiger, grass]\n"
					+ "Land B: [sheep, cow, hunter, farmer, shepherd](boat)\n"
					+ "\n"
					+ "Step 8\n"
					+ "Move [farmer] from LandB to LandA\n"
					+ "Land A: [tiger, grass, farmer](boat)\n"
					+ "Land B: [sheep, cow, hunter, shepherd]\n"
					+ "\n"
					+ "Step 9\n"
					+ "Move [farmer, tiger] from LandA to LandB\n"
					+ "Land A: [grass]\n"
					+ "Land B: [sheep, cow, hunter, shepherd, farmer, tiger](boat)\n"
					+ "\n"
					+ "Step 10\n"
					+ "Move [hunter] from LandB to LandA\n"
					+ "Land A: [grass, hunter](boat)\n"
					+ "Land B: [sheep, cow, shepherd, farmer, tiger]\n"
					+ "\n"
					+ "Step 11\n"
					+ "Move [hunter, grass] from LandA to LandB\n"
					+ "Land A: []\n"
					+ "Land B: [sheep, cow, shepherd, farmer, tiger, hunter, grass](boat)\n";
	String result = sol.toString();
	String msg = "Testing a hard successful case";
	assertEquals(exp,result,msg);
	}
	
	@Test
	void testNoSolution() throws IOException, JSONException {
	String path = "json/no_sol.json";
	Puzzle p = new Puzzle(path);
	Solver s = new Solver();
	Solution sol = s.solve(p);
	String exp ="No solution";
	String result = sol.toString();
	String msg = "Testing a case without solution";
	assertEquals(exp,result,msg);
	}
}
