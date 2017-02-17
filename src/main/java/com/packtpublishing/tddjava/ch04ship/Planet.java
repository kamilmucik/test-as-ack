package com.packtpublishing.tddjava.ch04ship;

import java.util.List;

class Planet {

    private final Point max;
    Point getMax() {
        return max;
    }

    private List<Point> obstacles;
    List<Point> getObstacles() {
        return obstacles;
    }
//    public void setObstacles(List<Point> obstacles) {
//        this.obstacles = obstacles;
//    }

//    public Planet(Point max) {
//        this.max = max;
//    }
    Planet(Point max, List<Point> obstacles) {
        this.max = max;
        this.obstacles = obstacles;
    }

}
