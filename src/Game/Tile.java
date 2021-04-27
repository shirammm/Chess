package Game;
import Pieces.Piece;

public class Tile {

	private final int location;	
	private Color color;
	private Piece currentPiece;
	
	public Tile(int location, Color color) {
		this.location = location;
		this.color = color;
		currentPiece = null;
	}
	
	public void setPiece(Piece newPiece) {
		currentPiece = newPiece;
	}
	
	public Piece getPiece() {
		return currentPiece;
	}
	
	public int getLocation() {
		return location;
	}
	
	public boolean isOccupied() {
		return (currentPiece == null);
	}
}
