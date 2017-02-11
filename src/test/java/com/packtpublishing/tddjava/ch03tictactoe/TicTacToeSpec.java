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
    public void whenXOutsideBoardThenRuntimeException() {
        exception.expect(OwnRuntimeException.class);
        ticTacToe.play(5,2);
    }
    @Test
    public void whenXNegativeOutsideBoardThenRuntimeException() {
        exception.expect(OwnRuntimeException.class);
        ticTacToe.play(-5,2);
    }

    @Test
    public void whenYOutsideBoardThenRuntimeException() {
        exception.expect(OwnRuntimeException.class);
        ticTacToe.play(2,5);
    }

    @Test
    public void whenYNegativeOutsideBoardThenRuntimeException() {
        exception.expect(OwnRuntimeException.class);
        ticTacToe.play(2,-5);
    }

    @Test
    public void whenOccupiedThenRuntimeException() {
        ticTacToe.play(2,1);
        exception.expect(OwnRuntimeException.class);
        ticTacToe.play(2,1);
    }

    @Test
    public void givenFirstTurnWhenPlayerThenX() {
        assertThat(ticTacToe.nextPlayer()).isEqualTo('X');
    }

    @Test
    public void givenLastTurnWhenNextPlayerThenO() {
        ticTacToe.play(1,1);
        assertThat(ticTacToe.nextPlayer()).isEqualTo('O');
    }

    @Test
    public void whenPlayThenNoWinner() {
        String actual = ticTacToe.play(1,1);
        assertThat(actual).isEqualTo("Brak zwyciezcy");
    }

    @Test
    public void whenPlayAndWholeHorizontalLineThenWinner() {
        ticTacToe.play(1,1);// X
        ticTacToe.play(1,2);// O
        ticTacToe.play(2,1);// X
        ticTacToe.play(2,2);// O
        String actual = ticTacToe.play(3,1);// X
        assertThat(actual).isEqualTo("Wygral X");
    }

    @Test
    public void whenPlayAndWholeVerticalLineThenWinner()  {
        ticTacToe.play(2, 1);// X
        ticTacToe.play(1, 1);// O
        ticTacToe.play(3, 1);// X
        ticTacToe.play(1, 2);// O
        ticTacToe.play(2, 2);// X
        String actual = ticTacToe.play(1, 3);// Y
        assertThat(actual).isEqualTo("Wygral O");
    }

    @Test
    public void whenPlayAndTopBottomDiagonalLineThenWinner() {
        ticTacToe.play(1,1);// X
        ticTacToe.play(1,2);// O
        ticTacToe.play(2,2);// X
        ticTacToe.play(1,3);// O
        String actual = ticTacToe.play(3,3);// X
        assertThat(actual).isEqualTo("Wygral X");
    }

    @Test
    public void whenAllBoxesAreFilledThenDraw() {
        ticTacToe.play(1,1);
        ticTacToe.play(1,2);
        ticTacToe.play(1,3);
        ticTacToe.play(2,1);
        ticTacToe.play(2,3);
        ticTacToe.play(2,2);
        ticTacToe.play(3,1);
        ticTacToe.play(3,3);
        String actual = ticTacToe.play(3,2);
        assertThat(actual).isEqualTo("Wynik remisowy");
    }
}
