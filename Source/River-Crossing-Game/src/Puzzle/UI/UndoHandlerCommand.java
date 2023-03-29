package Puzzle.UI;

import java.util.ArrayList;
import Puzzle.PuzzleState;

public class UndoHandlerCommand implements HandlerCommand{
	GameState gameState;	
	
	public UndoHandlerCommand(GameState gameState) {
		super();
		this.gameState = gameState;
	}

	public void undo() {
		if(gameState.round.getTravelers().size()>0) {
			gameState.round.getTravelers().clear();
			gameState.currState = new PuzzleState(new ArrayList <String> (gameState.history.get(gameState.history.size()-1).getLandByID(0)), new ArrayList <String> (gameState.history.get(gameState.history.size()-1).getLandByID(1)), gameState.history.get(gameState.history.size()-1).getBoatPos());
		}else {
			gameState.currState = new PuzzleState(new ArrayList <String> (gameState.history.get(gameState.undoRedoPointer-2).getLandByID(0)), new ArrayList <String> (gameState.history.get(gameState.undoRedoPointer-2).getLandByID(1)), gameState.history.get(gameState.undoRedoPointer-2).getBoatPos());
			gameState.undoRedoPointer--;
			gameState.round.setOrigin(gameState.currState.getBoatPos());
			gameState.round.setDestination((gameState.currState.getBoatPos()+1)%2);
		}		
	}

	public boolean canUndo() {
		if(gameState.undoRedoPointer > 1 || gameState.round.getTravelers().size()>0)
			return true;
		else
			return false;
	}

	@Override
	public void execute() {
    	if(canUndo())
    		undo();
    	else {
    		System.out.println("Sorry nothing can be undo!\n");
    		//continue;
    	}		
	}

}
