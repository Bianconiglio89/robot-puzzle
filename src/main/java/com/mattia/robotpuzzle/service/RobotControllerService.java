package com.mattia.robotpuzzle.service;


import com.mattia.robotpuzzle.model.Robot;
import com.mattia.robotpuzzle.model.Rotation;
import com.mattia.robotpuzzle.service.entities.RobotRS;
import com.mattia.robotpuzzle.service.entities.RotationRS;
import com.mattia.robotpuzzle.service.mappers.RobotMapper;
import com.mattia.robotpuzzle.service.mappers.RotationMapper;
import com.mattia.robotpuzzle.serviceInterface.RobotController;
import com.mattia.robotpuzzle.usecases.RobotManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/robot")
public class RobotControllerService implements RobotController {

    @Autowired
    private RobotManager robotManager;
    @Autowired
    private RobotMapper robotMapper;
    @Autowired
    private RotationMapper rotationMapper;

    @Override
    @RequestMapping(value="/position", method= RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public RobotRS move() {
        return robotMapper.robotToRobotRS(robotManager.move());
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/direction", method= RequestMethod.PUT)
    public RobotRS rotate(@RequestBody RotationRS rotationRS) {
        Rotation rotation = rotationMapper.rotationRSToRotation(rotationRS);
        return robotMapper.robotToRobotRS(robotManager.rotate(rotation));
    }


    @Override
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/", method= RequestMethod.GET)
    public RobotRS report() {
        return robotMapper.robotToRobotRS(robotManager.report());
    }

    @Override
    @RequestMapping(value="/", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public RobotRS place(@RequestBody RobotRS robotRS) {
        Robot robot = robotMapper.robotRStoRobot(robotRS);
        return robotMapper.robotToRobotRS(robotManager.place(robot));
    }

}