package eu.jstack.cwjava.models;

import java.util.List;

public class Map {
	private int tileSize;
	private int xlen;
	private int ylen;
	private List<Tile> tiles;

	public Map(int tileSize, int xlen, int ylen, List<Tile> tiles) {
		this.tileSize = tileSize;
		this.xlen = xlen;
		this.ylen = ylen;
		this.tiles = tiles;
	}

	public int getTileSize() {
		return tileSize;
	}

	public void updateTileSize(int tileSize) {
		this.tileSize = tileSize;
	}

	public int getXlen() {
		return xlen;
	}

	public void updateXlen(int xlen) {
		this.xlen = xlen;
	}

	public int getYlen() {
		return ylen;
	}

	public void updateYlen(int ylen) {
		this.ylen = ylen;
	}

	public List<Tile> getTiles() {
		return tiles;
	}

	public void updateTiles(List<Tile> tiles) {
		this.tiles = tiles;
	}
}
