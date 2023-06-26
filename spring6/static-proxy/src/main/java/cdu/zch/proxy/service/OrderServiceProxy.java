package cdu.zch.proxy.service;

/**
 * @author Zch
 * @date 2023/6/26
 **/
// 代理对象
// 代理对象和目标对象要具有相同的行为，就要实现同一个或同一些接口
public class OrderServiceProxy implements OrderService{

    // 目标对象
    // 这里要写一个公共接口类型，因为公共接口耦合度低，关联关系 has a
    private OrderService target;
    // 创建代理对象的时候传一个目标对象


    public OrderServiceProxy(OrderService target) {
        this.target = target;
    }

    // 代理方法，代替目标方法
    @Override
    public void generate() {
        long begin = System.currentTimeMillis();
        target.generate();
        long end = System.currentTimeMillis();
        System.out.println("执行了" + (end - begin)+ "毫秒");
    }

    @Override
    public void modify() {
        long begin = System.currentTimeMillis();
        target.modify();
        long end = System.currentTimeMillis();
        System.out.println("执行了" + (end - begin)+ "毫秒");
    }

    @Override
    public void detail() {
        long begin = System.currentTimeMillis();
        target.detail();
        long end = System.currentTimeMillis();
        System.out.println("执行了" + (end - begin)+ "毫秒");
    }
}
