package Pieces;
import java.util.ArrayList;
import Game.*;

public class King extends Piece {

	public King(Color color, int location) {
		super(color, location);
	}
	
	public ArrayList<Integer> potentialMoves(Board b) {

		Piece[] pieces = b.getPieces();
		int myLocation = currentLocation;
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
		
		for(int dest : moves) 
			if(pieces[dest] != null && pieces[dest].getColor() == color)
				moves.remove(new Integer(dest));
		
		return moves;
	}
}
