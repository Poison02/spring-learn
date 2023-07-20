package cdu.zch.controller;

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

}
