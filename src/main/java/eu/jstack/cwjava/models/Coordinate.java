package eu.jstack.cwjava.models;

public class Coordinate {
	private int x;
	private int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void updateX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void updateY(int y) {
		this.y = y;
	}
}
