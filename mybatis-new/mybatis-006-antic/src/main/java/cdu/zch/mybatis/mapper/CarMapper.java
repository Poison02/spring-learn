package cdu.zch.mybatis.mapper;

import cdu.zch.mybatis.pojo.Car;

import java.util.List;

/**
 * @author Zch
 * @data 2023/6/24
 **/
public interface CarMapper {

    List<Car> selectByCarType(String carType);

    List<Car> selectAllByAscOrDesc(String ascOrDesc);

}
