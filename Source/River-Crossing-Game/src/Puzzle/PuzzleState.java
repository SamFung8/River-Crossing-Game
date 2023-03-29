package Puzzle;

import java.util.ArrayList;
import java.util.HashSet;

public class PuzzleState {
	
	//Storage the current state of roles at landA and landB
	private ArrayList<String> landA = new ArrayList<String>();
	private ArrayList<String> landB = new ArrayList<String>();
	
	//Store the hashset version of lands, for faster look up speed
	private HashSet<String> hashLandA = new HashSet<String>();
	private HashSet<String> hashLandB = new HashSet<String>();
	
	private int boatPos = 0; // 0 = at landA, 1 = at landB
	
	public PuzzleState(ArrayList<String> landA, ArrayList<String> landB, int boatPos) {
		this.landA = landA;
		this.landB = landB;
		this.boatPos = boatPos;
		
		hashLandA = new HashSet<>(landA);
		hashLandB = new HashSet<>(landB);
	}
	
	//0 = landA, 1 = landB
	public ArrayList<String> getLandByID(int id)
	{
		return (id==0)?landA:landB;
	}
	
	public HashSet<String> getHashLandByID(int id)
	{
		return (id==0)?hashLandA:hashLandB;
	}
	 
	//for win condition checking, check if current state and target state is the same.
	public boolean isIdentical(PuzzleState state) {
		if(this.landA.size() != state.landA.size())
			return false;
		
		if(this.landB.size() != state.landB.size()) 
			return false;
		
		if(!this.landA.containsAll(state.landA))
			return false;
		
		if(!this.landB.containsAll(state.landB))
			return false;
			
		return true;
	}
	
	
	//return a new PuzzleState that applied the move (do not check if it is valid, be careful to use)
	public PuzzleState getNextState(Move move)
	{
		ArrayList<String> origin = (ArrayList<String>) getLandByID(move.getOrigin()).clone();
		ArrayList<String> dest = (ArrayList<String>) getLandByID(move.getDestination()).clone();
		
		//remove from origin, add to destination
		for(String role : move.getTravelers()) 
		{
			origin.remove(role);
			dest.add(role);
		}
		if(move.getDestination() == 1)
			return new PuzzleState(origin, dest, move.getDestination());
		else
			return new PuzzleState(dest, origin, move.getDestination());
	}
	
	public int getBoatPos() {
		return boatPos;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String msg = "";
		msg += "\nLand A: ";
		msg += landA.toString();
		if(boatPos==0)
			msg +="(boat)";
		
		msg += "\nLand B: ";
		msg+= landB.toString();
		if(boatPos==1)
			msg +="(boat)";
		
		return msg;
	}
}