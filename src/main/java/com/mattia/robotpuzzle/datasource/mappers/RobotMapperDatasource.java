package com.mattia.robotpuzzle.datasource.mappers;

import com.mattia.robotpuzzle.datasource.entities.RobotEntity;
import com.mattia.robotpuzzle.model.Robot;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = {PositionMapperDatasource.class, DirectionMapperDatasource.class})
public interface RobotMapperDatasource {
    RobotEntity robotToRobotEntity(Robot robot);

    Robot robotEntityToRobot(RobotEntity robotEntity);
}
