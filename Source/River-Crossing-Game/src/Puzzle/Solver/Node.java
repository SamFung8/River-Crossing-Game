package Puzzle.Solver;

import java.util.ArrayList;

import Puzzle.Move;
import Puzzle.PuzzleState;


public class Node {
	
	PuzzleState puzzleState;
	Node parent;
	Move prevMove;
	
	public Node(PuzzleState state)
	{
		this.puzzleState = state;
	}
	
	public PuzzleState getPuzzleState()
	{
		return puzzleState;
	}
	
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public void setPrevMove(Move prevMove) {
		this.prevMove = prevMove;
	}
	public Move getPrevMove() {
		return prevMove;
	}
	
	@Override
	public String toString() {
		String msg ="";
		
		if(this.prevMove!=null)
			msg += prevMove.toString();
		
		msg += puzzleState.toString();
		return msg;
	}
}
