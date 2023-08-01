package cdu.zch.controller;

import cdu.zch.entity.Order;
import cdu.zch.service.OrderService;
import cdu.zch.service.impl.OrderServiceImpl5;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zch
 * @date 2023/8/1
 **/
@RestController
@Slf4j
public class OrderController5 {
    @Resource(name = "orderService5")
    private OrderService orderService;
    //下单
    @RequestMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid) {
        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
        return orderService.createOrder(pid);
    }
}
