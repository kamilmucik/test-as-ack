package com.packtpublishing.tddjava.ch03tictactoe;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Condition;
import org.junit.Before;
import org.junit.Test;


public class TicTacToeSpec {

    private TicTacToe ticTacToe;

    @Before
    public final void before(){
        ticTacToe = new TicTacToe();
    }

    @Test
    public void shouldReturnEnything(){
        System.out.print(ticTacToe.print());
//        Assert.fail();
    }

    @Test
    public void shouldReturnHelloMessage(){
        assertThat("hello").isEqualTo(ticTacToe.print() );

    }
}
