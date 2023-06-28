package cdu.zch.mybatis.mapper;

import cdu.zch.mybatis.pojo.Student;

import java.util.List;

/**
 * @author Zch
 * @date 2023/6/28
 **/
public interface StudentMapper {

    /**
     * 根据id获取学生信息，学生信息中含有班级信息
     * @param sid
     * @return
     */
    Student selectById(Integer sid);

    /**
     * association
     * @param sid
     * @return
     */
    Student selectByIdAssociation(Integer sid);

    /**
     * 分步查询第一步，先查出学生信息
     * @param sid
     * @return
     */
    Student selectByIdStep1(Integer sid);

    /**
     * 根据班级编号查学生
     * @param cid
     * @return
     */
    List<Student> selectByCid(Integer cid);

}
