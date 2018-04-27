package com.mattia.robotpuzzle.usecases;

import com.mattia.robotpuzzle.datasource.repositoryInterface.RepositoryInterface;
import com.mattia.robotpuzzle.model.Position;
import com.mattia.robotpuzzle.model.Robot;
import com.mattia.robotpuzzle.model.Rotation;
import com.mattia.robotpuzzle.model.Surface;
import com.mattia.robotpuzzle.service.exceptions.InvalidPositionException;
import com.mattia.robotpuzzle.service.exceptions.RobotAlreadyPlacedException;
import com.mattia.robotpuzzle.service.exceptions.RobotMissingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("robotManager")
public class RobotManager implements RobotManagerFacade {
    @Autowired
    private RepositoryInterface<Robot> robotRepository;

    @Override
    public Robot move() {
        Robot robot= robotRepository.find();
        robot.moveFront();
        Robot movedRobot = robotRepository.update(robot);
        return movedRobot;
    }

    public Robot rotate(Rotation rotation){
        Robot robot = robotRepository.find();
        robot.rotate(rotation);
        Robot updatedRobot = robotRepository.update(robot);
        return updatedRobot;
    }

    @Override
    public Robot report() {
        Robot robot = robotRepository.find();
        if(robot.getPosition() != null){
            return robot;
        }
        else {
            throw new RobotMissingException("Robot Not Found");
        }
    }

    @Override
    public Robot place(Robot robot) {
        Robot cachedRobot = robotRepository.find();
        if(cachedRobot.getPosition() == null) {
            Position position = robot.getPosition();
            Surface surfaceLocation = robot.getSurfaceLocation();
            boolean isPositionInsideSurface = surfaceLocation.isPositionInsideSurface(position.getX(), position.getY());
            if (isPositionInsideSurface) {
                Robot placedRobot = robotRepository.place(robot);
                return placedRobot;
            } else {
                throw new InvalidPositionException("Position not valid");
            }
        }
        else{
            throw new RobotAlreadyPlacedException("Robot already placed");
        }


    }
}
