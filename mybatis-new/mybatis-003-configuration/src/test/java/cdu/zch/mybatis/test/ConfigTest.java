package cdu.zch.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**
 * @author Zch
 * @data 2023/6/17
 **/
public class ConfigTest {

    @Test
    public void testEnvironment() throws Exception{
        // 获取SqlSessionFactory对象 默认方式获取
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 这里使用的是default的环境
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));

        // 这里使用指定的环境
        SqlSessionFactory sqlSessionFactory1 = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"), "mybatisDB");


    }

    @Test
    public void testPool() throws Exception{
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        sqlSession1.insert("insertCar");
        sqlSession1.commit();
        sqlSession1.close();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        sqlSession2.insert("insertCar");
        sqlSession2.commit();
        sqlSession2.close();
    }

}
