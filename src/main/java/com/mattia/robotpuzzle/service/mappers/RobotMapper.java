package com.mattia.robotpuzzle.service.mappers;

import com.mattia.robotpuzzle.model.Robot;
import com.mattia.robotpuzzle.service.entities.RobotRS;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel="spring",uses = {PositionMapper.class,DirectionMapper.class})
public interface RobotMapper {

	Robot robotRStoRobot(RobotRS robotRS);
	RobotRS robotToRobotRS(Robot robot);

}
