package cdu.zch.controller;

import cdu.zch.entity.Order;
import cdu.zch.entity.Product;
import cdu.zch.feign.ProductService;
import cdu.zch.service.OrderService;
import com.alibaba.fastjson.JSON;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zch
 * @date 2023/7/19
 **/
@RestController
@Slf4j
public class OrderController2 {

    @Resource
    private OrderService orderService;

    @Resource
    private ProductService productService;

    @GetMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid) {
        // 调用商品微服务,查询商品信息
        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
        // 通过OpenFeign调用微服务
        Product product = productService.product(pid);
        log.info("查询到{}号商品的信息,内容是:{}", pid, JSON.toJSONString(product));

        if (product == null) {
            return null;
        }

        //模拟一次网络延时
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Order order = new Order();
        order.setUid(1);
        order.setUsername("Tom");
        order.setPid(product.getPid());

        // 暂时不做存储
        // orderService.save(order);
        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
        return order;
    }

    @RequestMapping("/order/message")
    public String message() {
        return "高并发下的问题测试";
    }

}
