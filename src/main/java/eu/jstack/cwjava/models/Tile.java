package eu.jstack.cwjava.models;

public class Tile {
	private int tx;
	private int ty;
	private boolean walkable;

	public Tile(int tx, int ty, boolean walkable) {
		this.tx = tx;
		this.ty = ty;
		this.walkable = walkable;
	}

	public int getTx() {
		return tx;
	}

	public void updateTx(int tx) {
		this.tx = tx;
	}

	public int getTy() {
		return ty;
	}

	public void updateTy(int ty) {
		this.ty = ty;
	}

	public boolean isWalkable() {
		return walkable;
	}

	public void updateWalkable(boolean walkable) {
		this.walkable = walkable;
	}
}
