package eu.jstack.cwjava.handlers;

import com.google.gson.Gson;
import eu.jstack.cwjava.models.State;
import org.springframework.messaging.simp.stomp.*;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class MySessionHandler extends StompSessionHandlerAdapter {
	Gson gson = new Gson();

	private String environment;
	private String botId;
	private String botSecret;

	private Method tick;

	public MySessionHandler(String environment, String botId, String botSecret, Method tick) {
		this.environment = environment;
		this.botId = botId;
		this.botSecret = botSecret;
		this.tick = tick;
	}

	@Override
	public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
		session.send("identification", "VALID");
		session.subscribe("identification-successful", new IdentificationSuccessfulHandler(session, botId, botSecret, tick));
	}

	@Override
	public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
		exception.printStackTrace();
	}

	@Override
	public Type getPayloadType(StompHeaders headers) {
		return State.class;
	}

	@Override
	public void handleFrame(StompHeaders headers, Object payload) {
		System.out.println("test");
	}
}
