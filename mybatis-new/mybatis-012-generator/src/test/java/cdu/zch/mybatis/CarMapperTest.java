package cdu.zch.mybatis;

import cdu.zch.mybatis.mapper.CarMapper;
import cdu.zch.mybatis.pojo.Car;
import cdu.zch.mybatis.pojo.CarExample;
import cdu.zch.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Zch
 * @date 2023/6/27
 **/
public class CarMapperTest {

    // CarExample负责封装查询条件的
    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        // 1. 查询一个
        Car car = mapper.selectByPrimaryKey(18L);
        System.out.println(car);
        // 2. 查询所有（selectByExample，根据条件查询，null表示没有条件）
        List<Car> cars = mapper.selectByExample(null);
        cars.forEach(System.out::println);
        System.out.println("---------------------");
        // 3. 按照条件查询
        // QBC 风格：Query By Criteria 一种查询方式，比较面向对象，看不到sql语句。
        // 封装查询条件，通过CarExample封装
        CarExample carExample = new CarExample();
        // 通过carExample.createCriteria()方法创造查询条件
        carExample.createCriteria()
                        .andBrandLike("兰博")
                        .andGuidePriceGreaterThan(new BigDecimal(20.0));
        carExample.or().andCarTypeEqualTo("燃油车");
        List<Car> cars1 = mapper.selectByExample(carExample);
        cars1.forEach(System.out::println);
        sqlSession.close();
    }

}
