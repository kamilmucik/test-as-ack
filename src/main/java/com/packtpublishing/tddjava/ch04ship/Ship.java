package com.packtpublishing.tddjava.ch04ship;

import lombok.Getter;

@Getter
class Ship {

	private Location location;

	Ship(Location location) {
		this.location = location;
	}

}
