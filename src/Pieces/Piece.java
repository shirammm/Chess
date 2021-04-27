package Pieces;
import Game.*;

public class Piece {

	protected Color color;
	protected Tile currentTile;
	
	public Piece(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public Tile getLocation() {
		return currentTile;
	}

	
	public boolean vaildMove(int x, int y) {
		return true;
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
