package com.packtpublishing.tddjava.ch03tictactoe;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import pl.estrix.model.test.TestDto;


public class TicTacToeSpec {

    private TicTacToe ticTacToe;
    private TestDto testObject;

    @Before
    public final void before(){
        ticTacToe = new TicTacToe();
    }

    @Test
    public void shouldReturnEnything(){
        testObject = ticTacToe.print();
        System.out.print(testObject.getName());
    }

    @Test
    public void shouldReturnHelloMessage(){
        testObject = ticTacToe.print();

        assertThat("hello").isEqualTo(testObject.getName() );
    }
}
