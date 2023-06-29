package cdu.zch.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zch
 * @date 2023/6/29
 **/
@RestController
public class OrderController {

    @GetMapping("/doOrder")
    public String order() {
        // 模拟数据库的超时时间
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "火锅锅锅锅";
    }

}
