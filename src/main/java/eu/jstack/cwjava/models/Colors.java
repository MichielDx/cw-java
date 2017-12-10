package eu.jstack.cwjava.models;

public class Colors {
	private String foreground;
	private String background;

	public Colors(String foreground, String background) {
		this.foreground = foreground;
		this.background = background;
	}

	public String getForeground() {
		return foreground;
	}

	public void updateForeground(String foreground) {
		this.foreground = foreground;
	}

	public String getBackground() {
		return background;
	}

	public void updateBackground(String background) {
		this.background = background;
	}
}
