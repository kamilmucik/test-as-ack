package com.packtpublishing.tddjava.ch04ship;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

class Planet {

    @Getter
    private final Point max;

    @Getter
    @Setter
    private List<Point> obstacles;

    Planet(Point max) {
        this.max = max;
        this.obstacles = new ArrayList<>();
    }

    Planet(Point max, List<Point> obstacles) {
        this.max = max;
        this.obstacles = obstacles;
    }

}
