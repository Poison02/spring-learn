package cdu.zch.spring6.service;

import org.springframework.stereotype.Service;

/**
 * @author Zch
 * @date 2023/6/27
 **/
@Service("orderService")
public class OrderService {

    public void generate() {
        System.out.println("正在生成订单...00");
    }

    public void cancel() {
        System.out.println("订单正在取消...00");
        String s = null;
        s.toString();
    }

}
