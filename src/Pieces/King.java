package Pieces;
import java.util.ArrayList;
import Game.*;

public class King extends Piece {

	public King(Color color) {
		super(color);
	}

	public ArrayList<Integer> potentialMoves() {

		int myLocation = currentTile.getLocation();
		ArrayList<Integer> moves = new ArrayList<Integer>();
		int myX = myLocation % 8;
		int myY = myLocation / 8;
		int width = 8;
		int height = 8;
		
		if((myY + 1) < height) {

			moves.add(myX + (myY + 1)*8);
			
			if(myX - 1 >= 0) 
				moves.add(myX - 1 + (myY + 1)*8);
				
			if(myX + 1 < width) 
				moves.add(myX + 1 + (myY + 1)*8);
				
		}
			
		if((myY - 1) >= 0) {
			
			moves.add(myX + (myY - 1)*8);
			
			if(myX - 1 >= 0) 
				moves.add(myX - 1 + (myY - 1)*8);
			
			if(myX + 1 < width) 
				moves.add(myX + 1 + (myY - 1)*8);
			
		}
		
		if((myX - 1) >= 0) {
			moves.add(myX - 1 + myY*8);
		}
		
		if((myX + 1) < width) {
			moves.add(myX + 1 + myY*8);
		}
		
		return moves;
	}
}
