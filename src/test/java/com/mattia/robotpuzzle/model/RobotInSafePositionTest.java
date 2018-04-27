package com.mattia.robotpuzzle.model;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RobotInSafePositionTest {
    Robot robotSafePosition;
    Rotation rotationLeft, rotationRight;

    @Before
    public void init() {
        robotSafePosition = new Robot();
        robotSafePosition.setPosition(new Position(1, 1));
        rotationLeft = new Rotation(RotationDirection.LEFT);
        rotationRight = new Rotation(RotationDirection.RIGHT);
    }

    @Test
    public void rotateLeftTest() {
        robotSafePosition.setDirection(Direction.NORTH);
        robotSafePosition.rotate(rotationLeft);
        assertEquals(Direction.WEST, robotSafePosition.getDirection());
        robotSafePosition.rotate(rotationLeft);
        assertEquals(Direction.SOUTH, robotSafePosition.getDirection());
        robotSafePosition.rotate(rotationLeft);
        assertEquals(Direction.EAST, robotSafePosition.getDirection());
        robotSafePosition.rotate(rotationLeft);
        assertEquals(Direction.NORTH, robotSafePosition.getDirection());
    }

    @Test
    public void rotateRightTest() {
        robotSafePosition.setDirection(Direction.NORTH);
        robotSafePosition.rotate(rotationRight);
        assertEquals(Direction.EAST, robotSafePosition.getDirection());
        robotSafePosition.rotate(rotationRight);
        assertEquals(Direction.SOUTH, robotSafePosition.getDirection());
        robotSafePosition.rotate(rotationRight);
        assertEquals(Direction.WEST, robotSafePosition.getDirection());
        robotSafePosition.rotate(rotationRight);
        assertEquals(Direction.NORTH, robotSafePosition.getDirection());
    }

    @Test
    public void moveFrontNorthDirection() {
        robotSafePosition.setDirection(Direction.NORTH);
        robotSafePosition.moveFront();
        assertEquals(new Position(1, 2), robotSafePosition.getPosition());
    }

    @Test
    public void moveFrontEastDirection() {
        robotSafePosition.setDirection(Direction.EAST);
        robotSafePosition.moveFront();
        assertEquals(new Position(2, 1), robotSafePosition.getPosition());
    }

    @Test
    public void moveFrontWestDirection() {
        robotSafePosition.setDirection(Direction.WEST);
        robotSafePosition.moveFront();
        assertEquals(new Position(0, 1), robotSafePosition.getPosition());
    }

    @Test
    public void moveFrontSouthDirection() {
        robotSafePosition.setDirection(Direction.SOUTH);
        robotSafePosition.moveFront();
        assertEquals(new Position(1, 0), robotSafePosition.getPosition());
    }
}
