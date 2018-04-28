package com.mattia.robotpuzzle.serviceInterface;

import com.mattia.robotpuzzle.service.entities.RobotRS;
import com.mattia.robotpuzzle.service.entities.RotationRS;

public interface RobotController {

    public RobotRS move();

    public RobotRS rotate(RotationRS rotationRS);

    public RobotRS report();

    public RobotRS place(RobotRS robot);

    public RobotRS placeOnPosition(RobotRS robotRS);

}
