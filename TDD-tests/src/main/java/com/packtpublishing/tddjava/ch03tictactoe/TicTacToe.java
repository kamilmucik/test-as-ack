package com.packtpublishing.tddjava.ch03tictactoe;

import pl.estrix.model.test.TestDto;

class TicTacToe {

    TestDto print(){
        return TestDto
                .builder()
                .name("hello")
                .build();
    }
}
