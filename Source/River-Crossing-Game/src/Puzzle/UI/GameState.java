package Puzzle.UI;

import java.util.ArrayList;

import Puzzle.Move;
import Puzzle.Puzzle;
import Puzzle.PuzzleState;

public class GameState {
	protected PuzzleState currState;
	protected Move round;
	protected ArrayList<PuzzleState> history;
	protected int undoRedoPointer;
	
	private static GameState gameSate = null;
	
	private static GameState setup(Puzzle puzzle) {
		GameState temp = new GameState();
		
		temp.history = new ArrayList<PuzzleState>();
		temp.undoRedoPointer = 0;
		temp.round = new Move(0,1);
		temp.currState = new PuzzleState(puzzle.getInitialState().getLandByID(0), puzzle.getInitialState().getLandByID(1), 0);
		
		return temp;
	}
	
    public static GameState getInstance(Puzzle puzzle)
    {
    	gameSate = setup(puzzle);
    	return gameSate;
    }

	public void updateAfterAddRoleToBoat(String step) {
	    if(currState.getBoatPos() == 0) {
	    	if(currState.getLandByID(0).remove(step)) 
	    		round.getTravelers().add(step);
	    }else {
	    	if(currState.getLandByID(1).remove(step)) 
	    		round.getTravelers().add(step);
	    }
		if (undoRedoPointer != history.size()) {
			int removeSize = history.size();
			for(int i=removeSize-1;i>=undoRedoPointer;i--) {
				history.remove(i);
			}
		}
	}
	
	public void saveCurrentHistory() {
		if (undoRedoPointer != history.size()) {
			int removeSize = history.size();
			for(int i=removeSize-1;i>=undoRedoPointer;i--) {
				history.remove(i);
			}
		}				
		history.add(new PuzzleState(new ArrayList <String>(currState.getLandByID(0)),new ArrayList <String>(currState.getLandByID(1)), currState.getBoatPos()));
		undoRedoPointer ++;
	}
}
