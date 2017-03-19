package com.packtpublishing.tddjava.ch03tictactoe;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TicTacToeInteg {

	private static final Logger LOGGER = LoggerFactory.getLogger(TicTacToeInteg.class);

	@Test
	public void	whenInstantiatedThenMongoHasDbNameTicTacToe() throws UnknownHostException {
		MongoClientOptions.Builder o = MongoClientOptions.builder().connectTimeout(3000);
		MongoClient mongo = new MongoClient(new ServerAddress("127.0.0.1", 27017), o.build());

		try {
			mongo.getAddress();
		} catch (Exception e) {
			LOGGER.error("Mongo is down");
			fail("Mongo is down");
		} finally {
			mongo.close();
		}
	}

	@Test
	public void givenMongoDbIsRunningWhenPlayThenNoException() throws UnknownHostException {
		TicTacToe ticTacToe = new TicTacToe();

		assertEquals(TicTacToe.NO_WINNER, ticTacToe.play(1, 1));
	}
}
