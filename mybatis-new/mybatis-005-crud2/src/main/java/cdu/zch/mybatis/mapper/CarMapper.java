package cdu.zch.mybatis.mapper;

import cdu.zch.mybatis.pojo.Car;

import java.util.List;

/**
 * @author Zch
 * @data 2023/6/24
 **/
public interface CarMapper {

    int insert(Car car);

    int deleteById(Long id);

    int update(Car car);

    Car selectById(Long id);

    List<Car> selectAll();

}
