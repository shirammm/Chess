package Pieces;
import java.util.ArrayList;
import Game.*;

public class Rook extends Piece {

	public Rook(Color color) {
		super(color);
	}
	
	public ArrayList<Integer> potentialMoves() {

		int myLocation = currentTile.getLocation();
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

		return moves;
	}

}
