package com.packtpublishing.tddjava.ch03tictactoe.mongo;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import lombok.Getter;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;

public class TicTacToeCollection {

	private static final Logger LOG = LoggerFactory.getLogger(TicTacToeCollection.class);

	public TicTacToeCollection() throws UnknownHostException {
		DB db = new MongoClient().getDB("tic-tac-toe");
		mongoCollection = new Jongo(db).getCollection("game");
	}

	@Getter
	private MongoCollection mongoCollection;

	public boolean saveMove(TicTacToeBean bean) {
		try {
			getMongoCollection().save(bean);
			return true;
		} catch (Exception e) {
			LOG.warn(e.getMessage());
			return false;
		}
	}

	public boolean drop() {
		try {
			getMongoCollection().drop();
			return true;
		} catch (Exception e){
			LOG.warn(e.getMessage());
			return false;
		}
	}
}
