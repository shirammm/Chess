package Pieces;
import java.util.ArrayList;
import Game.*;

public class Knight extends Piece {

	public Knight(Color color) {
		super(color);
	}
	
	public ArrayList<Integer> potentialMoves() {

		int myLocation = currentTile.getLocation();
		ArrayList<Integer> moves = new ArrayList<Integer>();
		int myX = myLocation % 8;
		int myY = myLocation / 8;
		int width = 8;
		int height = 8;
		
		if((myX + 2) < width && (myY + 1) < height) {
			moves.add(myX + 2 + (myY + 1)*8);
		}
		if((myX + 1) < width && (myY + 2) < height) {
			moves.add(myX + 1 + (myY + 2)*8);
		}
		if((myX + 2) < width && (myY - 1) >= 0) {
			moves.add(myX + 2 + (myY - 1)*8);
		}
		if((myX + 1) < width && (myY - 2) >= 0) {
			moves.add(myX + 1 + (myY - 2)*8);
		}
		if((myX - 2) >= 0 && (myY + 1) < height) {
			moves.add(myX - 2 + (myY + 1)*8);
		}
		if((myX - 1) >= 0 && (myY + 2) < height) {
			moves.add(myX - 1 + (myY + 2)*8);
		}
		if((myX - 2) >= 0 && (myY - 1) >= 0) {
			moves.add(myX - 2 + (myY - 1)*8);
		}
		if((myX - 1) >= 0 && (myY - 2) >= 0) {
			moves.add(myX - 1 + (myY - 2)*8);
		}

		return moves;
	}
	
}
