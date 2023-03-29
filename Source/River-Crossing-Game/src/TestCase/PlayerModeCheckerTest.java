package TestCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Puzzle.Puzzle;
import Puzzle.UI.GameState;
import Puzzle.UI.PlayerMode;
import Puzzle.UI.PlayerModeController;
import Puzzle.UI.RedoHandlerCommand;
import Puzzle.UI.UndoHandlerCommand;

class PlayerModeCheckerTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testCanUndoAfterMove() throws Exception {
		String path = "json/example_puzzle.json";
		Puzzle p = new Puzzle(path);
		GameState g = GameState.getInstance(p);
		boolean exp = true;
		g.saveCurrentHistory();
		g.saveCurrentHistory();
		UndoHandlerCommand uhc = new UndoHandlerCommand(g);
		boolean result = uhc.canUndo();
		String msg = "Testing a allowed Undo command followed by a move";
		System.out.println(result);
		assertEquals(exp,result,msg);
	}
	@Test
	void testCanUndoAfterRedo() throws Exception {
		String path = "json/example_puzzle.json";
		Puzzle p = new Puzzle(path);
		GameState g = GameState.getInstance(p);
		boolean exp = true;
		g.saveCurrentHistory();
		g.saveCurrentHistory();
		UndoHandlerCommand uhc = new UndoHandlerCommand(g);
		uhc.execute();
		RedoHandlerCommand rhc = new RedoHandlerCommand(g);
		rhc.execute();;
		boolean result = uhc.canUndo();
		String msg = "Testing a allowed Undo command followed by a redo command";
		assertEquals(exp,result,msg);
}
	@Test
	void testCantRedo() throws Exception {
	String path = "json/example_puzzle.json";
	Puzzle p = new Puzzle(path);
	GameState g = GameState.getInstance(p);
	boolean exp = false;
	g.saveCurrentHistory();
	UndoHandlerCommand uhc = new UndoHandlerCommand(g);
	boolean result = uhc.canUndo();
	String msg = "Testing a disallowed Undo command without a move or a redo command";
//	System.out.println(result);
	assertEquals(exp,result,msg);
}
	@Test
	void testCanRedoAfterUndo() throws Exception {
		String path = "json/example_puzzle.json";
		Puzzle p = new Puzzle(path);
		GameState g = GameState.getInstance(p);
		boolean exp = true;
		g.saveCurrentHistory();
		g.saveCurrentHistory();
		UndoHandlerCommand uhc = new UndoHandlerCommand(g);
		uhc.execute();
		RedoHandlerCommand rhc = new RedoHandlerCommand(g);
		boolean result = rhc.canRedo();
		String msg = "Testing a allowed Redo command followed by a undo command";
		assertEquals(exp,result,msg);
	}
@Test
void testCantUndo() throws Exception {
String path = "json/example_puzzle.json";
	Puzzle p = new Puzzle(path);
	GameState g = GameState.getInstance(p);
	boolean exp = false;
	g.saveCurrentHistory();
	g.saveCurrentHistory();
	RedoHandlerCommand rhc = new RedoHandlerCommand(g);
	boolean result = rhc.canRedo();
	String msg = "Testing a disallowed Redo command without previous undo command";
	assertEquals(exp,result,msg);
}

}
