package cdu.zch.proxy.service;

/**
 * @author Zch
 * @date 2023/6/26
 **/
public class OrderServiceImpl implements OrderService{ // 目标对象
    @Override
    public String getName() {
        System.out.println("getName()方法执行");
        return "zhangsan";
    }

    // 目标方法
    @Override
    public void generate() {
        // 模拟生成订单的耗时
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("订单已生成");
    }

    @Override
    public void modify() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("订单已修改");
    }

    @Override
    public void detail() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("订单详情");
    }
}
