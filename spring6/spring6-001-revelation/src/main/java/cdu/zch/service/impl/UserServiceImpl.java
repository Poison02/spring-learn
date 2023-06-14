package cdu.zch.service.impl;

import cdu.zch.dao.UserDao;
import cdu.zch.dao.impl.UserDaoImplForMySQL;
import cdu.zch.dao.impl.UserDaoImplForOracle;
import cdu.zch.service.UserService;

/**
 * @author Zch
 * @data 2023/6/14
 **/
public class UserServiceImpl implements UserService {

//    private UserDao userDao = new UserDaoImplForMySQL();

    // 修改为Oracle
    private UserDao userDao = new UserDaoImplForOracle();

    @Override
    public void deleteUser() {
        // 删除用户信息的业务逻辑
        userDao.deleteById();
        // 处理业务代码。。。
    }
}
