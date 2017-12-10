package eu.jstack.cwjava;

import eu.jstack.cwjava.handlers.MySessionHandler;
import eu.jstack.cwjava.models.State;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
public class CwJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CwJavaApplication.class, args);

		WebSocketClient webSocketClient = new StandardWebSocketClient();
		WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
		stompClient.setMessageConverter(new MappingJackson2MessageConverter());
		stompClient.setTaskScheduler(new ConcurrentTaskScheduler());

		Bot bot = new Bot();
		Method tick = null;

		try {
			tick = bot.getClass().getDeclaredMethod("tick", State.class);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		String url = "wss://localhost:8080/";
		StompSessionHandler sessionHandler = new MySessionHandler("local", "1", "1", tick);

		ListenableFuture<StompSession> connect = stompClient.connect(url, sessionHandler);
		connect.addCallback(new ListenableFutureCallback<StompSession>() {
			@Override
			public void onFailure(Throwable throwable) {
				throwable.printStackTrace();
			}

			@Override
			public void onSuccess(StompSession stompSession) {
				System.out.println("success");
			}
		});
	}
}
