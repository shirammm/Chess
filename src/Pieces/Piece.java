
package Pieces;
import Game.*;

public abstract class Piece {

	protected Color color;
	protected Location location;
	
	public Piece(Color color, int rank, int file) {
		this.color = color;
		location = new Location(rank,file);
	}
	
	public Color getColor() {
		return color;
	}
	
	public String getColorLetter() {
		if(color == Color.BLACK)
			return "B";
		else
			return "W";
	}
	
	public Location getLocation() {
		return location;
	}
	
	public String getType() {
		String s=this.getClass().getName();
		s=s.substring(7);
		return s;
	}

	public abstract boolean vaildMove(Board board, int destRank, int destFile);

	//public boolean vaildMove(int Rank, int File) {}
	
	
	public boolean isOccupied() {
		return (color == Color.NONE);
	}
	
	public String name() {
		return "";
	}
	
	public void move(Location dest, Board b) {
		b.getPieces()[location.getRank()][location.getFile()] = null;
		b.getPieces()[dest.getRank()][dest.getFile()] = this;
		location = dest;
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

