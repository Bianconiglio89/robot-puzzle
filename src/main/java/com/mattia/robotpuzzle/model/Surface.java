package com.mattia.robotpuzzle.model;

public abstract class Surface {
    //TODO get from file properties
    protected final int northSouthDistance = 5;
    protected final int eastWestDistance = 5;

    public Surface(){

    }

    public boolean isPositionInsideSurface(int x, int y){

        if( x < 0 || y < 0 || y > northSouthDistance || x > eastWestDistance){
            return false;
        }
        return true;
    }

    public Direction getDirectionAtLeft(Direction startingDirection){
        assert startingDirection!= null;

        Direction finalDirection = null;
        switch (startingDirection){
            case NORTH: finalDirection = Direction.WEST;
                break;
            case SOUTH: finalDirection = Direction.EAST;
                break;
            case EAST: finalDirection = Direction.NORTH;
                break;
            case WEST: finalDirection = Direction.SOUTH;
                break;

        }
        assert finalDirection != null;
        return finalDirection;
    }

    public Direction getDirectionAtRight(Direction startingDirection){
        assert startingDirection!= null;

        Direction finalDirection = null;
        switch (startingDirection){
            case NORTH: finalDirection = Direction.EAST;
                break;
            case SOUTH: finalDirection = Direction.WEST;
                break;
            case EAST: finalDirection = Direction.SOUTH;
                break;
            case WEST: finalDirection = Direction.NORTH;
                break;

        }
        assert finalDirection != null;
        return finalDirection;
    }

    public Position nextLegalPosition(Position startingPosition, Direction direction){
        int finalCoordinateX,finalCoordinateY;
        finalCoordinateX = startingPosition.getX();
        finalCoordinateY = startingPosition.getY();

        switch (direction) {
            case EAST: finalCoordinateX++;
                break;
            case WEST: finalCoordinateX--;
                break;
            case NORTH: finalCoordinateY++;
                break;
            case SOUTH: finalCoordinateY--;
                break;
        }

        Position landingPosition = getLandingPosition(startingPosition, finalCoordinateX, finalCoordinateY);

        return  landingPosition;


    }

    public Position getLandingPosition(Position startingPosition, int finalCoordinateX, int finalCoordinateY){
        if(isPositionInsideSurface(finalCoordinateX,finalCoordinateY)){
           return new Position(finalCoordinateX,finalCoordinateY);
        }
        return startingPosition;

    }

    public int getNorthSouthDistance() {
        return northSouthDistance;
    }


    public int getEastWestDistance() {
        return eastWestDistance;
    }

    @Override
    public String toString() {
        return "Surface{" +
                "northSouthDistance=" + northSouthDistance +
                ", eastWestDistance=" + eastWestDistance +
                '}';
    }
}
