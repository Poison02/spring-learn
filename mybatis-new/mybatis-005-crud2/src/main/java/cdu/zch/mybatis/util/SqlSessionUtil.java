package cdu.zch.mybatis.util;

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

    // 全局的ThreadLocal
    /*
    为什么将SqlSession对象放入ThreadLocal中，为了保证一个线程对应一个SqlSession！
     */
    private static ThreadLocal<SqlSession> local = new ThreadLocal<>();

    /**
     * 返回会话对象
     * @return SqlSession
     */
    public static SqlSession openSession() {
        SqlSession sqlSession = local.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            // 将sqlSession对象绑定到当前线程
            local.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 关闭SqlSession对象（从当前线程中移除SqlSession）
     * @param sqlSession 当前线程的sqlSession
     */
    public static void close(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
            // 移除SqlSession对象和当前线程的绑定关系
            // 因为Tomcat支持线程池
            local.remove();
        }
    }

}
