package cdu.zch.service;

import cdu.zch.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Zch
 * @data 2023/6/16
 **/
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    private UserDao userDao;

    // 这里必须写一个set方法，spring容器调用这个set方法注入，至少这个方法是以set开头
    public void setMysqlUserDao(UserDao xxx) {
        this.userDao = xxx;
    }


    public void saveUser() {
        userDao.insert();
    }

}
