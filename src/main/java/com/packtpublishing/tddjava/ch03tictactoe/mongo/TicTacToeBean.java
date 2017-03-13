package com.packtpublishing.tddjava.ch03tictactoe.mongo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TicTacToeBean {

	private int turn;
	private int x;
	private int y;
	private char player;


}
