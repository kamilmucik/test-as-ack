package com.packtpublishing.tddjava.ch03tictactoe.mongo;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import lombok.Getter;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import java.net.UnknownHostException;

public class TicTacToeCollection {

	public TicTacToeCollection() throws UnknownHostException {
		DB db = new MongoClient().getDB("tic-tac-toe");
		mongoCollection = new Jongo(db).getCollection("game");
	}

	@Getter
	private MongoCollection mongoCollection;
}
