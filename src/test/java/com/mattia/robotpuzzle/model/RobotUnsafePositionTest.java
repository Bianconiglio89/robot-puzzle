package com.mattia.robotpuzzle.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RobotUnsafePositionTest {
	Robot robotUnsafePosition;
	int northFrontierY, westFrontierX;

	@Before
	public void init(){
		robotUnsafePosition = new Robot();
		westFrontierX = robotUnsafePosition.getSurfaceLocation().getEastWestDistance();
		northFrontierY = robotUnsafePosition.getSurfaceLocation().getNorthSouthDistance();
	}

	@Test
	public void testNotFallingNorthFrontier(){
		Position northFrontierPosition = new Position(0,northFrontierY);
		robotUnsafePosition.setPosition(northFrontierPosition);
		robotUnsafePosition.setDirection(Direction.NORTH);
		robotUnsafePosition.moveFront();
		assertEquals(northFrontierPosition,robotUnsafePosition.getPosition());
	}

	@Test
	public void testNotFallingSoutFrontier(){
		Position southFrontierPosition = new Position(0,0);
		robotUnsafePosition.setPosition(southFrontierPosition);
		robotUnsafePosition.setDirection(Direction.SOUTH);
		robotUnsafePosition.moveFront();
		assertEquals(southFrontierPosition,robotUnsafePosition.getPosition());
	}

	@Test
	public void testNotFallingEastFrontier(){
		Position eastFrontierPosition = new Position(westFrontierX,0);
		robotUnsafePosition.setPosition(eastFrontierPosition);
		robotUnsafePosition.setDirection(Direction.EAST);
		robotUnsafePosition.moveFront();
		assertEquals(eastFrontierPosition,robotUnsafePosition.getPosition());
	}

	@Test
	public void testNotFallingWestFrontier(){
		Position westFrontierPosition = new Position(0,0);
		robotUnsafePosition.setPosition(westFrontierPosition);
		robotUnsafePosition.setDirection(Direction.WEST);
		robotUnsafePosition.moveFront();
		assertEquals(westFrontierPosition,robotUnsafePosition.getPosition());
	}
}
