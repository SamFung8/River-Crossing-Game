package Puzzle.UI;

import org.json.JSONException;

import Puzzle.Puzzle;
import Puzzle.Solver.Solution;
import Puzzle.Solver.Solver;

public class SolverModeController{
	Puzzle puzzle;
	Solver solver;
	Solution sol;
	
	public SolverModeController(String path) throws Exception {
		//load json
		puzzle = new Puzzle(path);
		solver = new Solver();
	}
	
	public void getSolve() throws JSONException {
		sol = solver.solve(puzzle);
	}
	
	public void getResult() {
		System.out.println(sol);
	}
	
	public Solution getSol() {
		return sol;
	}
}
