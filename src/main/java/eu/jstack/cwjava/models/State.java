package eu.jstack.cwjava.models;

import java.util.Date;
import java.util.List;

public class State {
	private List<Bot> bots;
	private List<Bullet> bullets;
	private List<Powerup> powerups;
	private List<Pod> pods;
	private Long startedOn;
	private String mapId;
	private Date lastTick;
	private Long lastTickDuration;
	private boolean paused;
	private Map map;
}
