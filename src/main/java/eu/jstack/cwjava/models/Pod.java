package eu.jstack.cwjava.models;

public class Pod {
	private Coordinate coordinates;
	private Long respawn;
	private int size;

	public Pod(Coordinate coordinates, Long respawn, int size) {
		this.coordinates = coordinates;
		this.respawn = respawn;
		this.size = size;
	}

	public Coordinate getCoordinates() {
		return coordinates;
	}

	public void updateCoordinates(Coordinate coordinates) {
		this.coordinates = coordinates;
	}

	public Long getRespawn() {
		return respawn;
	}

	public void updateRespawn(Long respawn) {
		this.respawn = respawn;
	}

	public int getSize() {
		return size;
	}

	public void updateSize(int size) {
		this.size = size;
	}
}
