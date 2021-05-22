package Game;

public enum Color {

	WHITE, BLACK, NONE;
	
	public Color changeColor() {
		return (this == WHITE)? BLACK : WHITE;
		//if(this == BLACK)
			//return WHITE;
		//return BLACK;
	}
	
	public void belongingPrespective(Board b) {
		if(this == BLACK)
			b.printBlackPrespective();
		else
			b.printWhitePrespective();
	}
}
