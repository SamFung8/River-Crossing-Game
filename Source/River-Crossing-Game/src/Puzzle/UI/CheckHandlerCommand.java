package Puzzle.UI;

import java.util.Scanner;

import org.json.JSONException;

import Puzzle.Puzzle;
import Puzzle.Logic.Response;
import Puzzle.Logic.RuleSet;

public class CheckHandlerCommand implements HandlerCommand{
	GameState gameState;
	
	Response res;
	RuleSet ruleSet ;
	
	Puzzle puzzle;
	
	public CheckHandlerCommand(Puzzle puzzle, GameState gameState) throws JSONException {
		this.gameState = gameState;
		res = new Response();
		ruleSet = new RuleSet(puzzle);
		this.puzzle = puzzle;
	}
	
	public void clearBoatData() {
		gameState.round.getTravelers().clear();	
	}
	
	public void updateAfterCheck() {
		gameState.currState = gameState.currState.getNextState(gameState.round);
		gameState.round.setOrigin((gameState.round.getOrigin()+1)%2);
		gameState.round.setDestination((gameState.round.getDestination()+1)%2);
	}
	
	public boolean isValid() {
		res = ruleSet.isValidMove(gameState.currState, gameState.round);
		return res.isValid();
	}
	
	public boolean isWin() {
		return gameState.currState.isIdentical(puzzle.getTargetState());
	}
	
	public boolean checkAnswer() {
		boolean temp = isValid();
		if(temp) {
			updateAfterCheck();
		}
		return temp;
	}

	@Override
	public void execute() {
		DrawHandlerCommand d = new DrawHandlerCommand(gameState);
		UndoHandlerCommand u = new UndoHandlerCommand(gameState);
		ExitHandlerCommand e = new ExitHandlerCommand();
				
    	if(checkAnswer()) {
    		gameState.saveCurrentHistory();
    		if(isWin()) {
    			clearBoatData();
    			d.draw();
    			System.out.println("You Win!\nThanks for playing!");
    			e.exit();
    		}
    	}else {
    		String step;
    		Scanner s = new Scanner(System.in);
    		
    		if(u.canUndo()) {
	    		do{
				    System.out.print("Sorry this move is invalid, becuase "+ res.getMsg() +"\nyou can choose to undo. Please enter 'y' or 'n': ");
				    step = s.next();
	    		}while(!step.equals("y") && !step.equals("n"));
    		}else
    			step = "n";
    		
    		if(step.equals("n")) {
	    		System.out.println("Game Over!\nThanks for playing!");
	    		e.exit();
    		}else 
    			u.undo();
    	}
    	clearBoatData();		
	}
}
