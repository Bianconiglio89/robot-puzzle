package com.mattia.robotpuzzle.service.mappers;

import com.mattia.robotpuzzle.model.Direction;
import com.mattia.robotpuzzle.service.entities.DirectionRS;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DirectionMapper {

    Direction directionRSToDirection(DirectionRS directionRS);

    DirectionRS directionToDirectionRS(Direction direction);

}
