package Pieces;
import java.util.ArrayList;
import Game.*;

public class Pawn extends Piece{

	private boolean firstMove;
	private Location oneBeforeLocation;
	private boolean rightEnPassant;
	private boolean leftEnPassant;
	
	public Pawn(Color color, int rank, int file) {
		super(color, rank, file);
		firstMove = true;
	}

	
	public boolean vaildMove(Board board, int destRank, int destFile) {
		
		int currRank = location.getRank();
		int currFile = location.getFile();
		
		
		if((currRank==destRank) && (currFile==destFile)) 
			return false;
		
		
		Piece destPiece = board.getPieces()[destRank][destFile];
		if(destPiece != null && destPiece.getColor() == this.getColor()) 
			return false;

		
		int direction;
		if(color == Color.WHITE)
			direction = -1;
		else
			direction = 1;
		

		if(destFile == currFile && destRank == (currRank + direction*1) && destPiece == null) 
				return true;
			
		else if(destFile == currFile && destRank == (currRank + direction*2) && board.getPieces()[currRank+direction*1][currFile] == null && destPiece == null && firstMove) 
				return true;
						
		else if((destFile == (currFile + 1) || destFile == (currFile + direction*1)) && destRank == (currRank + direction*1) && destPiece != null) 
				return true;
			
		//right enPassant
		if(currFile < 7) {
			Piece maybePawn = board.getPieces()[currRank][currFile+1];
			if(maybePawn != null && destPiece == null) {
				if(maybePawn.getType().equals("Pawn") && 
				((Pawn)maybePawn).getOneBeforeLocation().getRank() == maybePawn.getLocation().getRank() + 2*direction) {
					if(color == Color.BLACK && board.getLastMoveWhite() == maybePawn) {
						rightEnPassant = true;
						return true;
					}
					else if (color == Color.WHITE && board.getLastMoveBlack() == maybePawn) {
						rightEnPassant = true;
						return true;
					}
				}
			}
		}
		
		//left enPassant
				if(currFile > 0) {
					System.out.println("hello1");
					Piece maybePawn = board.getPieces()[currRank][currFile-1];
					if(maybePawn != null && destPiece == null) {
						System.out.println("hello2");
						System.out.println("maybePawn.getLocation().getRank()="+maybePawn.getLocation().getRank());
						System.out.println("(Pawn)maybePawn).getOneBeforeLocation().getRank()="+((Pawn)maybePawn).getOneBeforeLocation().getRank());
						if(maybePawn.getType().equals("Pawn") && 
						((Pawn)maybePawn).getOneBeforeLocation().getRank() == maybePawn.getLocation().getRank() + 2*direction) {
							System.out.println("hello3");
							if(color == Color.BLACK && board.getLastMoveWhite() == maybePawn) {
								leftEnPassant = true;
								return true;
							}
							else if (color == Color.WHITE && board.getLastMoveBlack() == maybePawn) {
								leftEnPassant = true;
								return true;
							}
						}
					}
				}
		
		
		return false;
		
	}
	
	
	public void move(Location dest, Board b) {
		if(rightEnPassant)
			b.getPieces()[location.getRank()][location.getFile()+1] = null;
		if(leftEnPassant)
			b.getPieces()[location.getRank()][location.getFile()-1] = null;
		oneBeforeLocation = location;
		super.move(dest, b);
		firstMove = false;
	}
	
	
	public String name() {
		return "  "+this.getColorLetter()+"Pawn  ";
	}
	
	public Location getOneBeforeLocation() {
		return oneBeforeLocation;
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

		if((color == Color.WHITE) && (mFileFile!=0)) {
			//one step up
			moves.add(mFileRank + (mFileFile-1)*8);
			//two step up
			if(pieces[mFileRank + (mFileFile-1)*8] == null && firstMove)
				moves.add(mFileRank + (mFileFile-2)*8);
			//right up diagonal
			if(pieces[mFileRank+1 + (mFileFile-1)*8] != null && mFileRank != width-1)
				moves.add(mFileRank+1 + (mFileFile-1)*8);
			//left up diagonal
			if(pieces[mFileRank-1 + (mFileFile-1)*8] != null && mFileRank != 0)
				moves.add(mFileRank-1 + (mFileFile-1)*8);
		}

		else if(mFileFile != (height-1)){
			//one step down
			moves.add(mFileRank + (mFileFile+1)*8);
			//two step down
			if(pieces[mFileRank + (mFileFile+1)*8] == null && firstMove)
				moves.add(mFileRank + (mFileFile+2)*8);
			//right down diagonal
			if(pieces[mFileRank+1 + (mFileFile+1)*8] != null && mFileRank != width-1)
				moves.add(mFileRank+1 + (mFileFile+1)*8);
			//left down diagonal
			if(pieces[mFileRank-1 + (mFileFile+1)*8] != null && pieces[mFileRank-1 + (mFileFile+1)*8].getColor() != color && mFileRank != 0)
				moves.add(mFileRank-1 + (mFileFile+1)*8);
		}
		
		for(int dest : moves) 
			if(pieces[dest].getColor() == color)
				moves.remove(new Integer(dest));

		return moves;
	}
	*/
}
