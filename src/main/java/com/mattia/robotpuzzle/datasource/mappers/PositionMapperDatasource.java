package com.mattia.robotpuzzle.datasource.mappers;

import com.mattia.robotpuzzle.datasource.entities.PositionEntity;
import com.mattia.robotpuzzle.model.Position;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PositionMapperDatasource {
    PositionEntity positionToPositionEntity(Position position);

    Position positionEntityToPosition(PositionEntity positionEntity);
}
