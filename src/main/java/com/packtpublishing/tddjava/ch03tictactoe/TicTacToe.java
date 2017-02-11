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
        if (isWin(x, y)) {
            return "Wygral " + lastPlayer;
        } else if (isDraw()){
            return "Wynik remisowy";
        }else return "Brak zwyciezcy";
    }

    private boolean isDraw() {
        for (int x=0; x < SIZE; x++){
            for (int y=0; y < SIZE; y++){
                if (board[x][y] == '\0'){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isWin(int x, int y) {
        int playerTotal = lastPlayer * 3;
        char horizontal, vertical, diagonal1, diagonal2;
        horizontal= vertical= diagonal1= diagonal2 = '\0';
        for (int i = 0; i< SIZE; i++) {
            horizontal += board[i][y - 1];
            vertical += board[x - 1][i];
            diagonal1 += board[i][i];
            diagonal2 += board[i][SIZE - i - 1];
        }
        return diagonal1 == playerTotal || diagonal2 == playerTotal || horizontal == playerTotal || vertical == playerTotal;
    }

    private void checkAxis(int axis) throws Exception {
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
