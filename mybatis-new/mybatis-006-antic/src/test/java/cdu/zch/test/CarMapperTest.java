package cdu.zch.test;

import cdu.zch.mybatis.mapper.CarMapper;
import cdu.zch.mybatis.pojo.Car;
import cdu.zch.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author Zch
 * @data 2023/6/24
 **/
public class CarMapperTest {

    @Test
    public void testSelectByCarType() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = carMapper.selectByCarType("燃油车");
        cars.forEach(System.out::println);
    }

    @Test
    public void testSelectAllByAscOrDesc() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = carMapper.selectAllByAscOrDesc("asc");
        cars.forEach(System.out::println);
    }

}
