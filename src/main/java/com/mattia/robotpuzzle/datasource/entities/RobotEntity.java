package com.mattia.robotpuzzle.datasource.entities;

import org.springframework.stereotype.Component;

@Component
public class RobotEntity {
    private PositionEntity position;
    private DirectionEntity direction;

    public RobotEntity() {
    }

    public RobotEntity(PositionEntity position, DirectionEntity direction) {
        this.position = position;
        this.direction = direction;
    }

    public PositionEntity getPosition() {
        return position;
    }

    public void setPosition(PositionEntity position) {
        this.position = position;
    }

    public DirectionEntity getDirection() {
        return direction;
    }

    public void setDirection(DirectionEntity direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "RobotEntity{" +
                "position=" + position +
                ", direction=" + direction +
                '}';
    }


}
