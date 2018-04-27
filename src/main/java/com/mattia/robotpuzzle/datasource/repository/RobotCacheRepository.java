package com.mattia.robotpuzzle.datasource.repository;

import com.mattia.robotpuzzle.datasource.entities.RobotEntity;
import com.mattia.robotpuzzle.datasource.mappers.RobotMapperDatasource;
import com.mattia.robotpuzzle.datasource.repositoryInterface.RepositoryInterface;
import com.mattia.robotpuzzle.model.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("robotCacheRepository")
public class RobotCacheRepository implements RepositoryInterface<Robot> {
	@Autowired
	private RobotEntity robotEntity;
	@Autowired
	private RobotMapperDatasource robotMapper;


	@Override
	public Robot find() {
		return robotMapper.robotEntityToRobot(this.robotEntity);
	}

	@Override
	public Robot place(Robot robot) {
		RobotEntity robotEntity = robotMapper.robotToRobotEntity(robot);
		this.robotEntity = robotEntity;
		return robotMapper.robotEntityToRobot(this.robotEntity);
	}

	@Override
	public Robot update(Robot robot) {
		return place(robot);
	}
}
