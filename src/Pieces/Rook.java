package Pieces;
import java.util.ArrayList;
import Game.*;

public class Rook extends Piece {

	public Rook(Color color, int location) {
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
		
		for(int dest : moves) 
			if(pieces[dest] != null && pieces[dest].getColor() == color)
				moves.remove(new Integer(dest));

		return moves;
	}

}
