package cdu.zch.mapper;

import cdu.zch.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Zch
 * @date 2023/6/25
 **/
public interface StudentMapper {

    /**
     * 当接口中的方法的参数只有一个（单个参数），比能切参数的数据类型都是简单类型
     * id、name、birth、sex
     */
    List<Student> selectById(Long id);
    List<Student> selectByName(String name);
    List<Student> selectByBirth(Date birth);
    List<Student> selectBySex(Character sex);

    /*
    通过map添加学生
     */
    int insertStudentByMap(Map<String, Object> map);

    int insertStudentByPOJO(Student student);

    /*
    * 多参数处理
    * mybatis是怎么做的呢？多参数的情况下
    *   mybatis框架会自动创建一个Map集合，并且Map集合是以这个方式存储参数的
    *       map.put("arg0", name);
    *       map.put("arg1", sex);
    *       map.put("param1", name);
    *       map.put("param2", sex);
    * */
    List<Student> selectByNameAndSex(String name, Character sex);

    /*
     * 这个方法使用Param注解
     * mybatis底层的实现：
     *     map.put("name", name);
     *     map.put("sex", sex);
     *     map.put("param1", name);
     *     map.put("param2", sex);
     */
    List<Student> selectByNameAndSex2(@Param("name") String name,@Param("sex") Character sex);
}
