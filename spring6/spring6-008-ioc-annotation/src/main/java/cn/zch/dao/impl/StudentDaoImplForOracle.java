package cn.zch.dao.impl;

import cn.zch.dao.StudentDao;
import org.springframework.stereotype.Repository;

/**
 * @author Zch
 * @data 2023/6/24
 **/
@Repository("studentDaoImplForOracle")
public class StudentDaoImplForOracle implements StudentDao {
    @Override
    public void deleteById() {
        System.out.println("Oracle正在删除信息...");
    }
}
