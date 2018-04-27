package com.mattia.robotpuzzle.service.mappers;

import com.mattia.robotpuzzle.model.RotationDirection;
import com.mattia.robotpuzzle.service.entities.RotationDirectionRS;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RotationDirectionMapper {

    RotationDirectionRS rotationToRotationDirectionRS(RotationDirection rotationDirection);

    RotationDirection rotationDirectionRSToRotationDirection(RotationDirectionRS rotationDirectionRS);

}
