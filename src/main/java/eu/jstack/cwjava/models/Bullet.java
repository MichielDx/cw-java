package eu.jstack.cwjava.models;

public class Bullet {
	private Coordinate coordinates;
	private Direction direction;
	private int size;

	public Bullet(Coordinate coordinates, Direction direction, int size) {
		this.coordinates = coordinates;
		this.direction = direction;
		this.size = size;
	}

	public Coordinate getCoordinates() {
		return coordinates;
	}

	public void updateCoordinates(Coordinate coordinates) {
		this.coordinates = coordinates;
	}

	public Direction getDirection() {
		return direction;
	}

	public void updateDirection(Direction direction) {
		this.direction = direction;
	}

	public int getSize() {
		return size;
	}

	public void updateSize(int size) {
		this.size = size;
	}
}
