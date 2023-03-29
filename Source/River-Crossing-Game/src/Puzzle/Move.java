package Puzzle;

import java.util.ArrayList;

public class Move {
    ArrayList<String> travelers;
	int origin, destination;
	
	public Move(String roleA, String roleB, int origin, int destination)
	{
		travelers = new ArrayList<String>();
		if(roleA != null)
			travelers.add(roleA);
		if(roleB != null)
			travelers.add(roleB);
		
		this.origin = origin;
		this.destination = destination;
	}
	
	public Move(ArrayList<String> travelers, int origin, int destination)
	{
		this.travelers = travelers;
		this.origin = origin;
		this.destination = destination;
	}
	
	public Move(int origin, int destination) {
		this.origin = origin;
		this.destination = destination;
		this.travelers = new ArrayList<String>();
	}

	public ArrayList<String> getTravelers() {
		return travelers;
	}
	
	public int getOrigin() {
		return origin;
	}
	
	public int getDestination() {
		return destination;
	}

	public void setTravelers(ArrayList<String> travelers) {
		this.travelers = travelers;
	}

	public void setOrigin(int origin) {
		this.origin = origin;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}
	
	public boolean isIdentical(Move move) {
		
		if(!travelers.equals(move.getTravelers()))
			return false;
		if(origin!=move.getOrigin())
			return false;
		if(destination!=move.getDestination())
			return false;
		
		return true;
	}
	
	@Override
	public String toString() {
		String[] landName = {"LandA", "LandB"};
		String msg = "";
		msg += "Move " + getTravelers().toString() + " from " + landName[origin] +" to " + landName[destination];
		return msg;
	}
}
