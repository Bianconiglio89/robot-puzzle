package com.mattia.robotpuzzle.model;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class SurfaceTest {
    private Surface surface;
    private Position insidePosition, insidePosition2, outsidePosition, outsidePosition2, outsidePosition3, outsidePosition4;

    @Before
    public void init() {
        surface = new TableTop();
        int eastWestDistance = surface.getEastWestDistance();
        int northSouthDistance = surface.getNorthSouthDistance();
        insidePosition = new Position(0, 0);
        insidePosition2 = new Position(eastWestDistance, northSouthDistance);
        outsidePosition = new Position(eastWestDistance + 1, northSouthDistance);
        outsidePosition2 = new Position(eastWestDistance, northSouthDistance + 1);
        outsidePosition3 = new Position(-1, 0);
        outsidePosition4 = new Position(0, -1);

    }

    @Test
    public void isPositionInsideSurfaceTest() {
        assertTrue(surface.isPositionInsideSurface(insidePosition.getX(), insidePosition.getY()));
    }

    @Test
    public void isPosition2InsideSurfaceTest() {
        assertTrue(surface.isPositionInsideSurface(insidePosition2.getX(), insidePosition2.getY()));
    }

    @Test
    public void isPositionOutsideSurfaceTest() {
        assertFalse(surface.isPositionInsideSurface(outsidePosition.getX(), outsidePosition.getY()));
    }

    @Test
    public void isPosition2OutsideSurfaceTest() {
        assertFalse(surface.isPositionInsideSurface(outsidePosition2.getX(), outsidePosition2.getY()));
    }

    @Test
    public void isPosition3OutsideSurfaceTest() {
        assertFalse(surface.isPositionInsideSurface(outsidePosition3.getX(), outsidePosition3.getY()));
    }

    @Test
    public void isPosition4OutsideSurfaceTest() {
        assertFalse(surface.isPositionInsideSurface(outsidePosition4.getX(), outsidePosition4.getY()));
    }
}
