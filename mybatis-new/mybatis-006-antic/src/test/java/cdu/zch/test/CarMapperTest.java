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
        CarMapper carMapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        List<Car> cars = carMapper.selectAllByAscOrDesc("asc");
        cars.forEach(System.out::println);
    }

    @Test
    public void testInsertCarUserGeneratedKeys() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null, "333", "比亚迪秦", 20.00,"2021-05-16", "燃油车");
        carMapper.insertCarUserGeneratedKeys(car);
        System.out.println(car);
        sqlSession.commit();
        sqlSession.close();
    }

}
