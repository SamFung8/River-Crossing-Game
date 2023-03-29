package Puzzle.Solver;

import java.util.HashSet;

import Puzzle.Puzzle;

public class Main
{
    public static void main(String[] args) {
    	
    	try {
	    	Puzzle puzzle = new Puzzle("json/example_puzzle.json");
	    	Solver solver = new Solver();
	    	Solution sol = solver.solve(puzzle);
	    	
	    	System.out.println(sol.toMoves());
    	}catch(Exception e) {
    		
    	}
    }
}