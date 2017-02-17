package com.packtpublishing.tddjava.ch04ship;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class DirectionSpec {

    @Test
    public void whenGetFromShortNameNThenReturnDirectionN() {
        Direction direction = Direction.getFromShortName('N');

        assertThat(Direction.NORTH).isEqualTo(direction);
    }

    @Test
    public void whenGetFromShortNameWThenReturnDirectionW() {
        Direction direction = Direction.getFromShortName('W');

        assertThat(Direction.WEST).isEqualTo(direction);
    }

    @Test
    public void whenGetFromShortNameBThenReturnNone() {
        Direction direction = Direction.getFromShortName('B');

        assertThat(Direction.NONE).isEqualTo(direction);
    }

    @Test
    public void givenSWhenLeftThenE() {
        assertThat(Direction.SOUTH.turnLeft()).isEqualTo(Direction.EAST);
    }

    @Test
    public void givenNWhenLeftThenW() {
        assertThat(Direction.NORTH.turnLeft()).isEqualTo(Direction.WEST);
    }

    @Test
    public void givenSWhenRightThenW() {
        assertThat(Direction.SOUTH.turnRight()).isEqualTo(Direction.WEST);
    }

    @Test
    public void givenWWhenRightThenN() {
        assertThat(Direction.WEST.turnRight()).isEqualTo(Direction.NORTH);
    }

}
