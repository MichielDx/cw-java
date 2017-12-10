package eu.jstack.cwjava;

import eu.jstack.cwjava.models.Controls;
import eu.jstack.cwjava.models.Direction;
import eu.jstack.cwjava.models.State;

import java.util.Date;
import java.util.Random;

public class Bot {
	private Random random = new Random();

	private Date lastUpdate = new Date();
	private long changeDuration = 1000L;

	public Controls tick(State state) {
		Direction direction = new Direction(false, false, false, false);
		Controls controls = new Controls(direction, true, true);

		if ((lastUpdate.getTime() + changeDuration) <= new Date().getTime()) {
			int scenario = random.nextInt() * 4;

			switch (scenario) {
				case 0:
					direction.updateUp(true);
					break;
				case 1:
					direction.updateDown(true);
					break;
				case 2:
					direction.updateLeft(true);
					break;
				case 3:
					direction.updateRight(true);
					break;
			}

			controls.updateDirection(direction);
			lastUpdate = new Date();


		}
		return controls;
	}
}
