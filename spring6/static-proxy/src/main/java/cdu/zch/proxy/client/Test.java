package cdu.zch.proxy.client;

import cdu.zch.proxy.service.OrderService;
import cdu.zch.proxy.service.OrderServiceImpl;
import cdu.zch.proxy.service.OrderServiceProxy;

/**
 * @author Zch
 * @date 2023/6/26
 **/
public class Test {

    public static void main(String[] args) {
        /*OrderService orderService = new OrderServiceImpl();
        orderService.generate();
        orderService.modify();
        orderService.detail();*/

        /*
        代理模式：
            优点1：解决了OCP问题
            优点2：采用代理模式的has a，可以降低耦合度
            缺点：目前使用的静态代理，类爆炸，假设接口有很多，就必须写很多代理类，不好维护...
        后面会使用动态代理，添加了字节码技术，可以在内存中动态的生成class字节码，这个字节码就是代理类
        在内存中动态的生成字节码代理类的技术，叫做动态代理
         */
        // 下面使用代理
        // 创建目标对象
        OrderService target = new OrderServiceImpl();
        // 创建代理对象
        OrderService proxy = new OrderServiceProxy(target);
        // 调用代理对象的方法
        proxy.generate();
        proxy.modify();
        proxy.detail();
    }

}
