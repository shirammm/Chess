package Game;

public enum Color {

	WHITE, BLACK, NONE;
	
	public Color changeColor() {
		return (this == WHITE)? BLACK : WHITE;
	}
}
