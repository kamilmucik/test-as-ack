package com.packtpublishing.tddjava.ch04ship;

class Point {

    private int x;
    int getX() {
        return x;
    }
    void setX(int x) {
        this.x = x;
    }

    private int y;
    int getY() {
        return y;
    }
    void setY(int y) {
        this.y = y;
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
