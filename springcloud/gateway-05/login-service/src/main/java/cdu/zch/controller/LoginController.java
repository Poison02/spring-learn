package cdu.zch.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Zch
 * @date 2023/6/30
 **/
@RestController
public class LoginController {

    @GetMapping("/login")
    public String login(String name, String pwd) {
        System.out.println(name);
        System.out.println(pwd);
        return UUID.randomUUID().toString();
    }

}
