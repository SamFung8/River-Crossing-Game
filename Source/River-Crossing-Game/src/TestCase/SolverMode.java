package TestCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Puzzle.Solver.Solution;
import Puzzle.UI.SolverModeController;

class SolverMode {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testSolverMode1() throws Exception {
		String path = "json/example_puzzle.json";
		SolverModeController smc = new SolverModeController(path);
		smc.getSolve();
		String result = smc.getSol().toString();
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
		assertEquals(exp,result);		
}
}
