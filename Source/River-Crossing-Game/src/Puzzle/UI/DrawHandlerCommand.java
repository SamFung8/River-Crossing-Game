package Puzzle.UI;

public class DrawHandlerCommand implements HandlerCommand{
	GameState gameState;
	
	DrawGraphic drawer;
		
	public DrawHandlerCommand(GameState gameState) {
		this.gameState = gameState;
		this.drawer = new DrawGraphic();
	}

	public void draw() {
		drawer.draw(gameState.currState.getLandByID(1), gameState.currState.getLandByID(0), gameState.currState.getBoatPos(), gameState.round.getTravelers());
	}

	@Override
	public void execute() {
		draw();		
	}
}
