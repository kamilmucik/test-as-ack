package com.packtpublishing.tddjava.ch04ship;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
class Ship {

	private Location location;
	private Point max;
	private List<Point> obstacles;

	Ship(Location location) {
		this.location = location;
		this.max = new Point(50, 50);
		this.obstacles = new ArrayList<>();
	}

	boolean moveForward() {
		return this.location.forward(max, obstacles);
	}

	boolean moveBackward() {
		return this.location.backward(max, obstacles);
	}
}
