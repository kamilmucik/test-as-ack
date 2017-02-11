package com.packtpublishing.tddjava.ch03tictactoe;

import pl.estrix.exception.OwnRuntimeException;

class TicTacToe {

    private Character[][] board = {{'\0','\0','\0'},{'\0','\0','\0'},{'\0','\0','\0'}};

    private char lastPlayer = '\0';

    private static final int SIZE = 3;

    String play(int x, int y)throws Throwable  {
        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(x, y, lastPlayer);
        if (isWin()) {
            return "Wygral " + lastPlayer;
        }
        return "Brak zwyciezcy";
    }

    private boolean isWin() {
        int playerTotal = lastPlayer * SIZE;
        char diagonal1 = '\0';
        char diagonal2 = '\0';
        for (int i = 0; i< SIZE; i++) {
            diagonal1 += board[i][i];
            diagonal2 += board[i][SIZE - i - 1];
            if (board[0][i] + board[1][i] + board[2][i] == playerTotal){
                return true;
            } else if (board[i][0] + board[i][1] + board[i][2] == playerTotal ) {
                return true;
            }
        }

        return diagonal1 == playerTotal || diagonal2 == playerTotal;

    }

    private void checkAxis(int axis) throws Throwable {
        if (axis < 1 || axis > 3) {
            throw new OwnRuntimeException("Wartosc X wykracza poza plansze");
        }
    }

    private void setBox (int x, int y, char lastPlayer) {
        if (board[x-1][y-1] != '\0') {
            throw new OwnRuntimeException("Pole jest juz zajete");
        } else {
            board[x-1][y-1] = lastPlayer;
        }
    }

    char nextPlayer() {
        if (lastPlayer == 'X') {
            return 'O';
        }
        return 'X';
    }
}
