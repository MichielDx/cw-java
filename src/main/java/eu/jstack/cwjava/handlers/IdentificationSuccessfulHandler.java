package eu.jstack.cwjava.handlers;

import com.google.gson.Gson;
import eu.jstack.cwjava.models.IdentificationBot;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class IdentificationSuccessfulHandler implements StompFrameHandler {
	Gson gson = new Gson();

	private StompSession session;
	private String botId;
	private String botSecret;
	private Method tick;

	public IdentificationSuccessfulHandler(StompSession session, String botId, String botSecret, Method tick) {
		this.session = session;
		this.botId = botId;
		this.botSecret = botSecret;
		this.tick = tick;
	}

	@Override
	public Type getPayloadType(StompHeaders headers) {
		return String.class;
	}

	@Override
	public void handleFrame(StompHeaders headers, Object payload) {
		String id = (String) payload;
		IdentificationBot identificationBot = new IdentificationBot(botId, botSecret, id);
		session.send("identification-bot", gson.toJson(identificationBot));

		session.subscribe("identification-bot-successful", new IdentificationBotSuccessfulHandler(session, botId, id, tick));
	}

}
