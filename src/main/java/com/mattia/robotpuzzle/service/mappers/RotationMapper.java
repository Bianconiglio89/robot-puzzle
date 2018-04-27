package com.mattia.robotpuzzle.service.mappers;

import com.mattia.robotpuzzle.model.Rotation;
import com.mattia.robotpuzzle.service.entities.RotationRS;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = RotationDirectionMapper.class)
public interface RotationMapper {


    Rotation rotationRSToRotation(RotationRS rotationRS);

    RotationRS rotationRotationRS(Rotation rotation);


}
