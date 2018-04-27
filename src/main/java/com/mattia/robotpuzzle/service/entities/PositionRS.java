package com.mattia.robotpuzzle.service.entities;

public class PositionRS {
    private int x;
    private int y;


    public PositionRS() {
    }

    public PositionRS(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "PositionRS{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
