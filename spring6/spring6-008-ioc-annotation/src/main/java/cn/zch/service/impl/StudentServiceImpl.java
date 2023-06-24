package cn.zch.service.impl;

import cn.zch.dao.StudentDao;
import cn.zch.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Zch
 * @data 2023/6/24
 **/
@Service
public class StudentServiceImpl implements StudentService {

    // @Resource只能在属性或者set方法上
    // @Resource(name = "studentDaoImpl")
    @Resource
    private StudentDao studentDao;

//    @Resource(name = "studentDaoImpl")
//    public void setStudentDao(StudentDao studentDao) {
//        this.studentDao = studentDao;
//    }

    @Override
    public void generate() {
        studentDao.deleteById();
    }
}
