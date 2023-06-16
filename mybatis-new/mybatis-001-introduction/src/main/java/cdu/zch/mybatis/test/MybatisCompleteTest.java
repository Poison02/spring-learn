package cdu.zch.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 一个完整版的mybatis程序
 * @author Zch
 * @data 2023/6/16
 **/
public class MybatisCompleteTest {

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try{
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            sqlSession = sqlSessionFactory.openSession();
            // 执行SQL语句，处理相关业务
            int row = sqlSession.insert("insertCar");
            System.out.println(row);
            // 执行到这里，没有发生任何一场，提交事务
            sqlSession.commit();
        } catch (Exception e) {
            // 最好回滚事务
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            e.printStackTrace();
        } finally {
            // 关闭会话
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

}
