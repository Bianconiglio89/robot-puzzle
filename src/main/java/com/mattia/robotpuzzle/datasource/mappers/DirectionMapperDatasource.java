package com.mattia.robotpuzzle.datasource.mappers;

import com.mattia.robotpuzzle.datasource.entities.DirectionEntity;
import com.mattia.robotpuzzle.model.Direction;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface DirectionMapperDatasource {
	Direction directionEntityToDirection(DirectionEntity directionEntity);
	DirectionEntity directionToDirectionEntity(Direction direction);
}
