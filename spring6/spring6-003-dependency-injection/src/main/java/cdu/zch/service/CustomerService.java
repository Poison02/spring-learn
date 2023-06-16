package cdu.zch.service;

import cdu.zch.dao.UserDao;

/**
 * @author Zch
 * @data 2023/6/16
 **/
public class CustomerService {

    private UserDao userDao;

//    public CustomerService(UserDao userDao) {
//        this.userDao = userDao;
//    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        System.out.println("xxxxx");
    }

}
