package cdu.zch.mybatis;

import cdu.zch.mybatis.mapper.CarMapper;
import cdu.zch.mybatis.pojo.Car;
import cdu.zch.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Zch
 * @date 2023/6/27
 **/
public class CarMapperTest {

    @Test
    public void testSelectByMultiCondition() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByMultiCondition("宝马", 20.00D, "燃油车");
        cars.forEach(System.out::println);
    }

    @Test
    public void testSelectByMultiConditionWithWhere() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        // 三条件都不为空
        // List<Car> cars = mapper.selectByMultiConditionWithWhere("宝马", 20.00D, "燃油车");
        // 三个条件都是空
        // List<Car> cars = mapper.selectByMultiConditionWithWhere("", null, "");
        // 第一个是空
        List<Car> cars = mapper.selectByMultiConditionWithWhere("", 20.00D, "燃油车");
        cars.forEach(System.out::println);
    }

    @Test
    public void testSelectByMultiConditionWithTrim() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        // 第一个不为空，后两个为空
        List<Car> cars = mapper.selectByMultiConditionWithWhere("宝马", null, "");
        cars.forEach(System.out::println);
    }

    @Test
    public void testUpdateById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 面向接口获取接口的代理对象
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(18L, "1004", "", 40.00,"", "燃油车");
        int row = mapper.updateById(car);
        System.out.println(row);
        sqlSession.commit();
    }

    @Test
    public void testSelectWithChoose(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        //List<Car> cars = mapper.selectWithChoose("丰田霸道", 20.0, "2000-10-10");
        //List<Car> cars = mapper.selectWithChoose("", 20.0, "2000-10-10");
        //List<Car> cars = mapper.selectWithChoose("", null, "2000-10-10");
        List<Car> cars = mapper.selectWithChoose("", null, "");
        System.out.println(cars);
    }

    @Test
    public void testDeleteBatchByForeach(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        int count = mapper.deleteBatchByForeach(new Long[]{14L, 19L});
        System.out.println("删除了几条记录：" + count);
        SqlSessionUtil.openSession().commit();
    }

    @Test
    public void testDeleteBatchByForeach2(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        int count = mapper.deleteBatchByForeach2(new Long[]{40L, 41L, 42L});
        System.out.println("删除了几条记录：" + count);
        SqlSessionUtil.openSession().commit();
    }

    @Test
    public void testInsertBatchByForeach(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        Car car1 = new Car(null, "2001", "兰博基尼", 100.0, "1998-10-11", "燃油车");
        Car car2 = new Car(null, "2001", "兰博基尼", 100.0, "1998-10-11", "燃油车");
        Car car3 = new Car(null, "2001", "兰博基尼", 100.0, "1998-10-11", "燃油车");
        List<Car> cars = Arrays.asList(car1, car2, car3);
        int count = mapper.insertBatchByForeach(cars);
        System.out.println("插入了几条记录" + count);
        SqlSessionUtil.openSession().commit();
    }

    @Test
    public void testSelectListRetMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 面向接口获取接口的代理对象
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Map<String, Object>> cars = mapper.selectAllRetListMap();
        cars.forEach(System.out::println);
    }

    @Test
    public void testSelectByIdRetMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 面向接口获取接口的代理对象
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<String, Object> car = mapper.selectByIdRetMap(18L);
        System.out.println(car);
    }

}
