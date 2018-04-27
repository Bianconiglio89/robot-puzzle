package com.mattia.robotpuzzle.usecases;

import com.mattia.robotpuzzle.model.Robot;
import com.mattia.robotpuzzle.model.Rotation;

public interface RobotManagerFacade {

    public Robot move();

    public Robot rotate(Rotation rotation);

    public Robot report();

    public Robot place(Robot robot);

}
