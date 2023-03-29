package Puzzle.Solver;

import java.util.*;

import org.json.JSONException;

import Puzzle.*;
import Puzzle.Logic.Response;
import Puzzle.Logic.RuleSet;

public class Solver {

	public static void main(String args[]) // static method
	{
		System.out.println((new Solution()).toString());
	}

	public Solution solve(Puzzle puzzle) throws JSONException {
		HashSet<Node> exploredState = new HashSet<>();
		Queue<Node> pendingState = new LinkedList<Node>();

		// list all legal moves
		// HashSet is designed to checking if certain item exists.

		pendingState.offer(new Node(puzzle.getInitialState()));
		
		while (pendingState.peek()!=null) {
			// dequene head
			Node currState = pendingState.poll();
			
			// add all non-duplicated legal states to pending
			ArrayList<Move> moves = getLegalMoves(puzzle, currState);
			
			for (Move move : moves) {
				Node nextState = new Node(currState.getPuzzleState().getNextState(move));
				nextState.setParent(currState);
				nextState.setPrevMove(move);
				if(isExplored(exploredState, currState) == false)
					pendingState.offer(nextState);
			}
			
			// add to explored states
			exploredState.add(currState);

			// back-tracking when the target state is reached.
			if (currState.getPuzzleState().isIdentical(puzzle.getTargetState())) {
				Solution sol = new Solution();
				sol.backtrackingSolution(currState);
				return sol;
			}
		}
		return new Solution();
	}
	
	
	public boolean isExplored(HashSet<Node> exploredState, Node state)
	{
		
		PuzzleState currState = state.getPuzzleState();
		for(Node node: exploredState)
			if(state.getPuzzleState().isIdentical(node.getPuzzleState()) && currState.getBoatPos() == node.getPuzzleState().getBoatPos())
				return true;
		return false;
	}
	
	public ArrayList<Move> getLegalMoves(Puzzle puzzle, Node currState) throws JSONException {
		ArrayList<Move> moves = new ArrayList<Move>();
		
		RuleSet ruleSet = new RuleSet(puzzle);
		HashSet<String> travelables = puzzle.getTravelables();
		
		PuzzleState puzzleState = currState.getPuzzleState();
		
		
		int origin = puzzleState.getBoatPos();
		int dest = (origin==0)?1:0;
		
		ArrayList<String> roles = puzzleState.getLandByID(origin);
		
		
		//one traveler 
		for(String travler : travelables)
		{
				Move move = new Move(travler,null, origin, dest);
				Response res = ruleSet.isValidMove(puzzleState, move);
				if (res.isValid())
					moves.add(move);
		}
		
		//two travelers
		for(String travler : travelables)
		{
			for(String role : roles)
			{
				if(travler.equals(role))
					continue;
				
				Move move = new Move(travler,role, origin, dest);
				Response res = ruleSet.isValidMove(puzzleState, move);
				if (res.isValid())
					moves.add(move);
			}
		}
		
		return moves;
	}

	public ArrayList<Move> getNextLegalStates(Puzzle puzzle, Node state) {
		ArrayList<Move> moves = new ArrayList<Move>();
		return moves;
	}

}
