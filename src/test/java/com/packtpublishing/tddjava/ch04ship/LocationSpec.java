package com.packtpublishing.tddjava.ch04ship;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationSpec {

    private final int x = 12;
    private final int y = 32;
    private final Direction direction = Direction.NORTH;
    private Point max;
    private Location location;
    private List<Point> obstacles;

    @Before
    public void beforeTest() {
        max = new Point(50, 50);
        location = new Location(new Point(x, y), direction);
        obstacles = new ArrayList<>();
    }

    @Test
    public void whenInstantiatedThenXIsStored() {
        assertThat(location.getX()).isEqualTo(x);
    }

    @Test
    public void whenInstantiatedThenYIsStored() {
        assertThat(location.getY()).isEqualTo(y);
    }

    @Test
    public void whenInstantiatedThenDirectionIsStored() {
        assertThat(location.getDirection()).isEqualTo(direction);
    }

    @Test
    public void givenDirectionNWhenForwardThenYDecreases() {
        location.forward(max, obstacles);

        assertThat(location.getY()).isEqualTo(y - 1);
    }

    @Test
    public void givenDirectionSWhenForwardThenYIncreases() {
        location.setDirection(Direction.SOUTH);
        location.forward(max, obstacles);

        assertThat(location.getY()).isEqualTo(y + 1);
    }

    @Test
    public void givenDirectionEWhenForwardThenXIncreases() {
        location.setDirection(Direction.EAST);
        location.forward(max, obstacles);

        assertThat(location.getX()).isEqualTo(x + 1);
    }

    @Test
    public void givenDirectionWWhenForwardThenXDecreases() {
        location.setDirection(Direction.WEST);
        location.forward(max, obstacles);

        assertThat(location.getX()).isEqualTo(x - 1);
    }

    @Test
    public void givenDirectionNWhenBackwardThenYIncreases() {
        location.setDirection(Direction.NORTH);
        location.backward(max, obstacles);

        assertThat(location.getY()).isEqualTo(y + 1);
    }

    @Test
    public void givenDirectionNone() {
        location.setDirection(Direction.NONE);
        location.backward(max, obstacles);

        assertThat(location.getY()).isEqualTo(0);
    }

    @Test
    public void givenDirectionSWhenBackwardThenYDecreases() {
        location.setDirection(Direction.SOUTH);
        location.backward(max, obstacles);

        assertThat(location.getY()).isEqualTo(y - 1);
    }

    @Test
    public void givenDirectionEWhenBackwardThenXDecreases() {
        location.setDirection(Direction.EAST);
        location.backward(max, obstacles);

        assertThat(location.getX()).isEqualTo(x - 1);
    }

    @Test
    public void givenDirectionWWhenBackwardThenXIncreases() {
        location.setDirection(Direction.WEST);
        location.backward(max, obstacles);

        assertThat(location.getX()).isEqualTo(x + 1);
    }

    @Test
    public void whenTurnLeftThenDirectionIsSet() {
        location.turnLeft();

        assertThat(location.getDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    public void whenTurnRightThenDirectionIsSet() {
        location.turnRight();

        assertThat(location.getDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    public void givenSameObjectsWhenEqualsThenTrue() {
        assertThat(location.equals(location)).isTrue();
    }

    @Test
    public void givenCopyObjectsWhenEqualsThenTrue() {
        Location copiedLocation = location.copy();

        assertThat(location.equals(copiedLocation)).isTrue();
    }

    @Test
    public void givenDifferentObjectWhenEqualsThenFalse() {
        assertThat(location.equals(new Object())).isFalse();
    }

    @Test
    public void givenDifferentXWhenEqualsThenFalse() {
        Location locationCopy = new Location(new Point(999, location.getY()), location.getDirection());

        assertThat(location.equals(locationCopy)).isFalse();
    }

    @Test
    public void givenDifferentYWhenEqualsThenFalse() {
        Location locationCopy = new Location(new Point(location.getX(), 999), location.getDirection());

        assertThat(location.equals(locationCopy)).isFalse();
    }

    @Test
    public void givenDifferentDirectionWhenEqualsThenFalse() {
        Location locationCopy = new Location(location.getPoint(), Direction.SOUTH);

        assertThat(location.equals(locationCopy)).isFalse();
    }

    @Test
    public void givenSameXYDirectionWhenEqualsThenTrue() {
        Location locationCopy = new Location(location.getPoint(), location.getDirection());

        assertThat(location.equals(locationCopy)).isTrue();
    }

    @Test
    public void whenCopyThenDifferentObject() {
        Location copy = location.copy();

        assertThat(location).isNotSameAs(copy);
    }

    @Test
    public void whenCopyThenEquals() {
        Location copy = location.copy();

        assertThat(location).isEqualTo(copy);
    }

    @Test
    public void givenDirectionEAndXEqualsMaxXWhenForwardThen1() {
        location.setDirection(Direction.EAST);
        location.getPoint().setX(max.getX());
        location.forward(max, obstacles);

        assertThat(location.getX()).isEqualTo(1);
    }

    @Test
    public void givenDirectionWAndXEquals1WhenForwardThenMaxX() {
        location.setDirection(Direction.WEST);
        location.getPoint().setX(1);
        location.forward(max, obstacles);

        assertThat(location.getX()).isEqualTo(max.getX());
    }

    @Test
    public void givenDirectionNAndYEquals1WhenForwardThenMaxY() {
        location.setDirection(Direction.NORTH);
        location.getPoint().setY(1);
        location.forward(max, obstacles);

        assertThat(location.getY()).isEqualTo(max.getY());
    }

    @Test
    public void givenDirectionSAndYEqualsMaxYWhenForwardThen1() {
        location.setDirection(Direction.SOUTH);
        location.getPoint().setY(max.getY());
        location.forward(max, obstacles);

        assertThat(location.getY()).isEqualTo(1);
    }

    @Test
    public void givenObstacleWhenForwardThenReturnFalse() {
        location.setDirection(Direction.EAST);
        obstacles.add(new Point(x + 1, y));

        assertThat(location.forward(max, obstacles)).isFalse();
    }

    @Test
    public void givenObstacleWhenBackwardThenReturnFalse() {
        location.setDirection(Direction.EAST);
        obstacles.add(new Point(x - 1, y));

        assertThat(location.backward(max, obstacles)).isFalse();
    }

    @Test
    public void shouldCheckHashCode(){
        Location testLocation = new Location(new Point(0,0), Direction.NONE);

        assertThat(location.equals(testLocation)).isFalse();
        assertThat(location.hashCode()).isNotSameAs(testLocation.hashCode());
    }

    @Test
    public void shouldCheckEqualWithNull(){
        assertThat(location.equals(null)).isFalse();
    }

}
