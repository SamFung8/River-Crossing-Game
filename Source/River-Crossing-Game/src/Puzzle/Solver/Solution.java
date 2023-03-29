package Puzzle.Solver;

import java.util.ArrayList;

import Puzzle.Move;

public class Solution {
	
	private ArrayList<Node> steps = new ArrayList<Node>();
	
	public void backtrackingSolution(Node finalState)
	{
		Node currState = finalState;
		while(currState.parent!=null)
		{	
			this.steps.add(0,currState);
			currState = currState.getParent();
		}
		this.steps.add(0,currState);
	}
	
	
	//use this to test if the solution correct 
	public ArrayList<Move> toMoves()
	{
		ArrayList<Move> moves = new ArrayList<Move>();
		
		for(Node s : steps)
			if(s.getPrevMove()!=null)
				moves.add(s.getPrevMove());
		return moves;
	}
	
	public String toString()
	{
		if(steps.size()==0)
			return "No solution";
		
		String msg=""; 
		
		msg += "\nInitial State:";
		msg += steps.get(0).toString() +"\n";
		
		for(int i=1;i<steps.size();i++)
		{
			msg += "\nStep " + i;
			msg += "\n"+steps.get(i).toString();
			msg += "\n";
		}
		
		return msg;
	}

}
