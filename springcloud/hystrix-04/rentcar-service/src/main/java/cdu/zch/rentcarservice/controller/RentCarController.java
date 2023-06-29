package cdu.zch.rentcarservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zch
 * @date 2023/6/29
 **/
@RestController
public class RentCarController {

    @GetMapping("/rent")
    public String rent() {
        System.out.println("租车成功！");
        return "租车成功！";
    }

}
