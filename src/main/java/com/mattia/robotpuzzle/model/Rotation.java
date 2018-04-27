package com.mattia.robotpuzzle.model;

public class Rotation {
    RotationDirection rotateTo;

    public Rotation() {
    }

    public Rotation(RotationDirection rotateTo) {
        this.rotateTo = rotateTo;
    }

    public RotationDirection getRotateTo() {
        return rotateTo;
    }

    public void setRotateTo(RotationDirection rotateTo) {
        this.rotateTo = rotateTo;
    }

    @Override
    public String toString() {
        return "Rotation{" +
                "rotateTo=" + rotateTo +
                '}';
    }
}
