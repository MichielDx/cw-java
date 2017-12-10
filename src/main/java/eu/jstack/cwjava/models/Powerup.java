package eu.jstack.cwjava.models;

public class Powerup {
	private String name;
	private String value;
	private String initial;
	private long duration;

	public Powerup(String name, String value, String initial, long duration) {
		this.name = name;
		this.value = value;
		this.initial = initial;
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public void updateName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void updateValue(String value) {
		this.value = value;
	}

	public String getInitial() {
		return initial;
	}

	public void updateInitial(String initial) {
		this.initial = initial;
	}

	public long getDuration() {
		return duration;
	}

	public void updateDuration(long duration) {
		this.duration = duration;
	}
}
