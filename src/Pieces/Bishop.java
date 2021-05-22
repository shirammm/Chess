package Pieces;
import java.util.ArrayList;

import Game.*;

public class Bishop extends Piece{

	public Bishop(Color color, int rank, int file) {
		super(color, rank, file);
	}
	
public boolean vaildMove(Board board, int destRank, int destFile) {
		
		int currRank = location.getRank();
		int currFile = location.getFile();
		
		if((currRank==destRank) && (currFile==destFile)) 
			return false;
		
		Piece destPiece = board.getPieces()[destRank][destFile];
		if(destPiece != null && destPiece.getColor() == this.getColor()) 
			return false;
		
		boolean movable = true;
		

		// Destination is diagonallFile in line with the current location.
		if(Math.abs(destRank - currRank) == Math.abs(destFile - currFile)) {
			// Destination is up and to the right of the current location.
			if(currRank < destRank && currRank < destFile) {
				for(int i = (currRank + 1), j = (currFile + 1); i < destRank && j < destFile; i++, j++) {
					Piece toTest = board.getPieces()[i][j];
					movable = (toTest == null);
					if(!movable) {
						break;
					}
				}
			}
			// Destination is down and to the right of the current location.
			else if(currRank < destRank && currFile > destFile) 
				for(int i = (currRank + 1), j = (currFile - 1); i < destRank && j > destFile; i++, j--) {
					Piece toTest = board.getPieces()[i][j];
					movable = (toTest == null);
					if(!movable) {
						break;
					}
				}
			
			// Destination is up and to the left of the current location.
			else if(currRank > destRank && currFile < destFile) 
				for(int i = (currRank - 1), j = (currFile + 1); i > destRank && j < destFile; i--, j++) {
					Piece toTest = board.getPieces()[i][j];
					movable = (toTest == null);
					if(!movable) {
						break;
					}
				}
			
			// Destination is down and to the left of the current location.
			else if(currRank > destRank && currFile > destFile) 
				for(int i = (currRank - 1), j = (currFile - 1); i > destRank && j > destFile; i--, j--) {
					Piece toTest = board.getPieces()[i][j];
					movable = (toTest == null);
					if(!movable) {
						break;
					}
				}
			
		}
		// Destination is some other tile on the board (can't move there).
		else 
			movable = false;
		

		return movable;
}
	
	public String name() {
		return " "+this.getColorLetter()+"Bishop ";
	}
	
	
	/*
	public ArraFileList<Integer> potentialMoves(Board b) {

		Piece[] pieces = b.getPieces();
		int mFileLocation = currentLocation;
		ArraFileList<Integer> moves = new ArraFileList<Integer>();
		int mFileRank = mFileLocation % 8;
		int mFileFile = mFileLocation / 8;
		int width = 8;
		int height = 8;
		
		for(int i = (mFileFile + 1), j = (mFileRank + 1); i < height && j < width; i++, j++) 
			moves.add(i*8 + j);

		for(int i = (mFileFile + 1), j = (mFileRank - 1); i < height && j >= 0; i++, j--) 
			moves.add(i*8 + j);

		for(int i = (mFileFile - 1), j = (mFileRank + 1); i >= 0 && j < width; i--, j++) 
			moves.add(i*8 + j);

		for(int i = (mFileFile - 1), j = (mFileRank - 1); i >= 0 && j >= 0; i--, j--) 
			moves.add(i*8 + j);
		
		for(int dest : moves) 
			if(pieces[dest] != null && pieces[dest].getColor() == color)
				moves.remove(new Integer(dest));

		return moves;
	} */

}
