package cdu.zch.mybatis;

import cdu.zch.mybatis.mapper.ClazzMapper;
import cdu.zch.mybatis.pojo.Clazz;
import cdu.zch.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author Zch
 * @date 2023/6/28
 **/
public class ClazzMapperTest {

    @Test
    public void testSelectByCollection() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectByCollection(1000);
        System.out.println(clazz);
    }

    @Test
    public void testSelectByStep1() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectByStep1(1000);
        // System.out.println(clazz);
        System.out.println(clazz.getCid());
        System.out.println(clazz.getCname());
        System.out.println(clazz.getStus());
    }

}
