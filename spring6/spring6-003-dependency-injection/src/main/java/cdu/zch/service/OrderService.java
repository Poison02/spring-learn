package cdu.zch.service;

import cdu.zch.dao.OrderDao;
import cdu.zch.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Zch
 * @data 2023/6/16
 **/
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    private OrderDao orderDao;

    // 通过set方法赋值
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void generate() {
       orderDao.insert();
    }
}
