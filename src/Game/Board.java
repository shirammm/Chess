package Game;

import java.util.ArrayList;

import Pieces.*;

public class Board {

	private Piece[][] pieces;
	private boolean isInCheck;
	private final int width = 8;		
	private final int height = 8;	
	private final int size = 64;	
	private final char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
	private final char[] numbers = {'1', '2', '3', '4', '5', '6', '7', '8'};
	private Piece lastMoveBlack;
	private Piece lastMoveWhite;
	private ArrayList<Piece[][]> allPositions;
	
	public Board(){
		pieces = new Piece[height][width];
		allPositions = new ArrayList<Piece[][]>();
		initializePiecesArray();
		this.initializePieces();
		isInCheck = false;
		allPositions.add(pieces);
	}
	
	
	private void initializePiecesArray() {
		for(int rank=2; rank < 5; rank++)
			for(int file = 0; file < width; file++) 
				pieces[rank][file]=null; 
	}
	
	
	private void initializePieces() {
	
		//Initialize Pawns
		for(int i = 0; i < width; i++) {
			Pawn whitePawn = new Pawn(Color.WHITE, 6, i);
			pieces[6][i] = whitePawn;
			Pawn blackPawn = new Pawn(Color.BLACK, 1, i);
			pieces[1][i] = blackPawn;
		}
		
		//Initialize Rooks
		for(int i=0;i<2;i++) {
			Rook whiteRook = new Rook(Color.WHITE, 7, i*7);
			pieces[7][i*7] = whiteRook;
			Rook blackRook = new Rook(Color.BLACK, 0, i*7);
			pieces[0][i*7] = blackRook;
		}
		
		//Initialize Knights
		for(int i=0;i<2;i++) {
			Knight whiteKnight = new Knight(Color.WHITE, 7, 1+i*5);
			pieces[7][1+i*5] = whiteKnight;
			Knight blackKnight = new Knight(Color.BLACK, 0, 1+i*5);
			pieces[0][1+i*5] = blackKnight;
		} 
		
		//Initialize Bishops
		for(int i=0;i<2;i++) {
			Bishop whiteBishop = new Bishop(Color.WHITE, 7, 2+i*3);
			pieces[7][2+i*3] = whiteBishop;
			Bishop blackBishop = new Bishop(Color.BLACK, 0, 2+i*3);
			pieces[0][2+i*3] = blackBishop;
		} 
		
		//Initialize Queens
		Queen whiteQueen = new Queen(Color.WHITE, 7, 3);
		pieces[7][3] = whiteQueen;
		Queen blackQueen = new Queen(Color.BLACK, 0, 3);
		pieces[0][3] = blackQueen;
				
		//Initialize Kings
		King whiteKing = new King(Color.WHITE, 7, 4);
		pieces[7][4] = whiteKing;
		King blackKing = new King(Color.BLACK, 0, 4);
		pieces[0][4] = blackKing;
		
	}
	
	
	public int getWidth() {
		return width;
	}

	
	public int getHeight() {
		return height;
	}
	
	
	public Piece[][] getPieces() {
		return pieces;
	}
	

	public void printWhitePrespective() {
		System.out.println("White Prespective:");
		System.out.println("  |     a    |    b    |    c    |    d    |    e    |    f    |    g    |    h    |");
		for (int i=0; i<height; i++) {
			System.out.println("  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			System.out.print(numbers[7-i]+" | ");
			for (int j=0; j<width; j++) {
				Piece current = pieces[i][j];
				if(current==null)
					System.out.print("         |");
				else
					System.out.print(current.name()+"|");
			}
			System.out.println(" "+numbers[7-i]);
		}
		System.out.println("  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("  |     a    |    b    |    c    |    d    |    e    |    f    |    g    |    h    |");
		System.out.println();
	}
	
	
	public void printBlackPrespective() {
		System.out.println("Black Prespective:");
		System.out.println("  |    h    |    g    |    f    |    e    |    d    |    c    |    b    |    a    |");
		for (int i=height-1; i>-1; i--) {
			System.out.println("  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			System.out.print(numbers[7-i]+" |");
			for (int j=width-1; j>-1; j--) {
				Piece current = pieces[i][j];
				if(current==null)
					System.out.print("         |");
				else
					System.out.print(current.name()+"|");
			}
			System.out.println(" "+numbers[7-i]);
		}
		System.out.println("  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("  |    h    |    g    |    f    |    e    |    d    |    c    |    b    |    a    |");
		System.out.println();
	}
	
	
	public void move(Piece p) {
		allPositions.add(pieces);
		
		if(p.getColor() == Color.BLACK) 
			lastMoveBlack = p;
		
		else 
			lastMoveWhite = p;
		
	}
	
	
	public Piece getLastMoveBlack() {
		return lastMoveBlack;
	}
	
	
	public Piece getLastMoveWhite() {
		return lastMoveWhite;
	}
	
	public void setPieces(Piece[][] p) {
		pieces = p;
	}
	
	public boolean goXMovesBack(int x) {
		
		if(x>allPositions.size())
			return false;
		
		for(int i=allPositions.size()-1; i>i-x; i--) 
			allPositions.remove(i);
		pieces = allPositions.get(allPositions.size()-1);
		
		return true;
	}
	
}
