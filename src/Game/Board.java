package Game;

import Pieces.*;

public class Board {

	private Piece[] pieces;
	//private ArrayList<Piece> pieces;	
	private boolean isInCheck;
	private final int width = 8;		
	private final int height = 8;	
	private final int size = 64;	
	
	public Board(){
		pieces = new Piece[size];
		initializePiecesArray();
		this.initializePieces();
		isInCheck = false;
	}
	
	
	private void initializePiecesArray() {
		for(int x = 0; x < size; x++) {
			////pieces[x] = new Piece(Color.NONE, x); //////option
			pieces[x]=null; 
		}
	}
	
	
	private void initializePieces() {
		
		
		
		
		//int[] pieces = new int[64];
		
		
		
		
		String blackColor = "0";
		String whiteColor = "1";
		
		String pawn = "001";
		String rook = "010";
		String knight = "011";
		String bishop = "100";
		String queen = "101";
		String king = "111";
		
		String binaryPiece = blackColor + pawn;
		
		int newPiece = Integer.parseInt(binaryPiece,2);
		
		
		
		
		
		
		
		
		
		
		//Initialize Pawns
		for(int x = 0; x < width; x++) {
			Pawn whitePawn = new Pawn(Color.WHITE, size-1-x-width);
			pieces[size-1-x-width] = whitePawn;
			Pawn blackPawn = new Pawn(Color.BLACK, x+width);
			pieces[x+width] = blackPawn;
		}
		
		//Initialize Rooks
		for(int i=0;i<2;i++) {
			Rook whiteRook = new Rook(Color.WHITE, size-1-i*7);
			pieces[size-1-i*7] = whiteRook;
			Rook blackRook = new Rook(Color.BLACK, i*7);
			pieces[i*7] = blackRook;
		}
		
		//Initialize Knights
		for(int i=0;i<2;i++) {
			Knight whiteKnight = new Knight(Color.WHITE, size-2-i*5);
			pieces[size-2-i*5] = whiteKnight;
			Knight blackKnight = new Knight(Color.BLACK, 1+i*5);
			pieces[1+i*5] = blackKnight;
		} 
		
		//Initialize Bishops
		for(int i=0;i<2;i++) {
			Bishop whiteBishop = new Bishop(Color.WHITE, size-3-i*3);
			pieces[size-3-i*3] = whiteBishop;
			Bishop blackBishop = new Bishop(Color.BLACK, 2+i*3);
			pieces[2+i*3] = blackBishop;
		} 
		
		//Initialize Queens
		Queen whiteQueen = new Queen(Color.WHITE, size-5);
		pieces[size-5] = whiteQueen;
		Queen blackQueen = new Queen(Color.BLACK, 3);
		pieces[3] = blackQueen;
				
		//Initialize Kings
		King whiteKing = new King(Color.WHITE, size-4);
		pieces[size-4] = whiteKing;
		King blackKing = new King(Color.BLACK, 4);
		pieces[4] = blackKing;
		
	}
	
	
	public int getWidth() {
		return width;
	}

	
	public int getHeight() {
		return height;
	}
	
	
	public Piece[] getPieces() {
		return pieces;
	}
	
	
}
