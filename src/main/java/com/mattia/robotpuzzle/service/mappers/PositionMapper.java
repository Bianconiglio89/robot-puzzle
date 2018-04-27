package com.mattia.robotpuzzle.service.mappers;

import com.mattia.robotpuzzle.model.Position;
import com.mattia.robotpuzzle.service.entities.PositionRS;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PositionMapper {

    Position positionRSToPosition(PositionRS positionRS);

    PositionRS positionToPositionRS(Position position);

}
