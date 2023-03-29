package Puzzle.Logic;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Puzzle.PuzzleState;

public class CoexistRule extends Rule{
	@Override
	public Response isValid(PuzzleState state) {
		String roleA = getGroupA().get(0);
		
		//check exception first
		if(exception != null)
			if(exception.isValid(state).isValid()==true)
				return new Response(true, "" );
		
		for(String roleB : getGroupB())
		{
			for(int i=0;i<2;i++)
			{
				if(state.getHashLandByID(i).contains(roleB))
					if(!state.getHashLandByID(i).contains(roleA))
						//return new Response(false, msg);		
						return new Response(false, "Coexist rule violated (" + roleA + ", "+roleB+"), Reason: "+msg);		
			}
		}
		
		return new Response(true, "" );
	}
}
