package cdu.zch.mybatis;

import cdu.zch.mybatis.mapper.CarMapper;
import cdu.zch.mybatis.pojo.Car;
import cdu.zch.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Zch
 * @date 2023/6/27
 **/
public class CarMapperTest {

    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(18L);
        System.out.println(car);

        // 这个执行 发现触发一级缓存，只执行一条SQL语句
        /*Car car1 = mapper.selectById(18L);
        System.out.println(car1);*/
        sqlSession.close();
    }

    /*
    一级缓存存在于：SqlSession
    二级缓存存在于：SqlSessionFactory
    思考：
        什么时候不走缓存？SqlSession不是同一个；查询条件不一样也不走缓存
        什么时候一级缓存失效？
            第一次DQL和第二次DQL中间做了以下事情中的任意一件，都会失效一级缓存
                1. 执行sqlSession.clearCache() ，手动清空缓存
                2. 执行INSERT、DELETE、UPDATE中的任意语句，与表没有关系，只要有这些语句之一都会使缓存失效
    */

    @Test
    public void testSelectById2() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        CarMapper mapper1 = sqlSession1.getMapper(CarMapper.class);
        CarMapper mapper2 = sqlSession2.getMapper(CarMapper.class);

        // 这段代码执行之后，实际上数据只是在一级缓存
        Car car1 = mapper1.selectById2(18L);
        System.out.println(car1);

        sqlSession1.close();
        // 这里不关闭sqlSession1，二级缓存中还是没有数据

        // 这段代码执行之后，实际上数据只是在一级缓存
        Car car2 = mapper2.selectById2(18L);
        System.out.println(car2);

        // 程序执行到这里，数据就会从一级缓存到二级缓存
        // sqlSession1.close();
        sqlSession2.close();

    }

}
