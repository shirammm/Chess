package Pieces;
import java.util.ArrayList;

import Game.*;

public class Bishop extends Piece {

	public Bishop(Color color) {
		super(color);
	}
	
	public ArrayList<Integer> potentialMoves() {

		int myLocation = currentTile.getLocation();
		ArrayList<Integer> moves = new ArrayList<Integer>();
		int myX = myLocation % 8;
		int myY = myLocation / 8;
		int width = 8;
		int height = 8;
		
		for(int i = (myY + 1), j = (myX + 1); i < height && j < width; i++, j++) 
			moves.add(i*8 + j);

		for(int i = (myY + 1), j = (myX - 1); i < height && j >= 0; i++, j--) 
			moves.add(i*8 + j);

		for(int i = (myY - 1), j = (myX + 1); i >= 0 && j < width; i--, j++) 
			moves.add(i*8 + j);

		for(int i = (myY - 1), j = (myX - 1); i >= 0 && j >= 0; i--, j--) 
			moves.add(i*8 + j);

		return moves;
	}

}
