package TestCase;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Puzzle.Move;
import Puzzle.PuzzleState;

class NextStateTest {

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void testGetNextState1() {
		ArrayList<String> TlandA = new ArrayList<String>(Arrays.asList("farmer", "sheep"));
		ArrayList<String> TlandB = new ArrayList<String>(Arrays.asList("tiger", "grass"));
		int initialOrgin = 0;
		PuzzleState ps = new PuzzleState(TlandA,TlandB,initialOrgin);
		Move m = new Move("farmer","sheep",0,1);
		PuzzleState newState = ps.getNextState(m);
		
		ArrayList<String>ExplandA = new ArrayList<String>(Arrays.asList());
		ArrayList<String>ExplandB = new ArrayList<String>(Arrays.asList("farmer", "sheep","tiger", "grass"));
		int Exppos = 1;
		PuzzleState expState = new PuzzleState(ExplandA,ExplandB,Exppos);
		
		boolean result_state = newState.isIdentical(expState);
		int result_pos = newState.getBoatPos();
		
		String msg;
		msg = "Testing two travellers successfully travel from landA to landB";
		assertEquals(true,result_state,msg);
		//only test boat position if there are travelers
		if(!(TlandA.containsAll(ExplandA) && TlandB.containsAll(ExplandB))) {
		
		msg = "Testing boat on landB(1)";
		assertEquals(1,result_pos,msg);	
		}
	}
	@Test
	void testGetNextState2() {
		ArrayList<String> TlandA = new ArrayList<String>(Arrays.asList("tiger", "grass"));
		ArrayList<String> TlandB = new ArrayList<String>(Arrays.asList("farmer", "sheep"));
		int initialOrgin = 1;
		PuzzleState ps = new PuzzleState(TlandA,TlandB,initialOrgin);
		Move m = new Move("farmer","sheep",1,0);
		PuzzleState newState = ps.getNextState(m);
		
		ArrayList<String>ExplandA = new ArrayList<String>(Arrays.asList("farmer", "sheep","tiger", "grass"));
		ArrayList<String>ExplandB = new ArrayList<String>(Arrays.asList());
		int Exppos = 1;
		PuzzleState expState = new PuzzleState(ExplandA,ExplandB,Exppos);
		
		boolean result_state = newState.isIdentical(expState);
		int result_pos = newState.getBoatPos();
		
		String msg;
		msg = "Testing two travellers successfully travel from landB to landA";
		assertEquals(true,result_state,msg);
		//only test boat position if there are travelers
		if(!(TlandA.containsAll(ExplandA) && TlandB.containsAll(ExplandB))) {
		
		msg = "Testing boat on landA(0)";
		assertEquals(0,result_pos,msg);	
		}
	}
	@Test
	void testGetNextState3() {
		ArrayList<String> TlandA = new ArrayList<String>(Arrays.asList("farmer", "sheep"));
		ArrayList<String> TlandB = new ArrayList<String>(Arrays.asList("tiger", "grass"));
		int initialOrgin = 0;
		PuzzleState ps = new PuzzleState(TlandA,TlandB,initialOrgin);
		Move m = new Move(0,1);
		PuzzleState newState = ps.getNextState(m);
		
		ArrayList<String>ExplandA = new ArrayList<String>(Arrays.asList("farmer", "sheep"));
		ArrayList<String>ExplandB = new ArrayList<String>(Arrays.asList("tiger", "grass"));
		int Exppos = 0;
		PuzzleState expState = new PuzzleState(ExplandA,ExplandB,Exppos);
		
		boolean result_state = newState.isIdentical(expState);
		int result_pos = newState.getBoatPos();
		
		String msg;
		msg = "Testing no travelers travel";
		assertEquals(true,result_state,msg);
		//only test boat position if there are travelers
		if(!(TlandA.containsAll(ExplandA) && TlandB.containsAll(ExplandB))) {

			msg = "Testing boat on landB(1)";
			assertEquals(0,result_pos,msg);	
		}
	}
	@Test
	void testGetNextState4() {
		ArrayList<String> TlandA = new ArrayList<String>(Arrays.asList("farmer"));
		ArrayList<String> TlandB = new ArrayList<String>(Arrays.asList("tiger", "grass", "sheep"));
		int initialOrgin = 0;
		PuzzleState ps = new PuzzleState(TlandA,TlandB,initialOrgin);
		Move m = new Move(TlandA,0,1);
		PuzzleState newState = ps.getNextState(m);
		
		ArrayList<String>ExplandA = new ArrayList<String>(Arrays.asList());
		ArrayList<String>ExplandB = new ArrayList<String>(Arrays.asList("farmer", "sheep","tiger", "grass"));
		int Exppos = 1;
		PuzzleState expState = new PuzzleState(ExplandA,ExplandB,Exppos);
		
		boolean result_state = newState.isIdentical(expState);
		int result_pos = newState.getBoatPos();
		
		String msg;
		msg = "Testing one travelers successfully travel from landA to landB";
		assertEquals(true,result_state,msg);
		//only test boat position if there are travelers
		if(!(TlandA.containsAll(ExplandA) && TlandB.containsAll(ExplandB))) {
					
					msg = "Testing boat on landB(1)";
					assertEquals(1,result_pos,msg);	
				}
	}
	@Test
	void testGetNextState5() {
		ArrayList<String> TlandA = new ArrayList<String>(Arrays.asList("tiger", "grass", "sheep"));
		ArrayList<String> TlandB = new ArrayList<String>(Arrays.asList("farmer"));
		int initialOrgin = 1;
		PuzzleState ps = new PuzzleState(TlandA,TlandB,initialOrgin);
		Move m = new Move(TlandB,1,0);
		PuzzleState newState = ps.getNextState(m);
		
		ArrayList<String>ExplandA = new ArrayList<String>(Arrays.asList("farmer", "sheep","tiger", "grass"));
		ArrayList<String>ExplandB = new ArrayList<String>(Arrays.asList());
		int Exppos = 0;
		PuzzleState expState = new PuzzleState(ExplandA,ExplandB,Exppos);
		
		boolean result_state = newState.isIdentical(expState);
		int result_pos = newState.getBoatPos();
		
		String msg;
		msg = "Testing one traveller successfully travel from landB to landA";
		assertEquals(true,result_state,msg);
		if(!(TlandA.containsAll(ExplandA) && TlandB.containsAll(ExplandB))) {
			
		msg = "Testing boat on landA(0)";
		assertEquals(0,result_pos,msg);	
		}
	}

}
