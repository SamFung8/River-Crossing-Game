package TestCase;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Puzzle.Puzzle;

class TravelableTest {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testOneTravelable() {
		Puzzle p = new Puzzle("json/oneTravelable.json");
		String arr[] = {"farmer"};
		HashSet<String> expect = new HashSet<String>(Arrays.asList(arr));
		HashSet<String> result = p.getTravelables();
		String msg = "Testing only one travelable character";
		assertEquals(expect,result,msg);
	}
	@Test
	void testNoTravelable() {
		Puzzle p = new Puzzle("json/noTravelable.json");
		String arr[] = {};
		HashSet<String> expect = new HashSet<String>(Arrays.asList(arr));
		HashSet<String> result = p.getTravelables();
		String msg = "Testing no travelable character";
		assertEquals(expect,result,msg);
	}
	@Test
	void testAllTravelable() {
		Puzzle p = new Puzzle("json/allTravelable.json");
		String arr[] = {"farmer","sheep","tiger","grass"};
		HashSet<String> expect = new HashSet<String>(Arrays.asList(arr));
		HashSet<String> result = p.getTravelables();
		String msg = "Testing all travelable character";
		assertEquals(expect,result,msg);
	}
	@Test
	void testNotExistTravelable() {
		Puzzle p = new Puzzle("json/nonExistTravelable.json");
		String arr[] = {"farmer","shepherd"};
		HashSet<String> expect = new HashSet<String>(Arrays.asList(arr));
		HashSet<String> result = p.getTravelables();
		String msg = "Testing a not exist travelable character";
		assertEquals(expect,result,msg);
	}
	@Test
	void testDulTravelable() {
		Puzzle p = new Puzzle("json/dulplicateTravelable.json");
		String arr[] = {"farmer"};
		HashSet<String> expect = new HashSet<String>(Arrays.asList(arr));
		HashSet<String> result = p.getTravelables();
		String msg = "Testing a duplicated travelable character";
		assertEquals(expect,result,msg);
	}
}
