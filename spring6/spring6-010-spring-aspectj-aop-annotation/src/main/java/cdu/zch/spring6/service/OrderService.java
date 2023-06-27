package cdu.zch.spring6.service;

import org.springframework.stereotype.Service;

/**
 * @author Zch
 * @date 2023/6/27
 **/
@Service("orderService")
public class OrderService {

    public void generate() {
        System.out.println("正在生成订单...");
        /*if(1 == 1) {
            throw new RuntimeException("运行时异常");
        }*/
    }

}
