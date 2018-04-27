package com.mattia.robotpuzzle.service.entities;

public class RotationRS {
    private RotationDirectionRS rotateTo;

    public RotationRS() {
    }

    public RotationRS(RotationDirectionRS rotateTo) {
        this.rotateTo = rotateTo;
    }

    public RotationDirectionRS getRotateTo() {
        return rotateTo;
    }

    public void setRotateTo(RotationDirectionRS rotateTo) {
        this.rotateTo = rotateTo;
    }

    @Override
    public String toString() {
        return "RotationRS{" +
                "rotateTo=" + rotateTo +
                '}';
    }
}
