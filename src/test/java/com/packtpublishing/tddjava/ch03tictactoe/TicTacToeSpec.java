package com.packtpublishing.tddjava.ch03tictactoe;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.estrix.exception.OwnRuntimeException;

public class TicTacToeSpec {

    private TicTacToe ticTacToe;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public final void before(){
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXOutsideBoardThenRuntimeException() throws Throwable  {
        exception.expect(OwnRuntimeException.class);
        ticTacToe.play(5,2);
    }
    @Test
    public void whenXNegativeOutsideBoardThenRuntimeException() throws Throwable  {
        exception.expect(OwnRuntimeException.class);
        ticTacToe.play(-5,2);
    }

    @Test
    public void whenYOutsideBoardThenRuntimeException() throws Throwable {
        exception.expect(OwnRuntimeException.class);
        ticTacToe.play(2,5);
    }

    @Test
    public void whenYNegativeOutsideBoardThenRuntimeException() throws Throwable  {
        exception.expect(OwnRuntimeException.class);
        ticTacToe.play(2,-5);
    }

    @Test
    public void whenOccupiedThenRuntimeException() throws Throwable  {
        ticTacToe.play(2,1);
        exception.expect(OwnRuntimeException.class);
        ticTacToe.play(2,1);
    }

    @Test
    public void givenFirstTurnWhenPlayerThenX() {
        assertThat(ticTacToe.nextPlayer()).isEqualTo('X');
    }

    @Test
    public void givenLastTurnWhenNextPlayerThenO() throws Throwable {
        ticTacToe.play(1,1);
        assertThat(ticTacToe.nextPlayer()).isEqualTo('O');
    }

    @Test
    public void whenPlayThenNoWinner() throws Throwable {
        String actual = ticTacToe.play(1,1);
        assertThat(actual).isEqualTo("Brak zwyciezcy");
    }

    @Test
    public void whenPlayAndWholeHorizontalLineThenWinner() throws Throwable {
        ticTacToe.play(1,1);// X
        ticTacToe.play(1,2);// O
        ticTacToe.play(2,1);// X
        ticTacToe.play(2,2);// O
        String actual = ticTacToe.play(3,1);// X
        assertThat(actual).isEqualTo("Wygral X");
    }

    @Test
    public void whenPlayAndWholeVerticalLineThenWinner() throws Throwable {
        ticTacToe.play(2,1);// X
        ticTacToe.play(1,1);// O
        ticTacToe.play(3,1);// X
        ticTacToe.play(1,2);// O
        ticTacToe.play(2,2);// X
        String actual = ticTacToe.play(1,3);// Y
        assertThat(actual).isEqualTo("Wygral O");
    }

    @Test
    public void whenPlayAndTopBottomDiagonalLineThenWinner() throws Throwable {
        ticTacToe.play(1,1);// X
        ticTacToe.play(1,2);// O
        ticTacToe.play(2,2);// X
        ticTacToe.play(1,3);// O
        String actual = ticTacToe.play(3,3);// X
        assertThat(actual).isEqualTo("Wygral X");
    }
}
