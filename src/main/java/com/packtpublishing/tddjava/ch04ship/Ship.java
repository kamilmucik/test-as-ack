package com.packtpublishing.tddjava.ch04ship;

import lombok.Getter;

import java.util.List;


class Ship {

	@Getter
	private Location location;
	@Getter
	private Planet planet;
	private Point max;
	private List<Point> obstacles;

	Ship(Location location, Planet planet) {
		this.location = location;
		this.planet = planet;
		this.max = planet.getMax();
		this.obstacles = planet.getObstacles();
	}

	boolean moveForward() {
		return this.location.forward(max, obstacles);
	}

	boolean moveBackward() {
		return this.location.backward(max, obstacles);
	}

	private void turnRight() {
		this.location.turnRight();
	}

	private void turnLeft() {
		this.location.turnLeft();
	}

	void receiveCommands(String commands) {
		for (char command : commands.toCharArray()) {
			switch(command) {
			case 'f':
				moveForward();
				break;
			case 'b':
				moveBackward();
				break;
			case 'l':
				turnLeft();
				break;
			case 'r':
				turnRight();
				break;
			default:
				break;
			}
		}
	}
}
