package Puzzle.UI;

import Puzzle.*;

public class PlayerModeController{	
	Puzzle puzzle;
	
	GameState gameState;
	
	ExitHandlerCommand exitHandler;
	DrawHandlerCommand drawHandler;
	CheckHandlerCommand checkHandler;
	RedoHandlerCommand redoHandler;
	UndoHandlerCommand undoHandler;
	UserInputHandlerCommand inputHandler;
	
	Invoker invoker;
	
	public PlayerModeController(String path) throws Exception {
		//load json
		puzzle = new Puzzle(path);
		
		gameState = GameState.getInstance(puzzle);
		
		//initialize each command handler
		exitHandler = new ExitHandlerCommand();
		drawHandler = new DrawHandlerCommand(gameState);
		checkHandler = new CheckHandlerCommand(puzzle, gameState);
		redoHandler = new RedoHandlerCommand(gameState);
		undoHandler = new UndoHandlerCommand(gameState);
		inputHandler = new UserInputHandlerCommand(gameState);
		
		invoker = new Invoker();
	}
		
	public void checkAnswer() {
		invoker.execute(checkHandler);
	}
	
	public void drawGame() {
		invoker.execute(drawHandler);
	}

	public void updateCurrentState(String step) {
		gameState.updateAfterAddRoleToBoat(step);
	}

	public void saveCurrentRound() {
		gameState.saveCurrentHistory();;
	}

	public void undo() {
		invoker.execute(undoHandler);
	}

	public void redo() {
		invoker.execute(redoHandler);
	}

	public String printGameInfo() {
		return "The puzzle name: \t" + puzzle.getName() 
				+ "\nThe game description: \t\t" + puzzle.getDescription()
				+ "\nThe game roles: \t\t" + puzzle.getRoleList();
	}

	public String getUserCommand() {
		invoker.execute(inputHandler);
		return inputHandler.getStep();
	}

	public void exitGame() {
		invoker.execute(exitHandler);
	}
}
