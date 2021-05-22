package Pieces;
import java.util.ArrayList;
import Game.*;

public class Rook extends Piece{

	private boolean isFirstMove;
	
	public Rook(Color color, int rank, int file) {
		super(color, rank, file);
		isFirstMove = true;
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

		// Destination is in the same file but in a higher rank.
		if(currRank == destRank && currFile < destFile) 
			for(int i = (currFile + 1); i < destFile; i++) {
				Piece toTest = board.getPieces()[currRank][i];
				movable = (toTest == null);
			}
		
		// Destination is in the same file but in a lower rank.
		else if(currRank == destRank && currFile > destFile) 
			for(int i = (currFile - 1); i > destFile; i--) {
				Piece toTest = board.getPieces()[currRank][i];
				movable = (toTest == null);
			}
		
		// Destination is in the same rank but in a higher file.
		else if(currFile == destFile && currRank < destRank) 
			for(int i = (currRank + 1); i < destRank; i++) {
				Piece toTest = board.getPieces()[i][currFile];
				movable = (toTest == null);
			}
		
		// Destination is in the same rank but in a lower file.
		else if(currFile == destFile && currRank > destRank) 
			for(int i = (currRank - 1); i > destRank; i--) {
				Piece toTest = board.getPieces()[i][currFile];
				movable = (toTest == null);
			}
		
		// Destination is some other tile on the board (can't move there).
		else 
			movable = false;
		

		return movable;
	}
	
	public String name() {
		return "  "+this.getColorLetter()+"Rook  ";
	}
	
	public boolean getIsFirstMove() {
		return isFirstMove;
	}
	

	public void move(Location dest, Board b) {
		super.move(dest, b);
		isFirstMove = false;
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
		
		for(int i = mFileRank+1; i < width; i++) {
			if(i != mFileRank) 
				moves.add(i + mFileFile*8);
		}
		
		for(int i = mFileRank-1; i < width; i++) 
			if(i != mFileRank) 
				moves.add(i + mFileFile*8);

		for(int j = 0; j < height; j++) 
			if(j != mFileFile) 
				moves.add(mFileRank + j*8);
		
		for(int dest : moves) 
			if(pieces[dest] != null && pieces[dest].getColor() == color)
				moves.remove(new Integer(dest));

		return moves;
	} */

}
