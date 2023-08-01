package cdu.zch.service.impl;

import cdu.zch.dao.OrderDao;
import cdu.zch.entity.Order;
import cdu.zch.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Zch
 * @date 2023/7/19
 **/
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Override
    public void save(Order order) {
        orderDao.save(order);
    }

    @Override
    public Order createOrder(Integer pid) {
        return null;
    }
}
