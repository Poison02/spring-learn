package cdu.zch.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zch
 * @date 2023/7/4
 **/
@RestController
public class BController {

    @GetMapping("/info")
    public String info() {
        return "50W";
    }

}
