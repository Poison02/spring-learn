package cdu.zch.mybatis;

import cdu.zch.mybatis.mapper.StudentMapper;
import cdu.zch.mybatis.pojo.Student;
import cdu.zch.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author Zch
 * @date 2023/6/28
 **/
public class StudentMapperTest {

    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectById(1);
        System.out.println(student.getSid());
        System.out.println(student.getSname());
        System.out.println(student.getClazz());
        sqlSession.close();
    }

    @Test
    public void testSelectByIdAssociation() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectByIdAssociation(1);
        System.out.println(student.getSid());
        System.out.println(student.getSname());
        System.out.println(student.getClazz());
        sqlSession.close();
    }

    @Test
    public void testSelectByIdStep1() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectByIdStep1(1);
        System.out.println(student.getSid());
        System.out.println(student.getSname());
        // 试试延迟加载
        System.out.println(student.getClazz());
        sqlSession.close();
    }

}
