package cdu.zch.test;

import cdu.zch.mybatis.mapper.CarMapper;
import cdu.zch.mybatis.pojo.Car;
import cdu.zch.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author Zch
 * @date 2023/6/26
 **/
public class CarMapperTest {

    @Test
    public void testInsertCarTest() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 面向接口获取接口的代理对象
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null, "333", "比亚迪秦", 20.00,"2021-05-16", "燃油车");
        int row = mapper.insert(car);
        System.out.println(row);
        sqlSession.commit();
    }

    @Test
    public void testDeleteById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 面向接口获取接口的代理对象
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int row = mapper.deleteById(15L);
        System.out.println(row);
        sqlSession.commit();
    }

    @Test
    public void testUpdateById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 面向接口获取接口的代理对象
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(18L, "1004", "凯迪拉克", 40.00,"2021-05-16", "燃油车");
        int row = mapper.update(car);
        System.out.println(row);
        sqlSession.commit();
    }

    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 面向接口获取接口的代理对象
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(18L);
        System.out.println(car);
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 面向接口获取接口的代理对象
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> carList = mapper.selectAll();
        carList.forEach(System.out::println);
    }

    @Test
    public void testSelectByIdRetMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 面向接口获取接口的代理对象
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<String, Object> car = mapper.selectByIdRetMap(18L);
        System.out.println(car);
    }

    @Test
    public void testSelectRetMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 面向接口获取接口的代理对象
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Map<String, Object>> cars = mapper.selectRetMap();
        cars.forEach(System.out::println);
    }

    @Test
    public void testSelectAllRetMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 面向接口获取接口的代理对象
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<Long, Map<String, Object>> cars = mapper.selectAllRetMap();
        System.out.println(cars);
    }

    @Test
    public void testSelectAllResultMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 面向接口获取接口的代理对象
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAllByResultMap();
        cars.forEach(System.out::println);
    }

    @Test
    public void testSelectAllMapUnderscoreToCamelCase() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 面向接口获取接口的代理对象
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAllByMapUnderscoreToCamelCase();
        cars.forEach(System.out::println);
    }
}
