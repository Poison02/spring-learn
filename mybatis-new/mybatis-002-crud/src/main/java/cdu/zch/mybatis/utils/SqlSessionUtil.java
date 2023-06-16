package cdu.zch.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * MyBatis工具类
 * @author Zch
 * @data 2023/6/16
 **/
public class SqlSessionUtil {

    // 工具类的构造方法一般都是私有化的
    /*
    工具类的所有方法都是静态的，直接采用类名调用即可，不需要new对象
    为了防止new对象，构造方法私有化
     */
    private SqlSessionUtil() {}

    private static SqlSessionFactory sqlSessionFactory;

    // 类加载时执行 工具类在第一次加载的时候，解析mybatis-config.xml，创建sqlSessionFactory对象
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    private static SqlSession openSession() {
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        // 一个SqlSessionFactory对应一个环境，一个数据库
//        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        return sqlSession;
//    }

    /**
     * 返回会话对象
     * @return SqlSession
     */
    public static SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }

}
