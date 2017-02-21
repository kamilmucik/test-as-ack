package com.packtpublishing.tddjava.ch04ship;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShipSpec {

	@Test
	public void whenInstantiatedThenLocationIsSet() {
		Location location = new Location(new Point(21, 13), Direction.NORTH);
		Ship ship = new Ship(location);
		
		assertThat(ship.getLocation()).isEqualTo(location);
	}
}
