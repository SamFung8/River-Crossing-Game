package Puzzle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PuzzleFactory {
	public Puzzle createPuzzleByJSON(String jsonPath) throws IOException, JSONException {
		String name;
		String description;
		ArrayList<String> roleList;
		HashSet<String> travelables = new HashSet<String>();
		PuzzleState initialState;
		PuzzleState targetState;
		JSONObject puzzleJSON;

		JSONObject jsonObj = null;
		
		Path file = Path.of(jsonPath);
		String obj = Files.readString(file);
		jsonObj = new JSONObject(obj);
		

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
		
		return new Puzzle(name,description, roleList, travelables, initialState, targetState, jsonObj);
	}
	
	public ArrayList<String> jsonArray2arrayList(JSONArray jsonArray) throws JSONException {
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = 0; i < jsonArray.length(); i++) {
			temp.add(jsonArray.get(i).toString());
		}
		return temp;
	}
	
}
