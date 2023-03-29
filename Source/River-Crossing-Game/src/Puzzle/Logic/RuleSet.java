package Puzzle.Logic;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Puzzle.*;

public class RuleSet {
	
	private Puzzle puzzle;
	private ArrayList<Rule> rules;
	
	
	public RuleSet(Puzzle puzzle) throws JSONException
	{
		this.puzzle = puzzle;
		rules = new ArrayList<Rule>();
		JSONObject puzzleJSON = puzzle.getPuzzleJSON();
		
		//parse the JSON into rules here
		JSONArray ruleArray = (JSONArray) puzzle.getPuzzleJSON().get("Rules");
		
		RuleFactory ruleFactory = new RuleFactory();
		
		for(int i=0;i<ruleArray.length();i++)
			try {
				rules.add(ruleFactory.createRule(ruleArray.getJSONObject(i)));
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | JSONException e) {
				e.printStackTrace();
		}
	}
	
	public Response isValidMove(PuzzleState state, Move move)
	{
		//check if at least one role can travel
		if(isTravelable(move)==false)
			return new Response(false, "No valid traveler");
		
		PuzzleState nextState = state.getNextState(move);
		
		//loop through all the rules here
		for(Rule r : rules)
		{
			Response res = r.isValid(nextState);
			if(res.isValid() == false)
				return res;
		}
		
		return new Response(true, "");
	}
	
	//check if at least one travler is travelable
	public boolean isTravelable(Move move)
	{
		ArrayList<String> travelers = move.getTravelers();
		
		boolean travelFlag = false;
		for (String role: travelers)
			if(puzzle.getTravelables().contains(role) == true)
				travelFlag = true;
		
		return travelFlag;
	}
	
	public boolean isWin(PuzzleState state)
	{
		return puzzle.getTargetState().isIdentical(state);
	}
}
