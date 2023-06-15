package cdu.zch.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author Zch
 * @data 2023/6/15
 **/
public class MyBatisIntroductionTest {

    public static void main(String[] args) throws Exception {
        // 1. 获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 2. SqlSessionFactory对象
        // Resources.getResourceAsStream 默认从类的根路径下查找
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // InputStream inputStream = Resources.getResourceAsStream("com/mybatis-config.xml");
        // InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");
        // 一般情况下一个数据库对应一个SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        // 3. SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4. 执行SQL语句 传的参数是sql语句的id
        int row = sqlSession.insert("insertCar"); // 返回值是影响数据库表当中的记录条数
        System.out.println(row);
        // 手动提交
        sqlSession.commit();
    }

}
