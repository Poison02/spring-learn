package cdu.zch.service;

import cdu.zch.dao.UserDao;
import cdu.zch.dao.UserDaoImpl;
import cdu.zch.dao.UserDaoMysqlImpl;

/**
 * @author Zch
 **/
public class UserServiceImpl implements UserService{

//    private UserDao userDao = new UserDaoImpl();
//    private UserDao userDao = new UserDaoMysqlImpl();

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.gerUser();
    }
}
