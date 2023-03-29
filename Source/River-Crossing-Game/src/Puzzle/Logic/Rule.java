package Puzzle.Logic;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Puzzle.PuzzleState;

public abstract class Rule {
	ArrayList<String> groupA;
	ArrayList<String> groupB;
	Rule exception;
	String msg = "";
	
	public abstract Response isValid(PuzzleState state);
	
	public void parseJSON(JSONObject json) throws JSONException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		groupA = new ArrayList<String>();
		groupB = new ArrayList<String>();
		
		//group A 
		JSONArray roleArr = json.getJSONArray("Roles");
		String roleA = (String)roleArr.get(0);
		groupA.add(roleA);
		
		//group B
		JSONArray arr = (JSONArray) roleArr.get(1); 
		for(int i=0;i<arr.length();i++) {
			groupB.add(arr.get(i).toString());
		}
		
		//msg  = (String) json.get("Message1");
		try
		{
			msg = json.getString("Message");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		//exception
		RuleFactory factory = new RuleFactory();
		exception = factory.createRule(json.getJSONObject("Exception"));
	}
	
	public ArrayList<String> getGroupA() {
		return groupA;
	}
	public ArrayList<String> getGroupB() {
		return groupB;
	}
	public Rule getException() {
		return exception;
	}
	public String getMsg() {
		return msg;
	}
}