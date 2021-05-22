package Pieces;
import java.util.ArrayList;
import Game.*;

public class Knight extends Piece{

	public Knight(Color color, int rank, int file) {
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
		
		if( (Math.abs(currRank-destRank)==1 && Math.abs(currFile-destFile)==4) || (Math.abs(currRank-destRank)==4 && Math.abs(currFile-destFile)==1) )
			return true;
		
		return false;
}
	
public String name() {
	return " "+this.getColorLetter()+"Knight ";
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
		
		if((mFileRank + 2) < width && (mFileFile + 1) < height) {
			moves.add(mFileRank + 2 + (mFileFile + 1)*8);
		}
		if((mFileRank + 1) < width && (mFileFile + 2) < height) {
			moves.add(mFileRank + 1 + (mFileFile + 2)*8);
		}
		if((mFileRank + 2) < width && (mFileFile - 1) >= 0) {
			moves.add(mFileRank + 2 + (mFileFile - 1)*8);
		}
		if((mFileRank + 1) < width && (mFileFile - 2) >= 0) {
			moves.add(mFileRank + 1 + (mFileFile - 2)*8);
		}
		if((mFileRank - 2) >= 0 && (mFileFile + 1) < height) {
			moves.add(mFileRank - 2 + (mFileFile + 1)*8);
		}
		if((mFileRank - 1) >= 0 && (mFileFile + 2) < height) {
			moves.add(mFileRank - 1 + (mFileFile + 2)*8);
		}
		if((mFileRank - 2) >= 0 && (mFileFile - 1) >= 0) {
			moves.add(mFileRank - 2 + (mFileFile - 1)*8);
		}
		if((mFileRank - 1) >= 0 && (mFileFile - 2) >= 0) {
			moves.add(mFileRank - 1 + (mFileFile - 2)*8);
		}
		
		for(int dest : moves) 
			if(pieces[dest] != null && pieces[dest].getColor() == color)
				moves.remove(new Integer(dest));

		return moves;
	} */
	
}
