package com.packtpublishing.tddjava.ch03tictactoe;


import pl.estrix.model.test.TestDto;

class TicTacToe {

    TestDto print(){
        TestDto dto = null;

        try {
            dto = TestDto
                    .builder()
                    .name("hello")
                    .build();
        } finally {
            System.out.print(dto.getName());
        }

        return dto;
    }
}
