package Puzzle.UI;

public class ExitHandlerCommand implements HandlerCommand{
	
	public void exit() {
		//System.out.println("Thanks for playing!");
		System.out.println("Exiting program...");
		System.exit(0);
	}

	@Override
	public void execute() {
		exit();	
	}

}
