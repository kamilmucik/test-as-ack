package com.packtpublishing.tddjava.ch03tictactoe;


import org.apache.log4j.Logger;
import pl.estrix.model.test.TestDto;

class TicTacToe {

    final static Logger logger = Logger.getLogger(TicTacToe.class);

    TestDto print(){
        TestDto dto = null;

        dto = TestDto
                .builder()
                .name("hello")
                .build();

        return dto;
    }
}
