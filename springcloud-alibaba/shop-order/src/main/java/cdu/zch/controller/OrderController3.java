package cdu.zch.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zch
 * @date 2023/7/19
 **/
@RestController
@Slf4j
public class OrderController3 {

    @RequestMapping("/order/message1")
    public String message1() {
        return "message1";
    }

    @RequestMapping("/order/message2")
    public String message2() {
        return "message2";
    }

    @RequestMapping("/order/message3")
    @SentinelResource("message3") // 注意这里必须使用这个注解标识,热点规则不生效
    public String message3(String name, Integer age) {
        return name + age;
    }

    @RequestMapping("/order/message4")
    public String message4(String origin) {
        return origin;
    }

}
