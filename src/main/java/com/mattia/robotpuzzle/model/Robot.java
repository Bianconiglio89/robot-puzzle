package com.mattia.robotpuzzle.model;

public class Robot {
    private Surface surfaceLocation;
    private Position position;
    private Direction direction;

    public Robot() {
        surfaceLocation = new TableTop();
    }

    public Robot(Position position, Direction direction) {
        surfaceLocation = new TableTop();
        this.position = position;
        this.direction = direction;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Surface getSurfaceLocation() {
        return surfaceLocation;
    }

    public void rotate(Rotation rotation) {
        RotationDirection rotateTo = rotation.getRotateTo();
        switch (rotateTo) {
            case LEFT:
                rotateLeft();
                break;
            case RIGHT:
                rotateRight();
                break;
        }


    }

    private void rotateLeft() {
        Direction directionAtLeft = surfaceLocation.getDirectionAtLeft(this.direction);
        this.direction = directionAtLeft;
    }

    private void rotateRight() {
        Direction directionAtRight = surfaceLocation.getDirectionAtRight(this.direction);
        this.direction = directionAtRight;
    }

    public void moveFront() {
        Position nextPosition = surfaceLocation.nextLegalPosition(this.position, this.direction);
        this.position = nextPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Robot robot = (Robot) o;

        if (position != null ? !position.equals(robot.position) : robot.position != null) return false;
        return direction == robot.direction;
    }

    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "surfaceLocation=" + surfaceLocation +
                ", position=" + position +
                ", direction=" + direction +
                '}';
    }
}
