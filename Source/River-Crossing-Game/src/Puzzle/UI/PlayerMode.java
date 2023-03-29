package Puzzle.UI;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerMode implements GameFlow{
	Scanner s = new Scanner(System.in);
	PlayerModeController controller ;
	ArrayList<String> commandList = new ArrayList<String>();
	
	public PlayerMode(){
		commandList.clear();
		commandList.add("1");
		commandList.add("2");
		commandList.add("3");
		
		String level;
		do {
			System.out.println("Please enter the number to select the game level: 1-easy  2-hard  3-import custom rule json file path.");
			level = s.next();
		}while(!commandList.contains(level));
		
		while(true) {
			try {
				if(level.equals("1")) {
					//load easy mode json
					controller = new PlayerModeController("json/example_puzzle.json");
					break;
				}else if(level.equals("2")) {
					//load hard mode json
					controller = new PlayerModeController("json/hard.json");
					break;
				}else if(level.equals("3")) {
					String path;
					System.out.println("Please import the custom rule json file path.");
					path = s.next();
					controller = new PlayerModeController(path);
					break;
				}
			}catch(java.nio.file.NoSuchFileException e) {
				System.out.println("\nSorry the json file path invalid!");
				continue;
			}catch(org.json.JSONException e) {
				System.out.println("\nSorry the json file format invalid!");
				continue;
			}catch(RuntimeException e) {
				System.out.println("\n" + e);
				continue;
			}catch(Exception e) {
				continue;
			}
		}
	}	
	
	public PlayerMode(String jsonPath) {
		try {
			controller = new PlayerModeController(jsonPath);
		}catch(java.nio.file.NoSuchFileException e) {
			System.out.println("\nSorry the json file path invalid!");
			errorMessage();
		}catch(org.json.JSONException e) {
			System.out.println("\nSorry the json file format invalid!");
			errorMessage();
		}catch(RuntimeException e) {
			System.out.println(e);
			errorMessage();
		}catch(Exception e) {
			System.out.println("\nSorry, it is invalid json file!");
			errorMessage();
		}
	}
	
	public void errorMessage() {
		System.out.println("\nTo start the program please use the following command: ");
		System.out.println("Quick start to run custom json file and run with 1-player mode: \t java -p 'Your json path'");
		System.out.println("Quick start to run custom json file and run with solver mode: \t\t java -s 'Your json path'");
		System.exit(0);
	}
	

	@Override
	public void run() {
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(controller.printGameInfo());
		controller.drawGame();
	    System.out.println();
	    controller.saveCurrentRound();
		
		while (true){			
			String step = controller.getUserCommand();
		
		    if(step.equals("s")) {	    	
		    	controller.checkAnswer();
		    }else if(step.equals("e")) {
		    	controller.exitGame();
		    }else if(step.equals("u")) {
		    	controller.undo();
		    }else if(step.equals("r")) {
		    	controller.redo();
		    }else {
		    	controller.updateCurrentState(step);
		    }

		    controller.drawGame();
		    
		}
	}
}



