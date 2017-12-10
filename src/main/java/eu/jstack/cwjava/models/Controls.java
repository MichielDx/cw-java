package eu.jstack.cwjava.models;

public class Controls {
	private Direction direction;
	private boolean shooting;
	private boolean running;

	public Controls(Direction direction, boolean shooting, boolean running) {
		this.direction = direction;
		this.shooting = shooting;
		this.running = running;
	}

	public Direction getDirection() {
		return direction;
	}

	public void updateDirection(Direction direction) {
		this.direction = direction;
	}

	public boolean isShooting() {
		return shooting;
	}

	public void updateShooting(boolean shooting) {
		this.shooting = shooting;
	}

	public boolean isRunning() {
		return running;
	}

	public void updateRunning(boolean running) {
		this.running = running;
	}
}
