package cdu.zch.param;

import cdu.zch.mapper.StudentMapper;
import cdu.zch.pojo.Student;
import cdu.zch.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Zch
 * @date 2023/6/25
 **/
public class StudentMapperTest {

    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByName("张三");
        students.forEach(System.out::println);
        sqlSession.close();

    }
    @Test
    public void testSelectByName() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectById(1L);
        students.forEach(System.out::println);
        sqlSession.close();

    }
    @Test
    public void testSelectByBirth() throws ParseException {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birth = sdf.parse("2023-6-25");

        List<Student> students = mapper.selectByBirth(birth);
        students.forEach(System.out::println);
        sqlSession.close();

    }
    @Test
    public void testSelectBySex() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectBySex(Character.valueOf('女'));
        students.forEach(System.out::println);
        sqlSession.close();

    }

    @Test
    public void testInsertByMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("name", "王五");
        map.put("age", 21);
        map.put("height", 1.75);
        map.put("birth", new Date());
        map.put("sex", '男');
        int row = mapper.insertStudentByMap(map);
        System.out.println(row);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertByPOJO() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setName("王五");
        student.setAge(21);
        student.setHeight(1.75);
        student.setBirth(new Date());
        student.setSex('男');
        int row = mapper.insertStudentByPOJO(student);
        System.out.println(row);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByNameAndSex() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByNameAndSex("张三", '男');
        students.forEach(System.out::println);
        sqlSession.close();

    }

    @Test
    public void testSelectByNameAndSex2() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByNameAndSex2("张三", '男');
        students.forEach(System.out::println);
        sqlSession.close();

    }

}
