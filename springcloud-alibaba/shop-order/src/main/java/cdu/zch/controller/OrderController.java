package cdu.zch.controller;

import cdu.zch.entity.Order;
import cdu.zch.entity.Product;
import cdu.zch.feign.ProductService;
import cdu.zch.service.OrderService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

/**
 * @author Zch
 * @date 2023/7/19
 **/
@RestController
@Slf4j
public class OrderController {

    /*@Resource
    private RestTemplate restTemplate;*/

    @Resource
    private OrderService orderService;

    @Resource
    private ProductService productService;

    /*@Resource
    private DiscoveryClient discoveryClient;*/

    @GetMapping("/order1/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid) {
        log.info("客户下单，这时候调用商品微服务查询商品信息");;

        // 从nacos中获得服务地址
        /*// 自定义规则实现负载均衡
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
        int index = new Random().nextInt(instances.size());
        ServiceInstance serviceInstance = instances.get(index);
        String url = serviceInstance.getHost() + ":" + serviceInstance.getPort();*/

        // 直接使用微服务名字，从nacos中获取
        /*String url = "service-product";
        log.info("从nacos中获取到的微服务地址为：" + url);

        // 通过restTemplate调用
        Product product = restTemplate.getForObject(
                "http://" + url + "/product/" + pid, Product.class
        );*/

        // 通过OpenFeign调用微服务
        Product product = productService.product(pid);
        if (product == null) {
            return null;
        }
        Order order = new Order();
        order.setUid(1);
        order.setUsername("Tom");
        order.setPid(product.getPid());

        // 存储数据库
        orderService.save(order);
        return order;
    }

}
