package Puzzle.UI;

public class GameFlowFactory {
	public GameFlow getGameFlow(String m) {
		if(m.equals("1")) {
			return new SolverMode();
		}
		
		if(m.equals("2")) {
			return new PlayerMode();
		}		
		
		return null;	
	}
	
	public GameFlow getGameFlow(String m, String jsonPath) {
		if(m.equals("1")) {
			return new SolverMode(jsonPath);
		}
		
		if(m.equals("2")) {
			return new PlayerMode(jsonPath);
		}		
		
		return null;	
	}
}
