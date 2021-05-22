package Pieces;
import java.util.ArrayList;
import Game.*;

public class King extends Piece{

	private boolean isInCheck;
	private boolean isFirstMove;
	private boolean wasInCheck;
	private boolean isCastling;
	
	
	public King(Color color, int rank, int file) {
		super(color, rank, file);
		isInCheck = false;
		isFirstMove= true;
	}
	
	
	public boolean vaildMove(Board board, int destRank, int destFile) {
		
		int currRank = location.getRank();
		int currFile = location.getFile();
		
		if((currRank==destRank) && (currFile==destFile)) 
			return false;
		
		Piece destPiece = board.getPieces()[destRank][destFile];
		
		if(destPiece != null && destPiece.getColor() == this.getColor()) 
			return false;
		
		if(isInCheck) {
			if(outOfCheck(board, currRank, currFile).contains(new Location(destRank, destFile)))
				return true;
			return false;
		}
		
		if(Math.abs(destRank - currRank) < 2 && Math.abs(destFile - currFile) < 2) {
			if(checkingCheck(board, destRank, destFile, currRank, currFile))
				isInCheck = true;
			return true;
		}

		//Castling
		if(isFirstMove) {
			Piece maybeRook = board.getPieces()[destRank][destFile+1];
			if(!isInCheck && !wasInCheck && destPiece == null && board.getPieces()[destRank][destFile-1] == null
					&& maybeRook.getType().equals("Rook"))
				if(((Rook)maybeRook).getIsFirstMove() == true) {
					isCastling = true;
					if(checkingCheck(board, destRank, destFile, currRank, currFile))
						isInCheck = true;
					return true;
				}
		}
		
		return false;
		
	}
	
	
	private boolean checkingCheck(Board b, int destRank, int destFile, int currRank, int currFile) {
		this.move(new Location(destRank, destFile), b);
		Piece[][] pieces = b.getPieces();
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++) {
				if(pieces[i][j] != null && pieces[i][j].getColor() != this.color && pieces[i][j].vaildMove(b, destRank,destFile)) {
					this.move(new Location(currRank, currFile), b);
					return true;
				}
			}
		this.move(new Location(currRank, currFile), b);
		return false;
	}

	
	public String name() {
		return "  "+this.getColorLetter()+"King  ";
	}
	
	
	public void move(Location dest, Board b) {
		super.move(dest, b);
		isFirstMove = false;
		if(isCastling) {
			Piece rook = b.getPieces()[dest.getRank()][dest.getFile()+1];
			rook.move(new Location(dest.getRank(),dest.getFile()-1),b);
			isCastling = false;
		}
		if(isInCheck)
			wasInCheck = true;
	}

	
	public ArrayList<Location> outOfCheck(Board board, int currR, int currF) {
		ArrayList<Location> possibleMoves = new ArrayList<>();
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++) {
				if(this.vaildMove(board, i, j)) {
					if(!checkingCheck(board, j, i, currR, currF))
						possibleMoves.add(new Location(i,j));
				}
			}
		
		return possibleMoves;
	}
	
	
	public boolean getIsInCheck() {
		return isInCheck;
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
		
		if((mFileFile + 1) < height) {

			moves.add(mFileRank + (mFileFile + 1)*8);
			
			if(mFileRank - 1 >= 0) 
				moves.add(mFileRank - 1 + (mFileFile + 1)*8);
				
			if(mFileRank + 1 < width) 
				moves.add(mFileRank + 1 + (mFileFile + 1)*8);
				
		}
			
		if((mFileFile - 1) >= 0) {
			
			moves.add(mFileRank + (mFileFile - 1)*8);
			
			if(mFileRank - 1 >= 0) 
				moves.add(mFileRank - 1 + (mFileFile - 1)*8);
			
			if(mFileRank + 1 < width) 
				moves.add(mFileRank + 1 + (mFileFile - 1)*8);
			
		}
		
		if((mFileRank - 1) >= 0) {
			moves.add(mFileRank - 1 + mFileFile*8);
		}
		
		if((mFileRank + 1) < width) {
			moves.add(mFileRank + 1 + mFileFile*8);
		}
		
		for(int dest : moves) 
			if(pieces[dest] != null && pieces[dest].getColor() == color)
				moves.remove(new Integer(dest));
		
		return moves;
	} */
}
