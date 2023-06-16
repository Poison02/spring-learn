package cdu.zch.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Zch
 * @data 2023/6/16
 **/
public class UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    public void insert() {
//        System.out.println("数据库正在保存....");
        logger.info("数据库正在保存用户信息...");
    }

}
