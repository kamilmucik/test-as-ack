package com.packtpublishing.tddjava.ch04ship;

import java.util.List;

public class Location {

    private static final int FORWARD = 1;
    private static final int BACKWARD = -1;

    private Point point;

    private Direction direction;

    Location(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    Point getPoint() {
        return point;
    }

    Direction getDirection() {
        return this.direction;
    }

    void setDirection(Direction direction) {
        this.direction = direction;
    }

    int getX() {
        return point.getX();
    }

    int getY() {
        return point.getY();
    }

    boolean forward(Point max, List<Point> obstacles) {
        return move(FORWARD, max, obstacles);
    }

    boolean backward(Point max, List<Point> obstacles) {
        return move(BACKWARD, max, obstacles);
    }

    private boolean move(int fw, Point max, List<Point> obstacles) {
        int x = point.getX();
        int y = point.getY();
        switch(getDirection()) {
            case NORTH:
                y = wrap(getY() - fw, max.getY());
                break;
            case SOUTH:
                y = wrap(getY() + fw, max.getY());
                break;
            case EAST:
                x = wrap(getX() + fw, max.getX());
                break;
            case WEST:
                x = wrap(getX() - fw, max.getX());
                break;
            default:
                break;
        }
        if (isObstacle(new Point(x, y), obstacles)) {
            return false;
        } else {
            point = new Point(x, y);
            return true;
        }
    }

    private boolean isObstacle(Point point, List<Point> obstacles) {
        for (Point obstacle : obstacles) {
            if (obstacle.getX() == point.getX() && obstacle.getY() == point.getY()) {
                return true;
            }
        }
        return false;
    }

    private int wrap(int point, int maxPoint) {
        if (maxPoint > 0) {
            if (point > maxPoint) {
                return 1;
            } else if (point == 0) {
                return maxPoint;
            }
        }
        return point;
    }

    void turnLeft() {
        this.direction = direction.turnLeft();
    }

    void turnRight() {
        this.direction = direction.turnRight();
    }

    Location copy() {
        return new Location(new Point(point.getX(), point.getY()), direction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        Location location = (Location) o;
        return getX() == location.getX() && getY() == location.getY() && direction == location.direction;
    }
}
