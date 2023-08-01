package cdu.zch.service;

import cdu.zch.entity.Order;

/**
 * @author Zch
 * @date 2023/7/19
 **/
public interface OrderService {

    void save(Order order);

    Order createOrder(Integer pid);

}
