package cdu.zch.dao.impl;

import cdu.zch.dao.UserDao;

/**
 * @author Zch
 * @data 2023/6/14
 **/
public class UserDaoImplForMySQL implements UserDao {
    @Override
    public void deleteById() {
        System.out.println("MySQL正在删除用户信息。。。");
    }
}
