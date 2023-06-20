package cdu.zch.providerb.controller;

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
        System.out.println("provider-b接收get请求");
        return "B-OK!";
    }

}
