package Puzzle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Puzzle.Logic.*;

public class Puzzle {
	private String name;
	private String description;
	private ArrayList<String> roleList;
	private HashSet<String> travelables = new HashSet<String>();
	private PuzzleState initialState;
	private PuzzleState targetState;
	private JSONObject puzzleJSON;

	public Puzzle(String name, String description, ArrayList<String> roleList, HashSet<String> travelables, PuzzleState initialState, PuzzleState targetState, JSONObject puzzleJSON)
	{
		this.name = name;
		this.description = description;
		this.roleList = roleList;
		this.travelables = travelables;
		this.initialState = initialState;
		this.targetState = targetState;
		this.puzzleJSON = puzzleJSON;
	}
	
	public Puzzle(String path) {
		JSONObject jsonObj = null;
		
		try {
			Path file = Path.of(path);
			String obj = Files.readString(file);
			jsonObj = new JSONObject(obj);

			// store the JSON obj, for other classes to access
			this.puzzleJSON = jsonObj;

			name = (String) jsonObj.get("PuzzleName");
			description = (String) jsonObj.get("Description");
			roleList = jsonArray2arrayList((JSONArray) jsonObj.get("Roles"));

			JSONArray jsonArray;
			jsonArray = (JSONArray) jsonObj.get("InitialState");
			initialState = new PuzzleState(jsonArray2arrayList((JSONArray) jsonArray.get(0)),
					jsonArray2arrayList((JSONArray) jsonArray.get(1)), 0);
			jsonArray = (JSONArray) jsonObj.get("TargetState");
			targetState = new PuzzleState(jsonArray2arrayList((JSONArray) jsonArray.get(0)),
					jsonArray2arrayList((JSONArray) jsonArray.get(1)), 0);
			
			travelables = new HashSet<String>(jsonArray2arrayList((JSONArray) jsonObj.get("Travelable")));
		} 
		catch (IOException e)
		{
			System.out.println("Invalid file path, exiting program...");
			System.exit(0);
		}
		catch (JSONException e)
		{
			System.out.println("Invalid JSON format, exiting program...");
			System.exit(0);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	
	}


	
	public ArrayList<String> jsonArray2arrayList(JSONArray jsonArray) throws JSONException {
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = 0; i < jsonArray.length(); i++) {
			temp.add(jsonArray.get(i).toString());
		}
		return temp;
	}
	

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public ArrayList<String> getRoleList() {
		return roleList;
	}

	public PuzzleState getInitialState() {
		return initialState;
	}

	public PuzzleState getTargetState() {
		return targetState;
	}

	public HashSet<String> getTravelables() {
		return travelables;
	}

	public JSONObject getPuzzleJSON() {
		return puzzleJSON;
	}

	public static void main(String[] args) {
//		Puzzle test = new Puzzle("json/example_puzzle.json");
//		System.out.println(test.name);
//		System.out.println(test.description);
//		System.out.println(test.roleList);
//		System.out.println(test.initialState.getLeft());
//		System.out.println(test.initialState.getRight());
//		System.out.println(test.targetState.getLeft());
//		System.out.println(test.targetState.getRight());
//		System.out.println(test.travelableTable);
//		System.out.println(test.checkTravelable("farmer"));
	}

}