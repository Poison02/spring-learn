package cn.zch.dao.impl;

import cn.zch.dao.StudentDao;
import org.springframework.stereotype.Repository;

/**
 * @author Zch
 * @data 2023/6/24
 **/
@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {
    @Override
    public void deleteById() {
        System.out.println("MySQL正在删除信息...");
    }
}
