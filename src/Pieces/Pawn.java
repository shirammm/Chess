package Pieces;
import java.util.ArrayList;
import Game.*;

public class Pawn extends Piece {

	private boolean firstMove;
	
	public Pawn(Color color, int location) {
		super(color, location);
		firstMove = true;
	}
	
//Add change function for firstMove
	
	public ArrayList<Integer> potentialMoves(Board b) {

		Piece[] pieces = b.getPieces();
		int myLocation = currentLocation;
		ArrayList<Integer> moves = new ArrayList<Integer>();

		if(color == Color.WHITE) {
			if((myLocation - 7) > -1 && myLocation/8 != (myLocation - 7)/8)
				moves.add(myLocation - 7);
			if((myLocation - 8) > -1) 
				moves.add(myLocation - 8);
			if((myLocation - 9) > -1) 
				moves.add(myLocation - 9);
			if((myLocation - 16) > -1 && firstMove)
				moves.add(myLocation - 16);
		}

		else {
			if((myLocation + 7) < 64 && myLocation/8 != (myLocation + 7)/8) 
				moves.add(myLocation + 7);
			if((myLocation + 8) < 64) 
				moves.add(myLocation + 8);
				moves.add(myLocation - 7);
			if((myLocation - 9) < 64) 
				moves.add(myLocation - 9);
			if((myLocation - 16) < 64 && firstMove)
				moves.add(myLocation - 9);
		}
		
		for(int dest : moves) 
			if(pieces[dest] != null && pieces[dest].getColor() == color)
				moves.remove(new Integer(dest));

		return moves;
	}
	

}
