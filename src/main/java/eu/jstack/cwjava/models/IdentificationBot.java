package eu.jstack.cwjava.models;

public class IdentificationBot {
	private String botId;
	private String botSecret;
	private String connection;

	public IdentificationBot(String botId, String botSecret, String connection) {
		this.botId = botId;
		this.botSecret = botSecret;
		this.connection = connection;
	}

	public String getBotId() {
		return botId;
	}

	public void updateBotId(String botId) {
		this.botId = botId;
	}

	public String getBotSecret() {
		return botSecret;
	}

	public void updateBotSecret(String botSecret) {
		this.botSecret = botSecret;
	}

	public String getConnection() {
		return connection;
	}

	public void updateConnection(String connection) {
		this.connection = connection;
	}
}
