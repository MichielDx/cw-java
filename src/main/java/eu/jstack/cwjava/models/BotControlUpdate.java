package eu.jstack.cwjava.models;

public class BotControlUpdate {
	private String socketId;
	private String botId;
	private Controls controls;

	public BotControlUpdate(String socketId, String botId, Controls controls) {
		this.socketId = socketId;
		this.botId = botId;
		this.controls = controls;
	}

	public String getSocketId() {
		return socketId;
	}

	public void updateSocketId(String socketId) {
		this.socketId = socketId;
	}

	public String getBotId() {
		return botId;
	}

	public void updateBotId(String botId) {
		this.botId = botId;
	}

	public Controls getControls() {
		return controls;
	}

	public void updateControls(Controls controls) {
		this.controls = controls;
	}
}
