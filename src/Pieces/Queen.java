package Pieces;
import java.util.ArrayList;
import Game.*;

public class Queen extends Piece {

	public Queen(Color color, int location) {
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
		
		for(int i = 0; i < width; i++) 
			if(i != myX) 
				moves.add(i + myY*8);

		for(int j = 0; j < height; j++) 
			if(j != myY) 
				moves.add(myX + j*8);

		for(int i = (myY + 1), j = (myX + 1); i < height && j < width; i++, j++) 
			moves.add(i*8 + j);

		for(int i = (myY + 1), j = (myX - 1); i < height && j >= 0; i++, j--) 
			moves.add(i*8 + j);

		for(int i = (myY - 1), j = (myX + 1); i >= 0 && j < width; i--, j++) 
			moves.add(i*8 + j);

		for(int i = (myY - 1), j = (myX - 1); i >= 0 && j >= 0; i--, j--) 
			moves.add(i*8 + j);
		
		for(int dest : moves) 
			if(pieces[dest] != null && pieces[dest].getColor() == color)
				moves.remove(new Integer(dest));
		
		return moves;
		
	}

}
