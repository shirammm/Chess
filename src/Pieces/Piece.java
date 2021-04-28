package Pieces;
import Game.*;

public class Piece {

	protected Color color;
	protected int currentLocation;
	
	public Piece(Color color, int currentLocation) {
		this.color = color;
		this.currentLocation = currentLocation;
	}
	
	public Color getColor() {
		return color;
	}
	
	public int getLocation() {
		return currentLocation;
	}

	
	public boolean vaildMove(int x, int y) {
		return true;
	}
	
	public boolean isOccupied() {
		return (color == Color.NONE);
	}
	
	
	
	/*
	file
	rank
	1D Board
	byte instead of int
	הצרחה
	el passant pawn 
	pawn change shape - כמו מלכה
	הרגיל אוכל בלאכסון
	*/
}
