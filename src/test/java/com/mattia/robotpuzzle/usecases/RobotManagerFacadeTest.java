package com.mattia.robotpuzzle.usecases;

import com.mattia.robotpuzzle.datasource.repositoryInterface.RepositoryInterface;
import com.mattia.robotpuzzle.model.*;
import com.mattia.robotpuzzle.service.exceptions.RobotAlreadyPlacedException;
import com.mattia.robotpuzzle.service.exceptions.RobotMissingException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RobotManagerFacadeTest {
    @Autowired
    private RobotManagerFacade robotManager;
    @MockBean
    private RepositoryInterface repositoryInterface;
    private Robot robot;
    private Rotation rotationRight;

    @Before
    public void init() {
        robot = new Robot();
        robot.setDirection(Direction.NORTH);
        robot.setPosition(new Position(0, 0));
        rotationRight = new Rotation(RotationDirection.RIGHT);
    }

    @Test
    public void moveTest() {
        when(repositoryInterface.find()).thenReturn(robot);
        when(repositoryInterface.update(robot)).thenReturn(robot);
        Robot robot1 = new Robot();
        robot1.setDirection(Direction.NORTH);
        robot1.setPosition(new Position(0, 1));
        assertEquals(robot1, robotManager.move());
    }


    @Test
    public void rotateTest() {
        when(repositoryInterface.find()).thenReturn(robot);
        when(repositoryInterface.update(robot)).thenReturn(robot);
        Robot robot1 = new Robot();
        robot1.setDirection(Direction.EAST);
        robot1.setPosition(new Position(0, 0));
        assertEquals(robot1, robotManager.rotate(rotationRight));
    }

    @Test
    public void reportRobotFoundTest() {
        when(repositoryInterface.find()).thenReturn(robot);
        assertEquals(robot, robotManager.report());
    }

    @Test(expected = RobotMissingException.class)
    public void reportRobotNotFoundTest() {
        when(repositoryInterface.find()).thenReturn(new Robot());
        robotManager.report();
    }

    @Test
    public void placeRobotFirstTimeTest() {
        when(repositoryInterface.find()).thenReturn(new Robot());
        when(repositoryInterface.place(robot)).thenReturn(robot);
        assertEquals(robot, robotManager.place(robot));
    }

    @Test(expected = RobotAlreadyPlacedException.class)
    public void placeRobotWhenRobotAlreadyPresentTest() {
        when(repositoryInterface.find()).thenReturn(robot);
        robotManager.place(robot);
    }

}