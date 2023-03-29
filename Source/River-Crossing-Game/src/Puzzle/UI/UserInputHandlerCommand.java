package Puzzle.UI;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInputHandlerCommand implements HandlerCommand{
	private GameState gameState;
	private String step;
		
	public UserInputHandlerCommand(GameState gameState) {
		this.gameState = gameState;
	}

	public boolean isBoatSitIsNotFull() {
		if (gameState.round.getTravelers().size()<2)
			return true;
		else
			return false;
	}
	
	public ArrayList<String> getCurrRoleList() {
	    if(gameState.currState.getBoatPos() == 0) {
	    	return new ArrayList <String>(gameState.currState.getLandByID(0));
	    }else {
	    	return new ArrayList <String>(gameState.currState.getLandByID(1));
	    }
	}
	
	public void getInputCommand() {
		ArrayList<String> commandList = new ArrayList<String>();
		Scanner s = new Scanner(System.in);
		
		if(isBoatSitIsNotFull()) {
			commandList.clear();
			commandList = getCurrRoleList();
			commandList.add("s");
			commandList.add("e");
			commandList.add("u");
			commandList.add("r");
			do {
			    System.out.println("Please use the following command to take action: ");
			    System.out.println("FULL NAME \t\t\t Choose a role on the boat side and Enter the full role name put the role to the boat");
			    System.out.println("'s' \t\t\t\t To start the boat");
			    System.out.println("'e' \t\t\t\t To exit the program");
			    System.out.println("'u' \t\t\t\t To undo the action if exist");
			    System.out.println("'r' \t\t\t\t To redo the action if exist");
			    System.out.print("You command: ");
			    step = s.next();
			    if(!commandList.contains(step)) 
			    	System.out.println("Sorry, it is invalid command! Please try again!\n");
			    
			    else
			    	break;
			}while(true);
		}else {
			commandList.clear();
			commandList.add("s");
			commandList.add("e");
			commandList.add("u");
			commandList.add("r");
			do {
				System.out.println("Please use the following command to take action: ");
			    System.out.println("'s' \t To start the boat");
			    System.out.println("'e' \t To exit the program");
			    System.out.println("'u' \t To undo the action if exist");
			    System.out.println("'r' \t To redo the action if exist");
			    System.out.print("You command: ");
			    step = s.next();
			    if(!commandList.contains(step)) {
			    	if(getCurrRoleList().contains(step))
			    		System.out.println("Sorry, it is invalid command! The boat sit is full! Please try again!\n");
			    	else
			    		System.out.println("Sorry, it is invalid command! Please try again!\n");
			    }
			    else
			    	break;
			}while(true);
		}
	}

	@Override
	public void execute() {
		getInputCommand();		
	}

	public String getStep() {
		return step;
	}

}
