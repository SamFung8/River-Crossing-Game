package Puzzle.UI;

import java.util.ArrayList;
import Puzzle.PuzzleState;

public class RedoHandlerCommand implements HandlerCommand{
	GameState gameState;
		
	public RedoHandlerCommand(GameState gameState) {
		super();
		this.gameState = gameState;
	}

	public void redo() {
		gameState.currState = new PuzzleState(new ArrayList <String> (gameState.history.get(gameState.undoRedoPointer).getLandByID(0)), new ArrayList <String> (gameState.history.get(gameState.undoRedoPointer).getLandByID(1)), gameState.history.get(gameState.undoRedoPointer).getBoatPos());		
		gameState.undoRedoPointer++;
		gameState.round.setOrigin(gameState.currState.getBoatPos());
		gameState.round.setDestination((gameState.currState.getBoatPos()+1)%2);
		
	}

	public boolean canRedo() {
		if(gameState.undoRedoPointer < gameState.history.size() && gameState.round.getTravelers().size() == 0 && gameState.history.size() > 1)
			return true;
		else
			return false;
		
	}

	@Override
	public void execute() {
    	if(canRedo())
    		redo();
    	else {
    		System.out.println("Sorry nothing can be redo!\n");
    		//continue;
    	}
	}

}
