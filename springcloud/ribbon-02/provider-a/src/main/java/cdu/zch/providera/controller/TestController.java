package cdu.zch.providera.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zch
 * @data 2023/6/20
 **/
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        System.out.println("provider-a接收get请求");
        return "A-OK!";
    }

}
