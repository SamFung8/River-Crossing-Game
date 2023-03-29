package Puzzle.Logic;

import org.json.JSONException;
import org.json.JSONObject;

public class RuleFactory {
    public Rule createRule(JSONObject json) throws JSONException, InstantiationException, IllegalAccessException, ClassNotFoundException {
    	if(json.length() == 0) //empty json object
    		return null;
    	
    	String ruleType = json.getString("RuleType");
    	Rule rule = (Rule) Class.forName("Puzzle.Logic."+ruleType+"Rule").newInstance();
    	rule.parseJSON(json);
    	return rule;
    }
}


//{
//	"PuzzleName": "Farmer-tiger-sheep-grass",
//	"Description": "tiger eat sheep, but farmer can protect sheep. Sheep eat grass if farmer not around. Only farmer can drive the boat",
//	"Roles": ["farmer", "tiger", "sheep", "grass"],
//	"InitialState": [
//		["farmer", "tiger", "sheep", "grass"],
//		[]
//	],
//	"TargetState": [
//		[],
//		["farmer", "tiger", "sheep","grass"]
//	],
//	"Travelable": ["farmer"],
//	
//	"Rules": [
//		{
//			"RuleType":"Conflict",
//			"Roles":["tiger",["sheep"]], 
//			"Message": "Tiger ate sheep",
//			"Exception": {"RuleType": "Coexist", "Roles":["tiger",["farmer"]], "Exception":{}}
//		},
//		{
//			"RuleType":"Conflict",
//			"Roles":["sheep",["grass"]], 
//			"Message": "Sheep ate grass",
//			"Exception": {"RuleType": "Coexist", "Roles":["sheep",["farmer"]], "Exception":{}}
//		}
//	]
//}