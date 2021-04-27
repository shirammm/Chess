package Game;

public enum Color {

	WHITE, BLACK;
	
	public Color changeColor() {
		return (this == WHITE)? BLACK : WHITE;
	}
}
