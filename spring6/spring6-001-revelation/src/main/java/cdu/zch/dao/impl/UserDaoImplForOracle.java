package cdu.zch.dao.impl;

import cdu.zch.dao.UserDao;

/**
 * @author Zch
 * @data 2023/6/14
 **/
public class UserDaoImplForOracle implements UserDao {

    @Override
    public void deleteById() {
        System.out.println("Oracle 正在删除数据。。。");
    }
}
