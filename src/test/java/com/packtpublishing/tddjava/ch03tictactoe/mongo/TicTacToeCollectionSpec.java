package com.packtpublishing.tddjava.ch03tictactoe.mongo;

import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;

public class TicTacToeCollectionSpec {

	private TicTacToeCollection collection;

	@Before
	public void before() throws UnknownHostException {
		collection = spy(new TicTacToeCollection());
	}

	@Test
	public void
	whenInstantiatedThenMongoHasDbNameTicTacToe(){
		assertEquals("tic-tac-toe",collection.getMongoCollection().getDBCollection().getDB().getName());
	}

	@Test
	public void
	whenInstantiatedThenMongoCollectionHasNameGame(){
		assertEquals("game",collection.getMongoCollection().getName());
	}
}
