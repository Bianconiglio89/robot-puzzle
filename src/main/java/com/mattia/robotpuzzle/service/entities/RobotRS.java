package com.mattia.robotpuzzle.service.entities;

import javax.validation.constraints.NotNull;

public class RobotRS {
    @NotNull
    PositionRS position;
    @NotNull
    DirectionRS direction;

    public RobotRS() {
    }

    public RobotRS(PositionRS position, DirectionRS direction) {
        this.position = position;
        this.direction = direction;
    }

    public DirectionRS getDirection() {
        return direction;
    }

    public void setDirection(DirectionRS direction) {
        this.direction = direction;
    }

    public PositionRS getPosition() {
        return position;
    }

    public void setPosition(PositionRS position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "RobotRS{" +
                "direction=" + direction +
                ", position=" + position +
                '}';
    }
}
