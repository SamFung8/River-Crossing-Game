package Puzzle.Logic;

import org.json.JSONException;

import Puzzle.Move;
import Puzzle.Puzzle;
import Puzzle.PuzzleState;

public class Main {
	
    public static void main(String[] args) throws JSONException {
		
    	
//    	//load json by args
//    	java puzzle -p /path/json  (player mode)
//    	java puzzle -s /path/json  (solver mode)
//    	
//    	
//    	//load json by user input in runtime
//    	java puzzle 
//    	
//    	enter your path to play the custom puzzle json: /path/json
//    	enter your path to solve the custom puzzle json: /path/json
//    	
//    	
//    	List of puzzle:
//    		
//    		example_puzzle
//    		easy
//    		normal
//    		hard 
//    		load your own json
//
//
//    	Puzzle information:
//    		
//    	name:
//    		
//    	description
//    	
//    	roles: 
//    	
//    	Press enter(any) to start
//    	Press esc to cancel
    	
    	
//    	try {
//			Rule rule = (Rule) Class.forName("Puzzle.Logic.CoexistRule").newInstance();
//		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
		Puzzle test = null;
		
		test = new Puzzle("json/example_puzzle.json");
		//test = new Puzzle("json/family.json");
		
		RuleSet ruleSet = new RuleSet(test);
		Response res = ruleSet.isValidMove(test.getInitialState(), new Move("farmer", "tiger", 0,1));
		System.out.println(res);
		
		res = ruleSet.isValidMove(test.getInitialState(), new Move("farmer", "sheep", 0,1));
		System.out.println(res);
		
		res = ruleSet.isValidMove(test.getInitialState(), new Move("farmer", "grass", 0,1));
		System.out.println(res);
		
		res = ruleSet.isValidMove(test.getInitialState(), new Move("tiger", "grass", 0,1));
		System.out.println(res);
		
    }
    
}