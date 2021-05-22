package Game;

import java.util.Scanner;

import Pieces.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Board b = new Board();
		Piece[][] allPieces = b.getPieces();
		System.out.println("Lets start!");
		Scanner s = new Scanner(System.in);
		Color currColor = Color.WHITE;
		boolean thereIsPiece;
		String location;
		Piece movingPiece = null;
		boolean vaildDest;
		King blackKing = (King)allPieces[0][4];
		King whiteKing = (King)allPieces[7][4];
		boolean noCheckmate = true;
		
		while(noCheckmate) {
			
			if(currColor == Color.BLACK && blackKing.getIsInCheck() && blackKing.outOfCheck(b, blackKing.getLocation().getRank(), blackKing.getLocation().getFile()).isEmpty()) {
				System.out.println("Checkmate. The WHITE PLAYER won.");
				noCheckmate = false;
				return;
			}
				
			if(currColor == Color.WHITE && whiteKing.getIsInCheck() && whiteKing.outOfCheck(b, whiteKing.getLocation().getRank(), whiteKing.getLocation().getFile()).isEmpty()) {
				System.out.println("Checkmate. The BLACK PLAYER won.");
				noCheckmate = false;
				return;
			}
			
			System.out.println(currColor.toString()+" turn:");
			currColor.belongingPrespective(b);
			
			System.out.println("What is the location of the piece you want to move?");
			thereIsPiece = false;
			while(!thereIsPiece) {
				location = s.nextLine();
				movingPiece = allPieces[Location.recognizeLoc(location).getRank()][Location.recognizeLoc(location).getFile()];
				if(movingPiece == null)
					System.out.println("There's no piece in the tile you picked. Please enter again");
				else if(movingPiece.getColor() != currColor)
					System.out.println("You picked a " + currColor.toString() + " piece. Please pick a white one :)");
				else {
					System.out.println("You picked your "+movingPiece.getType()+", please enter the destination");
					thereIsPiece = true;
				}
			}
			
			vaildDest = false;
			while(!vaildDest) {
				String dest = s.nextLine();
				if(movingPiece.vaildMove(b, Location.recognizeLoc(dest).getRank(), Location.recognizeLoc(dest).getFile())) {
					movingPiece.move(Location.recognizeLoc(dest), b);
					b.move(movingPiece);
					vaildDest = true;
				}
				else
					System.out.println("You can't move there. Please enter a vaild destination");
			}
			currColor = currColor.changeColor();
			System.out.println("\n*********************************************\n");
		}
		
		/*
		System.out.println("Let's start!");
		int counter=0;
		while(true){
			counter++;
			if(counter%2 == 1) {
				System.out.println("WHITE TURN:\nTHE CURRENT BOARD:");
				b.printWhitePrespective();
				Scanner s = new Scanner(System.in);
				System.out.println("What are the Rank,File of the piece you want to move?");
				String current = s.nextLine();
				String[] RankFile = current.split(",");
				int currRank = Integer.valueOf(RankFile[0]);
				int currFile = Integer.valueOf(RankFile[1]);
				Piece curr = b.getPieces()[currRank][currFile];
				if(curr == null) {
					System.out.println("There is no piece in the location you picked");
					break;
				}
				System.out.println("What are the Rank,File of the destination you want to move to");
				String dest = s.nextLine();
				String[] dxy = dest.split(",");
				int destRank = Integer.valueOf(dxy[0]);
				int destFile = Integer.valueOf(dxy[1]);
				boolean isAble = curr.vaildMove(b, destRank, destFile);
				boolean again;
				if(!isAble)
					again = true;
					
			}
			else {
				
			}
		}
		*/
	}

}
