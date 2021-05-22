package Game;

import Pieces.Piece;

public class Location {

	int rank;
	int file;
	
	public Location(int rank, int file) {
		this.rank=rank;
		this.file=file;
	}
	
	public int getRank(){
		return rank;
	}
	
	public int getFile(){
		return file;
	}
	
	public void setRank(int rank) {
		this.rank=rank;
	}
	
	public void setFile(int file) {
		this.file=file;
	}
	
	@Override
	public boolean equals(Object o) {
		Location l = (Location)o;
		if(l.getRank()==this.rank && l.getFile()==file)
			return true;
		return false;
	}
	
	public static Location recognizeLoc(String s) {
		int rank;
		int file;
		char[] chars = s.toCharArray();
		char letter = chars[0];
		char number = chars[1];
		rank = 56 - number;
		file = letter - 97;
		return new Location(rank, file);
	}
	
}
