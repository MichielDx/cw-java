package eu.jstack.cwjava.handlers;

import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class IdentificationBotSuccessfulHandler implements StompFrameHandler {
	private StompSession session;
	private String botId;
	private String id;
	private Method tick;

	public IdentificationBotSuccessfulHandler(StompSession session, String botId, String id, Method tick) {
		this.session = session;
		this.botId = botId;
		this.id = id;
		this.tick = tick;
	}

	@Override
	public Type getPayloadType(StompHeaders headers) {
		return Object.class;
	}

	@Override
	public void handleFrame(StompHeaders headers, Object payload) {
		session.subscribe("state", new StateHandler(session, id, botId, tick));
	}
}
