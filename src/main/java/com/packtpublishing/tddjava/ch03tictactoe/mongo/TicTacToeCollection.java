package com.packtpublishing.tddjava.ch03tictactoe.mongo;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import lombok.Getter;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;

class TicTacToeCollection {

	private static final Logger LOGGER = LoggerFactory.getLogger(TicTacToeCollection.class);

	@Getter
	private MongoCollection mongoCollection;

	TicTacToeCollection() throws UnknownHostException {
		DB db = new MongoClient().getDB("tic-tac-toe");
		mongoCollection = new Jongo(db).getCollection("game");
	}

	boolean saveMove(TicTacToeBean bean) {
		try {
			getMongoCollection().save(bean);
			return true;
		} catch (Exception e) {
			LOGGER.warn("saveMove",e);
		}
		return false;
	}

	boolean drop() {
		try {
			getMongoCollection().drop();
			return true;
		} catch (Exception e){
			LOGGER.warn("drop",e);
		}
		return false;
	}
}
