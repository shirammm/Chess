package Game;

import Pieces.*;

public class Board {

	private Tile[] tiles; 			
	//private ArrayList<Piece> pieces;	
	private boolean isInCheck;
	private final int width = 8;		
	private final int height = 8;	
	private final int size = 64;	
	
	public Board(){
		tiles = new Tile[size];
		initializeTiles();
		this.initializePieces();
		isInCheck = false;
	}
	
	private void initializeTiles() {
		Color tileColor = Color.BLACK;
		for(int x = 0; x < size; x++) {
			tiles[x] = new Tile(x, tileColor);
			tileColor = tileColor.changeColor();
		}
	}

	
	private void initializePieces() {
		for(int x = 0; x < width; x++) {
			Pawn whitePawn = new Pawn(Color.WHITE);
			tiles[x+width].setPiece(whitePawn);
			Pawn blackPawn = new Pawn(Color.BLACK);
			tiles[size-x-width].setPiece(blackPawn);
		}
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public Tile[] getTiles() {
		return tiles;
	}
	
	
}
