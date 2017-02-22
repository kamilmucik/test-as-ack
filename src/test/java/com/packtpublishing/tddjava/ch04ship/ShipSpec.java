package com.packtpublishing.tddjava.ch04ship;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShipSpec {

	private Point max;
	private Location location;
	private Ship ship;
	private Planet planet;

	@Before
	public void beforeTest() {
		location = new Location(new Point(21, 13), Direction.NORTH);
		max = new Point(50, 50);
		planet = new Planet(max);
		ship = new Ship(location, planet);
	}

	@Test
	public void whenInstantiatedThenLocationIsSet() {
		assertThat(ship.getLocation()).isEqualTo(location);
	}

	@Test
	public void givenNorthWhenMoveForwardThenYDecreases() {
		Location expected = location.copy();
		expected.forward(max, planet.getObstacles());
		ship.moveForward();

		assertThat(ship.getLocation()).isEqualTo(expected);
	}

	@Test
	public void whenMoveBackwardThenBackward() {
		Location expected = location.copy();
		expected.backward(planet.getMax(), planet.getObstacles());
		ship.moveBackward();

		assertThat(ship.getLocation()).isEqualTo(expected);
	}

	@Test
	public void givenEastWhenMoveForwardThenXIncreases() {
		ship.getLocation().setDirection(Direction.EAST);
		ship.moveForward();

		assertThat(ship.getLocation().getPoint().getX()).isEqualTo(22);
	}

	@Test
	public void whenReceiveCommandsFThenForward() {
		Location expected = location.copy();
		expected.forward(planet.getMax(), planet.getObstacles());
		ship.receiveCommands("f");

		assertThat(ship.getLocation()).isEqualTo(expected);
	}

	@Test
	public void whenReceiveCommandsThenAllAreExecuted() {
		Location expected = location.copy();
		expected.turnRight();
		expected.forward(planet.getMax(), planet.getObstacles());
		expected.turnLeft();
		expected.backward(planet.getMax(), planet.getObstacles());
		ship.receiveCommands("rflbx");

		assertThat(ship.getLocation()).isEqualTo(expected);
	}

	@Test
	public void whenInstantiatedThenPlanetIsStored() {
		assertThat(ship.getPlanet()).isEqualTo(planet);
	}
}
