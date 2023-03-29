package Puzzle.UI;
import java.util.*;
import org.fusesource.jansi.AnsiConsole;
import org.json.JSONException;

public class Main{
 
    public static void main(String[] args) throws JSONException {
    	AnsiConsole.systemInstall();
    	GameFlow m;
    	GameFlowFactory f = new GameFlowFactory();
    	Scanner s = new Scanner(System.in);
    	
    	if(args.length > 0) {
	    	if(args[0].equals("-s")) {
	    		String jsonPath = args[1];
	    		m = f.getGameFlow("1", jsonPath);
		        m.run();
	    	}else if(args[0].equals("-p")) {
	    		String jsonPath = args[1];
	    		m = f.getGameFlow("2", jsonPath);
		        m.run();
	    	}
    	}else {
	    	ArrayList<String> commandList = new ArrayList<String>();
	    	commandList.add("1");
	    	commandList.add("2");
	    	    	
	    	String mode;
	    	do{
		        System.out.println("Please enter the number to select the mode:  1-Solver  2-Player");
		        mode = s.next();
	    	}while(!commandList.contains(mode));
	    	
	        m = f.getGameFlow(mode);
	        m.run();
    	}	
    	
        s.close();
    }
}
