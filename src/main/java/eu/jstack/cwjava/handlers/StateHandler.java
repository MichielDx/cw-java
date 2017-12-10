package eu.jstack.cwjava.handlers;

import com.google.gson.Gson;
import eu.jstack.cwjava.Bot;
import eu.jstack.cwjava.models.BotControlUpdate;
import eu.jstack.cwjava.models.Controls;
import eu.jstack.cwjava.models.State;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class StateHandler implements StompFrameHandler {
	private Gson gson = new Gson();

	private StompSession session;
	private String id;
	private String botId;
	private Method tick;

	public StateHandler(StompSession session, String id, String botId, Method tick) {
		this.session = session;
		this.id = id;
		this.botId = botId;
		this.tick = tick;
	}

	@Override
	public Type getPayloadType(StompHeaders headers) {
		return null;
	}

	@Override
	public void handleFrame(StompHeaders headers, Object payload) {
		String json = (String) payload;
		State state = gson.fromJson(json, State.class);

		if (tick != null) {
			Bot bot = null;
			Controls controls = null;
			try {
				bot = Bot.class.newInstance();
				controls = (Controls) tick.invoke(bot, state);
			} catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
				e.printStackTrace();
			}
			BotControlUpdate botControlUpdate = new BotControlUpdate(id, botId, controls);
			session.send("bot-control-update", gson.toJson(botControlUpdate));
		}
	}
}
