package com.packtpublishing.tddjava.ch04ship;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShipSpec {

	private Point max;
	private List<Point> obstacles;
	private Location location;
	private Ship ship;

	@Before
	public void beforeTest() {
		location = new Location(new Point(21, 13), Direction.NORTH);
		ship = new Ship(location);
		max = new Point(50, 50);
		obstacles = new ArrayList<>();
	}

	@Test
	public void whenInstantiatedThenLocationIsSet() {
		assertThat(ship.getLocation()).isEqualTo(location);
	}

	@Test
	public void givenNorthWhenMoveForwardThenYDecreases() {
		Location expected = location.copy();
		expected.forward(max, obstacles);
		ship.moveForward();

		assertThat(ship.getLocation()).isEqualTo(expected);
	}

	@Test
	public void whenMoveBackwardThenBackward() {
		Location expected = location.copy();
		expected.backward(max, obstacles);
		ship.moveBackward();

		assertThat(ship.getLocation()).isEqualTo(expected);
	}

	@Test
	public void givenEastWhenMoveForwardThenXIncreases() {
		ship.getLocation().setDirection(Direction.EAST);
		ship.moveForward();

		assertThat(ship.getLocation().getPoint().getX()).isEqualTo(22);
	}
}
