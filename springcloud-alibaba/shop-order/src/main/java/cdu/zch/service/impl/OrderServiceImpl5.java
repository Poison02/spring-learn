package cdu.zch.service.impl;

import cdu.zch.dao.OrderDao;
import cdu.zch.entity.Order;
import cdu.zch.entity.Product;
import cdu.zch.feign.ProductService;
import cdu.zch.service.OrderService;
import com.alibaba.fastjson.JSON;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Zch
 * @date 2023/8/1
 **/
@Service(value = "orderService5")
@Slf4j
public class OrderServiceImpl5 implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Resource
    private ProductService productService;

    @Override
    public void save(Order order) {
        orderDao.save(order);
    }

    @GlobalTransactional
    @Override
    public Order createOrder(Integer pid) {
        // 1. 调用商品微服务，查询商品信息
        Product product = productService.product(pid);
        log.info("查询到{}号的商品信息：{}", pid, JSON.toJSONString(product));
        // 2. 创建订单
        Order order = new Order();
        order.setUid(1);
        order.setUsername("测试用户");
        order.setPid(pid);
        orderDao.save(order);
        log.info("创建订单成功，订单信息为{}", JSON.toJSONString(order));
        // 扣库存
        productService.reduceInventory(pid, 1);
        return order;
    }
}
