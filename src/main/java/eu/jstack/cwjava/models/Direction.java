package eu.jstack.cwjava.models;

public class Direction {
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;

	public Direction(boolean up, boolean down, boolean left, boolean right) {
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void updateUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void updateDown(boolean down) {
		this.down = down;
	}

	public boolean isLeft() {
		return left;
	}

	public void updateLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void updateRight(boolean right) {
		this.right = right;
	}
}
