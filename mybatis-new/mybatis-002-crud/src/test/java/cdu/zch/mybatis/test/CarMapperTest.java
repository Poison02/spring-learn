package cdu.zch.mybatis.test;

import cdu.zch.mybatis.pojo.Car;
import cdu.zch.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zch
 * @data 2023/6/16
 **/
public class CarMapperTest {

    @Test
    public void testInsertCarTest() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        /*
        insert方法参数：
            1. 参数id，在XxxMapper.xml中复制
            2. 封装数据的对象
         这里我们先试一试Map进行数据的封装
         */
//        Map<String, Object> map = new HashMap<>();
//        map.put("k1", "1111");
//        map.put("k2", "比亚迪汉");
//        map.put("k3", 10.00);
//        map.put("k4", "2020-09-23");
//        map.put("k5", "电车");
//        int row = sqlSession.insert("insertCar", map);
        // 这里使用pojo类测试
        Car car = new Car(null, "333", "比亚迪秦", 20.00,"2021-05-16", "燃油车");
        int row = sqlSession.insert("insertCar", car);
        System.out.println(row);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int row = sqlSession.delete("deleteById", 17);
        System.out.println(row);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car = new Car(15L, "1004", "凯迪拉克", 40.00,"2021-05-16", "燃油车");
        int row = sqlSession.update("updateById", car);
        System.out.println(row);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // mybatis底层执行了select语句之后，一定会返回一个结果集
        // JDBC中叫做ResultSet，mybatis从中取出数据，封装为Java对象
        Car car = sqlSession.selectOne("selectById", 15);
        System.out.println(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // mybatis底层执行了select语句之后，一定会返回一个结果集
        // JDBC中叫做ResultSet，mybatis从中取出数据，封装为Java对象
        List<Car> carList = sqlSession.selectList("selectAll");
        carList.forEach(System.out::println);
        sqlSession.commit();
        sqlSession.close();
    }

}
